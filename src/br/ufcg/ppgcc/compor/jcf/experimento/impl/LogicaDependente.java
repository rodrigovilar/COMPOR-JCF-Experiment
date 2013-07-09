package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Dependente;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.ExcecaoImpostoDeRenda;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Titular;
import br.ufcg.ppgcc.compor.jcf.experimento.util.Validacao;

public class LogicaDependente {

	private Validacao validacao = new Validacao();
	
	private static LogicaDependente instancia;

	private Map<Titular, List<Dependente>> dependentes = new HashMap<Titular, List<Dependente>>();

	private LogicaDependente() {
	}

	public static LogicaDependente getInstancia() {
		if (instancia == null) {
			instancia = new LogicaDependente();
		}
		return instancia;
	}

	public void criarDependente(Titular titular, Dependente dependente) {
		if(!validacao.obrigatorio(dependente.getNome())) {
			throw new ExcecaoImpostoDeRenda("O campo nome é obrigatório");
		}

		if(!validacao.obrigatorio(dependente.getCpf())) {
			throw new ExcecaoImpostoDeRenda("O campo CPF/CNPJ é obrigatório");
		}

		if(dependente.getTipo() <= 0) {
			throw new ExcecaoImpostoDeRenda("O valor do campo tipo está inválido");
		}

		if(!validacao.cpf(dependente.getCpf())) {
			throw new ExcecaoImpostoDeRenda("O valor do campo CPF/CNPJ está inválido");
		}

		if (dependentes.get(titular) == null) {
			dependentes.put(titular, new ArrayList<Dependente>());
		}

		dependentes.get(titular).add(dependente);
	}

	public List<Dependente> getDependentes(Titular titular) {
		if (dependentes.get(titular) == null) {
			dependentes.put(titular, new ArrayList<Dependente>());
		}
		
		return dependentes.get(titular);
	}

	public void limpar() {
		dependentes.clear();
	}
}
