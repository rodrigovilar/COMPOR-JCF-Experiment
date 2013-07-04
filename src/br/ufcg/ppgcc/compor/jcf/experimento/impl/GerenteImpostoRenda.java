package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import java.util.List;

import net.compor.frameworks.jcf.api.Component;
import net.compor.frameworks.jcf.api.Service;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Declaracao;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Dependente;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.FontePagadora;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.RelatorioCompleto;
import br.ufcg.ppgcc.compor.jcf.experimento.util.CalculoImpostoRenda;

public class GerenteImpostoRenda extends Component {
	
	public GerenteImpostoRenda() {
		super("Gerente dos cálculos de imposto de renda");
	}

	@SuppressWarnings("unchecked")
	@Service(requiredServices="listarFontesPagadoras,listarDependentes")
	public RelatorioCompleto relatorioCompleto(Declaracao declaracao) {
		RelatorioCompleto relatorio = new RelatorioCompleto();
		
		List<FontePagadora> fontes = (List<FontePagadora>) 
				requestService("listarFontesPagadoras", declaracao);
		List<Dependente> dependentes = (List<Dependente>) 
				requestService("listarDependentes", declaracao);
		double impostoDevido = CalculoImpostoRenda.impostoDevido(declaracao, fontes, dependentes);
		relatorio.setImpostoDevido(impostoDevido);
		
		return relatorio;
	}
	
}