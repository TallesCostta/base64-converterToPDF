package br.com.donatti.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import br.com.donatti.entities.Base64DecodeDTO;
import br.com.donatti.exceptions.IllegalParameterConverterException;

/**
 * @author Donatti [tallescosttapaiva@gmail.com] 24/03/2024 - 00:37:33
 */
@Service
public class ArquivoUtil implements Serializable {

	@Autowired
	private StringUtil stringUtil;
	
	/**
	 * @author Donatti [tallescosttapaiva@gmail.com] 24/03/2024 - 00:42:36
	 */
	private static final long serialVersionUID = 1538916706148037545L;

	/**
	 * @author Donatti [tallescosttapaiva@gmail.com] 24/03/2024 - 00:40:16
	 *
	 * @param arquivoDecodificado
	 * @throws IOException
	 */
	public ByteArrayOutputStream escreverArquivoByteEmMemoria(byte[] arquivoDecodificado) throws IOException 
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try 
		{
			baos.write(arquivoDecodificado);			
		} 
		catch (Exception e) 
		{
			throw new IOException("Não foi possível escrever o arquivo em memória");
		}
		
	    return baos;
	}
	
	/**
	 * @author Donatti [tallescosttapaiva@gmail.com] 24/03/2024 - 00:40:44
	 *
	 * @param nomeArquivo
	 * @return
	 */
	public HttpHeaders configurarHeaders(String nomeArquivo, MediaType MediaType, String extensaoArquivo) 
	{
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType);
		headers.setContentDispositionFormData(stringUtil.removerAcentuacao(nomeArquivo), 
				stringUtil.renomearArquivoPDF(nomeArquivo, extensaoArquivo));
		
		return headers;
	}
	
	/**
	 * @author Donatti [tallescosttapaiva@gmail.com] 24/03/2024 - 00:44:30
	 *
	 * @param nomeArquivoFormatado
	 * @throws IOException
	 */
	public void deletarArquivoAposLeitura(String nomeArquivoFormatado) throws IOException 
	{
		try 
		{			
			Files.deleteIfExists(Paths.get(nomeArquivoFormatado));
		} 
		catch (Exception e) 
		{
			throw new IOException("Não foi possível remover o arquivo da memória após a leitura");
		}
	}
	
	/**
	 * @author Donatti [tallescosttapaiva@gmail.com] 24/03/2024 - 23:20:53
	 *
	 * @param jsonBodyRequest
	 * @return
	 * @throws IllegalParameterConverterException
	 */
	public byte[] decodificarBase64(Base64DecodeDTO jsonBodyRequest) throws IllegalParameterConverterException {
		if (jsonBodyRequest.getBase64Data() != null && !jsonBodyRequest.getBase64Data().trim().isEmpty()) 
		{				
			try 
			{
				return Base64.decodeBase64(jsonBodyRequest.getBase64Data());			
			}
			catch (Exception e) 
			{
				throw new IllegalParameterConverterException("Erro ao decodificar arquivo: base64 inválido ou corrompido!");
			}
		}
		else 
		{
			throw new IllegalParameterConverterException("Preencha o campo 'base64Data' para prosseguir com a decodificação!");
			
		}
	}
	
}
