package br.com.donatti.decode.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.donatti.business.NgcBase64toPDF;
import br.com.donatti.entities.Base64DecodeDTO;
import br.com.donatti.entities.ErroPadraoVO;
import br.com.donatti.entities.RetornoPadraoErroVO;
import br.com.donatti.exceptions.IllegalParameterConverterException;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Donatti [tallescosttapaiva@gmail.com] 14/06/2023 - 04:19:35
 *
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/Base64Tools")
public class Base64ToPDFController implements Serializable {

	/**
	 * @author Donatti [tallescosttapaiva@gmail.com] 24/03/2024 - 16:47:40
	 */
	private static final long serialVersionUID = -3239995793648627842L;

	@Autowired
	private NgcBase64toPDF ngcBase64toPDF;

	@PostMapping(value = "/decode/PDF", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> convertBase64ToPdf(@RequestBody Base64DecodeDTO jsonBodyRequest) 
	{
		try 
		{
			return ngcBase64toPDF.converterArquivoBase64ToPDF(jsonBodyRequest);
		} 
		catch (IOException | IllegalParameterConverterException e) 
		{
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.CONFLICT).body(new RetornoPadraoErroVO(
					Arrays.asList(new ErroPadraoVO(e.getMessage(), HttpStatus.CONFLICT.value()))));
		} 
		catch (Exception e) 
		{
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new RetornoPadraoErroVO(
					Arrays.asList(new ErroPadraoVO("Não foi possível converter arquivo base64 para PDF", HttpStatus.INTERNAL_SERVER_ERROR.value()))));
		}
	}

}
