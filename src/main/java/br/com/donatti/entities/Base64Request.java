package br.com.donatti.entities;

import java.io.Serializable;

/**
 * 
 * @author Donatti [tallescosttapaiva@gmail.com] 14/06/2023 - 04:13:28
 *
 */
public class Base64Request implements Serializable {

	private static final long serialVersionUID = -7271475474827776458L;

	private String base64Data;

	public String getBase64Data() {
		return base64Data;
	}

	public void setBase64Data(String base64Data) {
		this.base64Data = base64Data;
	}
	
}
