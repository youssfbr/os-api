package com.alissondev.os.controllers.exceptions;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.alissondev.os.services.exceptions.BadRequestException;
import com.alissondev.os.services.exceptions.EmailExistException;
import com.alissondev.os.services.exceptions.NotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		var fields = new ArrayList<StandardError.Field>();
		
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			String name = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			
			fields.add(new StandardError.Field(name, message));
		}
		
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setTimestamp1(OffsetDateTime.now());
		err.setStatus(status.value());
		err.setError("Um ou mais campos inválidos. Verifique se estão nulos e preencha-os corretamente.");
		err.setFields(fields);
		
		return super.handleExceptionInternal(ex, err, headers, status, request);
	}
	
	@ExceptionHandler(EmailExistException.class)
	public ResponseEntity<StandardError> EmailFound(EmailExistException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;

		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setTimestamp1(OffsetDateTime.now());
		err.setStatus(status.value());		
		err.setError("Email já existente");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());		
		
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<StandardError> notFound(NotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;

		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setTimestamp1(OffsetDateTime.now());
		err.setStatus(status.value());
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());		
		
		return ResponseEntity.status(status).body(err);		
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<StandardError> badRequest(BadRequestException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setTimestamp1(OffsetDateTime.now());
		err.setStatus(status.value());
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());		
		
		return ResponseEntity.status(status).body(err);
	}
}
