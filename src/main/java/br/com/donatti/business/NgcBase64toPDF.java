package br.com.donatti.business;

import java.io.IOException;
import java.io.Serializable;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.donatti.entities.Base64DTO;
import br.com.donatti.utils.ArquivoUtil;

/**
 * @author Donatti [tallescosttapaiva@gmail.com] 24/03/2024 - 00:33:22
 */
@Service
public class NgcBase64toPDF implements Serializable {
	
	@Autowired
	private ArquivoUtil arquivoUtil;
	
	/**
	 * @author Donatti [tallescosttapaiva@gmail.com] 24/03/2024 - 00:33:35
	 */
	private static final long serialVersionUID = 4703613583531447372L;
	
	/**
	 * @author Donatti [tallescosttapaiva@gmail.com] 24/03/2024 - 00:48:43
	 *
	 * @param jsonBodyRequest
	 * @return
	 * @throws IOException
	 */
	public ResponseEntity<?> converterArquivoBase64ToPDF(Base64DTO jsonBodyRequest) throws IOException 
	{
		return new ResponseEntity<>(
				arquivoUtil.escreverArquivoEmMemoria(Base64.decodeBase64(jsonBodyRequest.getBase64Data())).toByteArray(),
				arquivoUtil.configurarHeaders(jsonBodyRequest.getNomeArquivo()), HttpStatus.OK);
	}

}
