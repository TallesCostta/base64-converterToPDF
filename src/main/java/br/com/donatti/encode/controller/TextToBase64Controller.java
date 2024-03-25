/**
 * @author Tales Paiva [tales.paiva@cagece.com.br] 24/03/2024 - 19:31:53
 */
package br.com.donatti.encode.controller;

import java.io.Serializable;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.donatti.business.NgcTextToBase64;
import br.com.donatti.entities.Base64EncodeDTO;
import br.com.donatti.entities.ErroPadraoVO;
import br.com.donatti.entities.RetornoPadraoErroVO;
import br.com.donatti.exceptions.IllegalParameterConverterException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Tales Paiva [tales.paiva@cagece.com.br] 24/03/2024 - 19:31:53
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/Base64Tools")
public class TextToBase64Controller implements Serializable {
	
	/**
	 * @author Tales Paiva [tales.paiva@cagece.com.br] 24/03/2024 - 23:50:52
	 */
	private static final long serialVersionUID = 2835825983939905175L;
	
	@Autowired
	private NgcTextToBase64 ngcTextToBase64;

	@PostMapping("/encode/Text")
	public ResponseEntity<?> convertToBase64(@RequestBody Base64EncodeDTO jsonBodyRequest) 
	{
		try 
		{
			return ngcTextToBase64.codificarTextEmBase64(jsonBodyRequest);
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
					Arrays.asList(new ErroPadraoVO("Não foi possível converter arquivo Text para base64", HttpStatus.INTERNAL_SERVER_ERROR.value()))));
		}
	}
	
}
