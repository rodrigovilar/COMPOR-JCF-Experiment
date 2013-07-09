package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import java.util.ArrayList;
import java.util.List;

import net.compor.frameworks.jcf.api.Component;
import net.compor.frameworks.jcf.api.Service;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Dependente;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.FontePagadora;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.GastoDedutivel;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Resultado;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Titular;
import br.ufcg.ppgcc.compor.jcf.experimento.util.CalculoImpostoRenda;

public class GerenteImpostoRenda extends Component {
	
	private CalculoImpostoRenda calculo = new CalculoImpostoRenda();
	
	public GerenteImpostoRenda() {
		super("Gerente dos cálculos de imposto de renda");
	}

	@SuppressWarnings("unchecked")
	@Service(requiredServices="listarFontesPagadoras,listarDependentes,listarGastosDedutiveis")
	public Resultado declaracaoCompleta(Titular titular) {
		List<FontePagadora> fontes = (List<FontePagadora>) 
				requestService("listarFontesPagadoras", titular);
		List<Dependente> dependentes = (List<Dependente>) 
				requestService("listarDependentes", titular);
		
		List<GastoDedutivel> gastos = new ArrayList<GastoDedutivel>((List<GastoDedutivel>)
				requestService("listarGastosDedutiveis", titular));

		for (Dependente dependente : dependentes) {
			gastos.addAll((List<GastoDedutivel>)
					requestService("listarGastosDedutiveis", dependente));
		}
		
		double totalRecebido = calculo.totalRecebido(fontes);
		double baseCalculo = calculo.descontoDependentes(totalRecebido, dependentes);
		baseCalculo = calculo.descontoEducacao(baseCalculo, gastos);
		baseCalculo = calculo.descontoSaude(baseCalculo, gastos);
		double impostoDevido = calculo.impostoDevido(baseCalculo);

		double impostoPago = calculo.totalPago(fontes);
		
		Resultado relatorio = new Resultado();
		relatorio.setImpostoDevido(impostoDevido);
		relatorio.setImpostoPago(impostoPago);
		relatorio.setImpostoAPagar(impostoDevido - impostoPago); 
		return relatorio;
	}

	@SuppressWarnings("unchecked")
	@Service(requiredServices="listarFontesPagadoras")
	public Resultado declaracaoSimplificada(Titular titular) {
		List<FontePagadora> fontes = (List<FontePagadora>) 
				requestService("listarFontesPagadoras", titular);

		double totalRecebido = calculo.totalRecebido(fontes);
		double baseCalculo = calculo.deducaoSimplificada(totalRecebido);
		double impostoDevido = calculo.impostoDevido(baseCalculo);
		double impostoPago = calculo.totalPago(fontes);
		
		Resultado relatorio = new Resultado();
		relatorio.setImpostoDevido(impostoDevido);
		relatorio.setImpostoPago(impostoPago);
		relatorio.setImpostoAPagar(impostoDevido - impostoPago); 
		return relatorio;		
	}

}