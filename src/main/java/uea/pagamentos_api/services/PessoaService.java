package uea.pagamentos_api.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uea.pagamentos_api.models.Pessoa;
import uea.pagamentos_api.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa criar(Pessoa Pessoa) {
		return pessoaRepository.save(Pessoa);
	}

	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}

	public Pessoa buscarPorCodigo(Long codigo) {
		Pessoa Pessoa = pessoaRepository.findById(codigo).orElseThrow(); // se vier null a gente ja lança uma
																					// exceção, se nao ele retorna
																					// Pessoa
		return Pessoa;
	}

	public void excluir(Long codigo) {
		pessoaRepository.deleteById(codigo);
	}

	public Pessoa atualizar(Long codigo, Pessoa Pessoa) {
		Pessoa pessoaSalva = pessoaRepository.findById(codigo).orElseThrow();
		BeanUtils.copyProperties(Pessoa, pessoaSalva, "codigo"); // atualizaçao em memoria

		return pessoaRepository.save(pessoaSalva);
	}

}