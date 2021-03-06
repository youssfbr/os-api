package com.alissondev.os.controllers.exceptions;

import java.io.Serializable;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class StandardError implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	private Instant timestamp;
	private OffsetDateTime timestamp1;
	private Integer status;
	private String error;
	private String message;
	private String path;
	private List<Field> fields;
	
	public static class Field {
		
		private String name;
		private String message;
						
		public Field(String name, String message) {		
			this.name = name;
			this.message = message;
		}

		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public String getMessage() {
			return message;
		}
		
		public void setMessage(String message) {
			this.message = message;
		}	
		
	}
	
	public StandardError() {	
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	
	public OffsetDateTime getTimestamp1() {
		return timestamp1;
	}

	public void setTimestamp1(OffsetDateTime timestamp1) {
		this.timestamp1 = timestamp1;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	
}
