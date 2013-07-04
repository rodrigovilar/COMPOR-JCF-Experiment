package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.compor.frameworks.jcf.api.Component;
import net.compor.frameworks.jcf.api.Service;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Declaracao;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Dependente;

public class GerenteDependente extends Component {

	private Map<Declaracao, List<Dependente>> dependentes = 
			new HashMap<Declaracao, List<Dependente>>();

	public GerenteDependente() {
		super("Gerente de dependentes");
	}

	@Service(name = "criarDependente")
	public void criarNovoDependente(Declaracao declaracao,
			Dependente dependente) {
		inicializarLista(declaracao);
		dependentes.get(declaracao).add(dependente);
	}

	@Service(name = "listarDependentes")
	public List<Dependente> getDependentes(Declaracao declaracao) {
		inicializarLista(declaracao);
		return dependentes.get(declaracao);
	}
	
	private void inicializarLista(Declaracao declaracao) {
		if (dependentes.get(declaracao) == null) {
			dependentes.put(declaracao, new ArrayList<Dependente>());
		}
	}
}