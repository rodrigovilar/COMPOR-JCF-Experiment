package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import java.util.ArrayList;
import java.util.List;

import net.compor.frameworks.jcf.api.Component;
import net.compor.frameworks.jcf.api.Service;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Declaracao;

public class GerenteDeclaracao extends Component {
	
	private List<Declaracao> declaracoes = new ArrayList<Declaracao>();

	public GerenteDeclaracao() {
		super("Gerente de declaração");
	}

	@Service(name="criarDeclaracao")
	public void criarNovaDeclaracao(Declaracao declaracao) {
		declaracoes.add(declaracao);
	}
	
	@Service(name="listarDeclaracoes")
	public List<Declaracao> getDeclaracoes() {
		return declaracoes;
	}
}