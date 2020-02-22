package com.makerssolutions.studentslab.businessentity;

/**
 * Respuesta de servicio
 * @author jonnatan.rios
 *
 * @param <T> Tipo de objeto que va en el cuerpo de la respuesta
 */
public class Response<T> {
	
	private int status;
	
	private String message;
	
	private T body;
	
	public Response() {
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}

}
