package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Dependente;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Titular;

public class LogicaDependente {

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
