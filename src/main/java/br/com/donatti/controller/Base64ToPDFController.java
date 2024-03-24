package br.com.donatti.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.donatti.business.NgcBase64toPDF;
import br.com.donatti.entities.Base64DTO;

/**
 * 
 * @author Donatti [tallescosttapaiva@gmail.com] 14/06/2023 - 04:19:35
 *
 */
@RestController
@RequestMapping("/api/v1/convertBase64")
public class Base64ToPDFController {
	
	@Autowired
	private NgcBase64toPDF ngcBase64toPDF;

	@PostMapping(value = "/PDF", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> convertBase64ToPdf(@RequestBody Base64DTO jsonBodyRequest) 
	{
        try 
        {
			return ngcBase64toPDF.converterArquivoBase64ToPDF(jsonBodyRequest);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao converter arquivo base64 em PDF!");
        }
	}
	
}
