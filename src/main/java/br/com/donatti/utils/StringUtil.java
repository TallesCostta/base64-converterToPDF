package br.com.donatti.utils;

import java.io.Serializable;
import java.text.Normalizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StringUtil implements Serializable {
	
	@Autowired
	private DataUtil dataUtil;
	
	/**
	 * @author Donatti [tallescosttapaiva@gmail.com] 24/03/2024 - 00:26:21
	 */
	private static final long serialVersionUID = -3218180409855288296L;

	/**
	 * 
	 * @author Donatti [tallescosttapaiva@gmail.com] 24/03/2024 - 00:08:51
	 *
	 * @param nomeArquivo
	 * @return
	 */
	public String renomearArquivo(String nomeArquivo) 
	{
        return removerAcentuacao(nomeArquivo).replaceAll("[^a-zA-Z0-9]+", "_").replaceAll("^_|_$", "").replaceAll("_+", "_");
    }
	
	/**
	 * @author Donatti [tallescosttapaiva@gmail.com] 24/03/2024 - 00:46:30
	 *
	 * @param nomeArquivo
	 * @param extensaoArquivo
	 * @return
	 */
	public String renomearArquivoPDF(String nomeArquivo, String extensaoArquivo) 
	{
		return new StringBuilder()
		        .append(renomearArquivo(nomeArquivo))
		        .append("_")
		        .append(dataUtil.obterDataAtualFormatada())
		        .append(extensaoArquivo)
		        .toString();
	}
	
	/**
	 * 
	 * @author Donatti [tallescosttapaiva@gmail.com] 24/03/2024 - 03:19:55
	 *
	 * @param nomeArquivo
	 * @return
	 */
    public String removerAcentuacao(String nomeArquivo) 
    {
        return Normalizer.normalize(nomeArquivo, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }
}
