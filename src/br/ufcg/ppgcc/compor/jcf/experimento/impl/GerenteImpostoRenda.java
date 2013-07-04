package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import java.util.List;

import net.compor.frameworks.jcf.api.Component;
import net.compor.frameworks.jcf.api.Service;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Dependente;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.FontePagadora;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Resultado;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Titular;
import br.ufcg.ppgcc.compor.jcf.experimento.util.CalculoImpostoRenda;

public class GerenteImpostoRenda extends Component {
	
	public GerenteImpostoRenda() {
		super("Gerente dos cálculos de imposto de renda");
	}

	@SuppressWarnings("unchecked")
	@Service(requiredServices="listarFontesPagadoras,listarDependentes")
	public Resultado declaracaoCompleta(Titular titular) {
		List<FontePagadora> fontes = (List<FontePagadora>) 
				requestService("listarFontesPagadoras", titular);
		List<Dependente> dependentes = (List<Dependente>) 
				requestService("listarDependentes", titular);

		double totalRecebido = CalculoImpostoRenda.totalRecebido(fontes);
		double baseCalculo = CalculoImpostoRenda.descontoDependentes(totalRecebido, dependentes);
		double impostoDevido = CalculoImpostoRenda.impostoDevido(baseCalculo);

		Resultado relatorio = new Resultado();
		relatorio.setImpostoDevido(impostoDevido);
		return relatorio;
	}
	
}