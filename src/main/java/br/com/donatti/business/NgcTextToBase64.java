/**
 * @author Donatti [tallescosttapaiva@gmail.com] 24/03/2024 - 23:49:44
 */
package br.com.donatti.business;

import java.util.Base64;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.donatti.entities.Base64EncodeDTO;
import br.com.donatti.entities.Base64ToTextVO;
import br.com.donatti.entities.RetornoPadraoSucessoVO;
import br.com.donatti.exceptions.IllegalParameterConverterException;

/**
 * @author Donatti [tallescosttapaiva@gmail.com] 24/03/2024 - 23:49:44
 */
@Service
public class NgcTextToBase64 implements NgcRetornoPadrao {

	/**
	 * @author Donatti [tallescosttapaiva@gmail.com] 24/03/2024 - 23:44:46
	 *
	 * @param jsonBodyRequest
	 * @return
	 */
	public ResponseEntity<?> codificarTextEmBase64(Base64EncodeDTO jsonBodyRequest) 
	{
		return new ResponseEntity<>(preencherRetornoPadraoSucesso(getBase64Txt(jsonBodyRequest)), HttpStatus.OK);
	}

	/**
	 * @author Donatti [tallescosttapaiva@gmail.com] 24/03/2024 - 23:52:59
	 *
	 * @param jsonBodyRequest
	 * @return
	 * @throws IllegalParameterConverterException
	 */
	private String getBase64Txt(Base64EncodeDTO jsonBodyRequest) throws IllegalParameterConverterException
	{
		if (jsonBodyRequest.getEncodeData() != null && !jsonBodyRequest.getEncodeData().trim().isEmpty()) 
		{			
			return Base64.getEncoder().encodeToString(jsonBodyRequest.getEncodeData().getBytes());
		} 
		else
		{
			throw new IllegalParameterConverterException("Preencha o atriburo 'textData' para prosseguir com a codificação!");
		}
	}
	
	/**
	 * @author Donatti [tallescosttapaiva@gmail.com] 24/03/2024 - 23:49:44
	 */
	@Override
	public RetornoPadraoSucessoVO preencherRetornoPadraoSucesso(Object resultado) 
	{
		return new RetornoPadraoSucessoVO(HttpStatus.OK.value(), "Arquivo Text convertido em base64 com sucesso!",
				new Base64ToTextVO(resultado.toString()));
	}

}
