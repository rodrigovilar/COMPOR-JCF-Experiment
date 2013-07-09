package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import net.compor.frameworks.jcf.api.Decorator;
import net.compor.frameworks.jcf.api.Service;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Dependente;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.ExcecaoImpostoDeRenda;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Titular;
import br.ufcg.ppgcc.compor.jcf.experimento.util.Validacao;

public class ValidacaoDependente extends Decorator<GerenteDependente>{

	private Validacao validacao = new Validacao();
	
	public ValidacaoDependente(GerenteDependente innerComponent) {
		super(innerComponent);
	}

	@Service(name = "criarDependente")
	public void criarNovoDependente(Titular titular, Dependente dependente) {
		
		if (!validacao.obrigatorio(dependente.getNome())) {
			throw new ExcecaoImpostoDeRenda("O campo nome é obrigatório");
		}
		
		if (!validacao.obrigatorio(dependente.getCpf())) {
			throw new ExcecaoImpostoDeRenda("O campo CPF é obrigatório");
		}

		if (dependente.getTipo() <= 0) {
			throw new ExcecaoImpostoDeRenda("O campo tipo está inválido");
		}

		if (!validacao.cpf(dependente.getCpf())) {
			throw new ExcecaoImpostoDeRenda("O campo CPF está inválido");
		}

		getInnerComponent().criarNovoDependente(titular, dependente);
	}	
}
