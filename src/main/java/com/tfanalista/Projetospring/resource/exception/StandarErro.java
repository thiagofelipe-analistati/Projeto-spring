package com.tfanalista.Projetospring.resource.exception;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StandarErro implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'z'" , timezone = "GMT")
	private Instant timestamp;
	private Integer status;
	private String erro;
	private String menssagem;
	private String path;

	
	public StandarErro() {
	
	}
	
	
	public StandarErro(Instant timestamp, Integer status, String erro, String menssagem, String path) {
		super();
	
		this.timestamp = timestamp;
		this.status = status;
		this.erro = erro;
		this.menssagem = menssagem;
		this.path = path;
	}


	public Instant getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getErro() {
		return erro;
	}


	public void setErro(String erro) {
		this.erro = erro;
	}


	public String getMenssagem() {
		return menssagem;
	}


	public void setMenssagem(String menssagem) {
		this.menssagem = menssagem;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}
	
	
	
}
