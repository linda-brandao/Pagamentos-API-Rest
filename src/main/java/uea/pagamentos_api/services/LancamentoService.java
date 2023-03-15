package uea.pagamentos_api.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uea.pagamentos_api.models.Lancamento;
import uea.pagamentos_api.repositories.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;

	public Lancamento criar(Lancamento Lancamento) {
		return lancamentoRepository.save(Lancamento);
	}

	public List<Lancamento> listar() {
		return lancamentoRepository.findAll();
	}

	public Lancamento buscarPorCodigo(Long codigo) {
		Lancamento Lancamento = lancamentoRepository.findById(codigo).orElseThrow(); // se vier null a gente ja lança uma
																					// exceção, se nao ele retorna
																					// Lancamento
		return Lancamento;
	}

	public void excluir(Long codigo) {
		lancamentoRepository.deleteById(codigo);
	}

	public Lancamento atualizar(Long codigo, Lancamento Lancamento) {
		Lancamento lancamentoSalva = lancamentoRepository.findById(codigo).orElseThrow();
		BeanUtils.copyProperties(Lancamento, lancamentoSalva, "codigo"); // atualizaçao em memoria

		return lancamentoRepository.save(lancamentoSalva);
	}

}