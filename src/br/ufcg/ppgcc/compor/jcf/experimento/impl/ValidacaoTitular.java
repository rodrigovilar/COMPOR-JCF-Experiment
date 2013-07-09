package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import net.compor.frameworks.jcf.api.Decorator;
import net.compor.frameworks.jcf.api.Service;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.ExcecaoImpostoDeRenda;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Titular;
import br.ufcg.ppgcc.compor.jcf.experimento.util.Validacao;

public class ValidacaoTitular extends Decorator<GerenteDeclaracao>{

	private Validacao validacao = new Validacao();
	
	public ValidacaoTitular(GerenteDeclaracao innerComponent) {
		super(innerComponent);
	}

	@Service(name="criarTitular")
	public void criarTitular(Titular titular) {
		if (!validacao.obrigatorio(titular.getNome())) {
			throw new ExcecaoImpostoDeRenda("O campo nome é obrigatório");
		}

		if (!validacao.obrigatorio(titular.getCpf())) {
			throw new ExcecaoImpostoDeRenda("O campo CPF é obrigatório");
		}

		if (!validacao.cpf(titular.getCpf())) {
			throw new ExcecaoImpostoDeRenda("O campo CPF está inválido");
		}

		getInnerComponent().criarTitular(titular);
	}	
}
