/**
 * @author Donatti [tallescosttapaiva@gmail.com] 24/03/2024 - 21:51:51
 */
package br.com.donatti.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Donatti [tallescosttapaiva@gmail.com] 24/03/2024 - 21:51:51
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErroPadraoVO {

	private String mensagem;
	
	private Integer codigo;
}
