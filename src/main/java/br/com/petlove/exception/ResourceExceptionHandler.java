package br.com.petlove.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.amazonaws.services.applicationautoscaling.model.ObjectNotFoundException;
import com.amazonaws.services.appstream.model.StackError;
@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(Autenticacao.class)
	public ResponseEntity<StandardError> Autenticacao(ObjectNotFoundException e, HttpServletRequest request) {
		
		StandardError err = new StandardError(HttpStatus.FORBIDDEN.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
	}
}
