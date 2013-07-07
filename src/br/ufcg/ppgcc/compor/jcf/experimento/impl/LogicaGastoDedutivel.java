package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufcg.ppgcc.compor.jcf.experimento.fachada.GastoDedutivel;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Pessoa;

public class LogicaGastoDedutivel {
	
	private Map<Pessoa, List<GastoDedutivel>> gastos = new HashMap<Pessoa, List<GastoDedutivel>>();

	public void criarGastoDedutivel(Pessoa realizador, GastoDedutivel gasto) {
		if (gastos.get(realizador) == null) {
			gastos.put(realizador, new ArrayList<GastoDedutivel>());
		}

		gastos.get(realizador).add(gasto);
	}

	public List<GastoDedutivel> listarGastosDedutiveis(Pessoa realizador) {
		if (gastos.get(realizador) == null) {
			gastos.put(realizador, new ArrayList<GastoDedutivel>());
		}
		
		return gastos.get(realizador);
	}

}