package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import java.util.ArrayList;
import java.util.List;

import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Titular;

public class LogicaTitular {
	
	private List<Titular> titulares = new ArrayList<Titular>();

	public void criarNovoTitular(Titular declaracao) {
		titulares.add(declaracao);
	}

	public List<Titular> listarTitulares() {
		return titulares;
	}

}
