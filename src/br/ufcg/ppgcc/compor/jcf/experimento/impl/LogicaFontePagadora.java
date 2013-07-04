package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Titular;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.FontePagadora;

public class LogicaFontePagadora {

	private static LogicaFontePagadora instancia;

	private Map<Titular, List<FontePagadora>> fontes = new HashMap<Titular, List<FontePagadora>>();

	private LogicaFontePagadora() {
	}

	public static LogicaFontePagadora getInstancia() {
		if (instancia == null) {
			instancia = new LogicaFontePagadora();
		}
		return instancia;
	}

	public void criarFontePagadora(Titular titular, FontePagadora fonte) {
		if (fontes.get(titular) == null) {
			fontes.put(titular, new ArrayList<FontePagadora>());
		}

		fontes.get(titular).add(fonte);
	}

	public List<FontePagadora> getFontes(Titular titular) {
		if (fontes.get(titular) == null) {
			fontes.put(titular, new ArrayList<FontePagadora>());
		}

		return fontes.get(titular);
	}

	public void limpar() {
		fontes.clear();
	}
}
