package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.compor.frameworks.jcf.api.Component;
import net.compor.frameworks.jcf.api.Service;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Dependente;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Titular;

public class GerenteDependente extends Component {

	private Map<Titular, List<Dependente>> dependentes = 
			new HashMap<Titular, List<Dependente>>();

	public GerenteDependente() {
		super("Gerente de dependentes");
	}

	@Service(name = "criarDependente")
	public void criarNovoDependente(Titular titular,
			Dependente dependente) {
		inicializarLista(titular);
		dependentes.get(titular).add(dependente);
	}

	@Service(name = "listarDependentes")
	public List<Dependente> getDependentes(Titular titular) {
		inicializarLista(titular);
		return dependentes.get(titular);
	}
	
	private void inicializarLista(Titular titular) {
		if (dependentes.get(titular) == null) {
			dependentes.put(titular, new ArrayList<Dependente>());
		}
	}
}