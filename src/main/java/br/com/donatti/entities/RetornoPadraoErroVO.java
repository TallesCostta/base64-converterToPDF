package br.com.donatti.entities;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Tales Paiva [tales.paiva@cagece.com.br] 24/03/2024 - 21:49:44
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RetornoPadraoErroVO implements Serializable {

	/**
	 * @author Tales Paiva [tales.paiva@cagece.com.br] 24/03/2024 - 21:49:57
	 */
	private static final long serialVersionUID = 4756284383721484523L;

	List<ErroPadraoVO> erros;
}
