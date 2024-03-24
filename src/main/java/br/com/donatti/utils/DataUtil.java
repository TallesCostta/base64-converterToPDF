package br.com.donatti.utils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class DataUtil implements Serializable {

	/**
	 * @author Donatti [tallescosttapaiva@gmail.com] 24/03/2024 - 00:25:54
	 */
	private static final long serialVersionUID = -8688751594252098664L;

	/**
	 * 
	 * @author Donatti [tallescosttapaiva@gmail.com] 24/03/2024 - 00:24:41
	 *
	 * @return
	 */
	public String obterDataAtualFormatada() 
	{
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(Constants.FORMAT_DATE_PATTERN));
	}
}
