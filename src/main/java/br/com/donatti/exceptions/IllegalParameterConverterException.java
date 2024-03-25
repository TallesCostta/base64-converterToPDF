package br.com.donatti.exceptions;

/**
 * @author Donatti [tallescosttapaiva@gmail.com] 25/03/2024 - 00:17:41
 */
public class IllegalParameterConverterException extends IllegalArgumentException {

	/**
	 * @author Donatti [tallescosttapaiva@gmail.com] 25/03/2024 - 00:17:44
	 */
	private static final long serialVersionUID = -3643640577842013974L;

	/**
	 * @author Donatti [tallescosttapaiva@gmail.com] 25/03/2024 - 00:17:52
	 *
	 */
	public IllegalParameterConverterException() {
		super();
	}

	/**
	 * @author Donatti [tallescosttapaiva@gmail.com] 25/03/2024 - 00:17:52
	 *
	 * @param mensagem
	 */
	public IllegalParameterConverterException(String mensagem) {
		super(mensagem);
	}

	
	
}
