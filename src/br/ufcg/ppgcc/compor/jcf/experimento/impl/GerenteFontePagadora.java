package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.compor.frameworks.jcf.api.Component;
import net.compor.frameworks.jcf.api.Service;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.FontePagadora;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Titular;

public class GerenteFontePagadora extends Component {

	private Map<Titular, List<FontePagadora>> fontesPagadoras = 
			new HashMap<Titular, List<FontePagadora>>();

	public GerenteFontePagadora() {
		super("Gerente de fontes pagadoras");
	}

	@Service(name = "criarFontePagadora")
	public void criarNovaFontePagadora(Titular titular,
			FontePagadora fontePagadora) {
		inicializarLista(titular);
		fontesPagadoras.get(titular).add(fontePagadora);
	}

	@Service(name = "listarFontesPagadoras")
	public List<FontePagadora> getFontesPagadoras(Titular titular) {
		inicializarLista(titular);
		return fontesPagadoras.get(titular);
	}
	
	private void inicializarLista(Titular titular) {
		if (fontesPagadoras.get(titular) == null) {
			fontesPagadoras.put(titular, new ArrayList<FontePagadora>());
		}
	}
}