package uea.pagamentos_api.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

//class para personalizar o erro

public class StandardError implements Serializable {
	// transitar pela rede

	private static final long serialVersionUID = 1L;

	// personalizar mensagem

	// mostra o horario do erro
	private Instant timestamp;

	// o status do erro
	private Integer status;

	// retornando a lista dos erros que podem estar acontecendo
	private List<String> erros;

	// mensagem
	private String message;

	// path que aconteceu o erro
	private String path;

	public StandardError() {
	}

	public StandardError(Instant timestamp, Integer status, List<String> erros, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.erros = erros;
		this.message = message;
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

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
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

}
