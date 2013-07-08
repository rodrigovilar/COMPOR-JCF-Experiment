package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.compor.frameworks.jcf.api.Component;
import net.compor.frameworks.jcf.api.Service;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.GastoDedutivel;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Pessoa;

public class GerenteGastosDedutiveis extends Component {

	private Map<Pessoa, List<GastoDedutivel>> gastos = 
			new HashMap<Pessoa, List<GastoDedutivel>>();

	public GerenteGastosDedutiveis() {
		super("Gerente de gastos dedutíveis");
	}

	@Service(name = "criarGastoDedutivel")
	public void criarGastoDedutivel(Pessoa realizador,
			GastoDedutivel gastoDedutivel) {
		inicializarLista(realizador);
		gastos.get(realizador).add(gastoDedutivel);
	}

	@Service(name = "listarGastosDedutiveis")
	public List<GastoDedutivel> listarGastosDedutiveis(Pessoa realizador) {
		inicializarLista(realizador);
		return gastos.get(realizador);
	}
	
	private void inicializarLista(Pessoa realizador) {
		if (gastos.get(realizador) == null) {
			gastos.put(realizador, new ArrayList<GastoDedutivel>());
		}
	}
}