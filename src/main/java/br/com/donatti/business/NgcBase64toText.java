package br.com.donatti.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.donatti.entities.Base64DecodeDTO;
import br.com.donatti.entities.Base64ToTextVO;
import br.com.donatti.entities.RetornoPadraoSucessoVO;
import br.com.donatti.exceptions.IllegalParameterConverterException;
import br.com.donatti.utils.ArquivoUtil;

/**
 * @author Donatti [tallescosttapaiva@gmail.com] 24/03/2024 - 16:51:25
 */
@Service
public class NgcBase64toText implements NgcRetornoPadrao {

	@Autowired
	private ArquivoUtil arquivoUtil;
	
	/**
	 * @author Donatti [tallescosttapaiva@gmail.com] 24/03/2024 - 00:48:43
	 *
	 * @param jsonBodyRequest
	 * @return
	 * @throws IllegalParameterConverterException
	 */
	public ResponseEntity<RetornoPadraoSucessoVO> converterArquivoBase64ToText(Base64DecodeDTO jsonBodyRequest) throws IllegalParameterConverterException
	{
		return new ResponseEntity<>(
				preencherRetornoPadraoSucesso(new String(arquivoUtil.decodificarBase64(jsonBodyRequest))), HttpStatus.OK);
	}

	/**
	 * @author Donatti [tallescosttapaiva@gmail.com] 24/03/2024 - 20:28:21
	 */
	@Override
	public RetornoPadraoSucessoVO preencherRetornoPadraoSucesso(Object resultado) 
	{
		return new RetornoPadraoSucessoVO(HttpStatus.OK.value(), "Arquivo base64 convertido em Text com sucesso!",
				new Base64ToTextVO(resultado.toString()));
	}

}
