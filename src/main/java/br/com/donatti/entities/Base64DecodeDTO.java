package br.com.donatti.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Donatti [tallescosttapaiva@gmail.com] 14/06/2023 - 04:13:28
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Base64DecodeDTO {

	private String nomeArquivo;
	
	private String base64Data;
	
}
