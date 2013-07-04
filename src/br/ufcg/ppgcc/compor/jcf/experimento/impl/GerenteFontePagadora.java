package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.compor.frameworks.jcf.api.Component;
import net.compor.frameworks.jcf.api.Service;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Declaracao;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.FontePagadora;

public class GerenteFontePagadora extends Component {

	private Map<Declaracao, List<FontePagadora>> fontesPagadoras = 
			new HashMap<Declaracao, List<FontePagadora>>();

	public GerenteFontePagadora() {
		super("Gerente de fontes pagadoras");
	}

	@Service(name = "criarFontePagadora")
	public void criarNovaFontePagadora(Declaracao declaracao,
			FontePagadora fontePagadora) {
		inicializarLista(declaracao);
		fontesPagadoras.get(declaracao).add(fontePagadora);
	}

	@Service(name = "listarFontesPagadoras")
	public List<FontePagadora> getFontesPagadoras(Declaracao declaracao) {
		inicializarLista(declaracao);
		return fontesPagadoras.get(declaracao);
	}
	
	private void inicializarLista(Declaracao declaracao) {
		if (fontesPagadoras.get(declaracao) == null) {
			fontesPagadoras.put(declaracao, new ArrayList<FontePagadora>());
		}
	}
}