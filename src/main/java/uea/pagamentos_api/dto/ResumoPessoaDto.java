package uea.pagamentos_api.dto;

public class ResumoPessoaDto {
	private String nome;
	private Boolean ativo;
	private String cidade;
	private String estado;
	
	public ResumoPessoaDto() {	}

	public ResumoPessoaDto(String nome, Boolean ativo, String cidade, String estado) {
		super();
		this.nome = nome;
		this.ativo = ativo;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
