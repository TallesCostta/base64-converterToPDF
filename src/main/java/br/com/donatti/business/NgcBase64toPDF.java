package br.com.donatti.business;

import java.io.IOException;
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.donatti.entities.Base64DecodeDTO;
import br.com.donatti.exceptions.IllegalParameterConverterException;
import br.com.donatti.utils.ArquivoUtil;
import br.com.donatti.utils.Constants;

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
	 * @throws IllegalParameterConverterException
	 */
	public ResponseEntity<?> converterArquivoBase64ToPDF(Base64DecodeDTO jsonBodyRequest) throws IOException, IllegalParameterConverterException
	{
		return new ResponseEntity<>(
				arquivoUtil.escreverArquivoByteEmMemoria(arquivoUtil.decodificarBase64(jsonBodyRequest)).toByteArray(),
				arquivoUtil.configurarHeaders(jsonBodyRequest.getNomeArquivo(), MediaType.APPLICATION_PDF, Constants.FILE_TYPE_PDF),HttpStatus.OK);
	}

}
