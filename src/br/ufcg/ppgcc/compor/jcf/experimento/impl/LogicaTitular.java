package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import java.util.ArrayList;
import java.util.List;

import br.ufcg.ppgcc.compor.jcf.experimento.fachada.ExcecaoImpostoDeRenda;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Titular;
import br.ufcg.ppgcc.compor.jcf.experimento.util.Validacao;

public class LogicaTitular {
	
	private List<Titular> titulares = new ArrayList<Titular>();

	public void criarNovoTitular(Titular titular) {
		if(!Validacao.obrigatorio(titular.getNome())) {
			throw new ExcecaoImpostoDeRenda("O campo nome é obrigatório");
		}

		if(!Validacao.obrigatorio(titular.getCpf())) {
			throw new ExcecaoImpostoDeRenda("O campo CPF é obrigatório");
		}

		if(!Validacao.cpf(titular.getCpf())) {
			throw new ExcecaoImpostoDeRenda("O campo CPF está inválido");
		}
				
		titulares.add(titular);
	}

	public List<Titular> listarTitulares() {
		return titulares;
	}

}
