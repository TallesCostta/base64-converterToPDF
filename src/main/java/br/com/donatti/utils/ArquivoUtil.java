package br.com.donatti.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

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
	public ByteArrayOutputStream escreverArquivoEmMemoria(byte[] arquivoDecodificado) throws IOException 
	{
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    baos.write(arquivoDecodificado);
	    return baos;
	}
	
	/**
	 * @author Donatti [tallescosttapaiva@gmail.com] 24/03/2024 - 00:40:44
	 *
	 * @param nomeArquivo
	 * @return
	 */
	public HttpHeaders configurarHeaders(String nomeArquivo) 
	{
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentDispositionFormData(stringUtil.removerAcentuacao(nomeArquivo), 
				stringUtil.renomearArquivoPDF(nomeArquivo, Constants.FILE_TYPE_PDF));
		
		return headers;
	}
	
	/**
	 * @author Tales Paiva [tales.paiva@cagece.com.br] 24/03/2024 - 00:44:30
	 *
	 * @param nomeArquivoFormatado
	 * @throws IOException
	 */
	public void deletarArquivoAposLeitura(String nomeArquivoFormatado) throws IOException 
	{
		Files.deleteIfExists(Paths.get(nomeArquivoFormatado));
	}
}
