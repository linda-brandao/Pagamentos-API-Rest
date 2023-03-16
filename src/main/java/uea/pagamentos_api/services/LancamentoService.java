package uea.pagamentos_api.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import uea.pagamentos_api.models.Categoria;
import uea.pagamentos_api.models.Lancamento;
import uea.pagamentos_api.models.Pessoa;
import uea.pagamentos_api.repositories.CategoriaRepository;
import uea.pagamentos_api.repositories.LancamentoRepository;
import uea.pagamentos_api.repositories.PessoaRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Lancamento criar(Lancamento lancamento) {
		Pessoa pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo()).orElseThrow();
		Categoria categoria = categoriaRepository.findById(lancamento.getCategoria().getCodigo()).orElseThrow();
		if(pessoa.getAtivo()) {
			return lancamentoRepository.save(lancamento);	
		}
		throw new RuntimeException("Não é permitido criar ou atualizar o dado com ativo=false");
	}

	public List<Lancamento> listar() {
		return lancamentoRepository.findAll();
	}

	public Lancamento buscarPorCodigo(Long codigo) {
		Lancamento lancamento = lancamentoRepository.findById(codigo).orElseThrow(); // se vier null a gente ja lança uma
																					// exceção, se nao ele retorna
																					// Lancamento
		return lancamento;
	}

	public void excluir(Long codigo) {
		lancamentoRepository.deleteById(codigo);
	}

	public Lancamento atualizar(Long codigo, Lancamento lancamento) {
		Pessoa pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo()).orElseThrow();
		Categoria categoria = categoriaRepository.findById(lancamento.getCategoria().getCodigo()).orElseThrow();
		Lancamento lancamentoSalva = lancamentoRepository.findById(codigo).orElseThrow();
		BeanUtils.copyProperties(lancamento, lancamentoSalva, "codigo"); // atualizaçao em memoria
		if(pessoa.getAtivo()) {
			return lancamentoRepository.save(lancamentoSalva);			
		}
		throw new RuntimeException("Não é permitido criar ou atualizar o dado com ativo=false");
	}

}