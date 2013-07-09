package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import java.util.ArrayList;
import java.util.List;

import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Titular;

import net.compor.frameworks.jcf.api.Component;
import net.compor.frameworks.jcf.api.Service;

public class GerenteDeclaracao extends Component {
	
	private List<Titular> titulares = new ArrayList<Titular>();

	public GerenteDeclaracao() {
		super("Gerente de titulares");
	}

	public void criarTitular(Titular titular) {
		titulares.add(titular);
	}
	
	@Service(name="listarTitulares")
	public List<Titular> getTitulares() {
		return titulares;
	}
}