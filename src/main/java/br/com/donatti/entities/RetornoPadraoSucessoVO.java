package br.com.donatti.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Tales Paiva [tales.paiva@cagece.com.br] 24/03/2024 - 19:46:00
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RetornoPadraoSucessoVO implements Serializable {

	/**
	 * @author Tales Paiva [tales.paiva@cagece.com.br] 24/03/2024 - 20:30:47
	 */
	private static final long serialVersionUID = -4685993221679507833L;

	private Integer codigo;
	
	private String mensagem;

	private Object resultado;

	/**
	 * @author Tales Paiva [tales.paiva@cagece.com.br] 24/03/2024 - 19:51:35
	 *
	 * @param mensagem
	 * @param resultado
	 */
	public RetornoPadraoSucessoVO(String mensagem, Object resultado) {
		this.mensagem = mensagem;
		this.resultado = resultado;
	}
	
}
