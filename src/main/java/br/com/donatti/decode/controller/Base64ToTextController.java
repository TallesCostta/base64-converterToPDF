package br.com.donatti.decode.controller;

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

import br.com.donatti.business.NgcBase64toText;
import br.com.donatti.entities.Base64DecodeDTO;
import br.com.donatti.entities.ErroPadraoVO;
import br.com.donatti.entities.RetornoPadraoErroVO;
import br.com.donatti.exceptions.IllegalParameterConverterException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Tales Paiva [tales.paiva@cagece.com.br] 24/03/2024 - 16:44:10
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/Base64Tools")
public class Base64ToTextController implements Serializable {

	/**
	 * @author Tales Paiva [tales.paiva@cagece.com.br] 24/03/2024 - 16:44:37
	 */
	private static final long serialVersionUID = 7782354174590268272L;

	@Autowired
	private NgcBase64toText ngcBase64toText;
	
	@PostMapping(value = "/decode/Text", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> convertBase64ToText(@RequestBody Base64DecodeDTO jsonBodyRequest) 
	{
		 try 
	        {
				return ngcBase64toText.converterArquivoBase64ToText(jsonBodyRequest);
	        } 
			catch (IllegalParameterConverterException e) 
			{
				log.error(e.getMessage());
				return ResponseEntity.status(HttpStatus.CONFLICT).body(new RetornoPadraoErroVO(
						Arrays.asList(new ErroPadraoVO(e.getMessage(), HttpStatus.CONFLICT.value()))));
			} 
			catch (Exception e) 
			{
				log.error(e.getMessage());
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new RetornoPadraoErroVO(
						Arrays.asList(new ErroPadraoVO("Não foi possível converter arquivo base64 para Text", HttpStatus.INTERNAL_SERVER_ERROR.value()))));
			}
	}
}
