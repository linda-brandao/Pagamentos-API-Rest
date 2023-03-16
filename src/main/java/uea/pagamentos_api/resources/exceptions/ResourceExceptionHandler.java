package uea.pagamentos_api.resources.exceptions;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice // para fazer o tratamento de exceção, ao inves de dar o erro, ele vai retornar
					// uma mensagem personalizada
public class ResourceExceptionHandler {

	// objeto que permite pegar a msg personalizadas de um arquivo
	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(NoSuchElementException.class) // ficar ouvindo se ocorreu um erro desse tipo para fazer o
													// tratamento embaixo
	public ResponseEntity<StandardError> noSuchElementException(NoSuchElementException e, HttpServletRequest request) {
		// lista dos erros que podem ocorrer
		List<String> erros = Arrays
				.asList(messageSource.getMessage("mensagem.invalida", null, LocaleContextHolder.getLocale()));
		HttpStatus status = HttpStatus.NOT_FOUND;

		// instância da classe que gerencia o erro
		StandardError err = new StandardError(Instant.now(), status.value(), erros, e.getMessage(),
				request.getRequestURI());

		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(EmptyResultDataAccessException.class) // ficar ouvindo se ocorreu um erro desse tipo para fazer o
	// tratamento embaixo
	public ResponseEntity<StandardError> emptyResultDataAccessException(EmptyResultDataAccessException e, HttpServletRequest request) {
		// lista dos erros que podem ocorrer
		List<String> erros = Arrays
				.asList(messageSource.getMessage("mensagem.invalida", null, LocaleContextHolder.getLocale()));
		HttpStatus status = HttpStatus.NOT_FOUND;

		// instância da classe que gerencia o erro
		StandardError err = new StandardError(Instant.now(), status.value(), erros, e.getMessage(),
				request.getRequestURI());

		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(RuntimeException.class) // ficar ouvindo se ocorreu um erro desse tipo para fazer o
	// tratamento embaixo
	public ResponseEntity<StandardError> runtimeException(RuntimeException e, HttpServletRequest request) {
		// lista dos erros que podem ocorrer
		List<String> erros = Arrays
				.asList(messageSource.getMessage("mensagem.invalida.erro", null, LocaleContextHolder.getLocale()));
		HttpStatus status = HttpStatus.NOT_FOUND;

		// instância da classe que gerencia o erro
		StandardError err = new StandardError(Instant.now(), status.value(), erros, e.getMessage(),
				request.getRequestURI());

		return ResponseEntity.status(status).body(err);
	}

}
