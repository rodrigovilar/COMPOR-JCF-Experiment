package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import java.util.ArrayList;
import java.util.List;

import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Dependente;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.FontePagadora;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.GastoDedutivel;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Resultado;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Titular;
import br.ufcg.ppgcc.compor.jcf.experimento.util.CalculoImpostoRenda;

public class LogicaRelatorioCompleto {

	private LogicaGastoDedutivel logicaGastoDedutivel = LogicaGastoDedutivel.getInstancia();

	public Resultado declaracaoCompleta(Titular titular) {
		List<FontePagadora> fontes = 
				LogicaFontePagadora.getInstancia().getFontes(titular);
		List<Dependente> dependentes = 
				LogicaDependente.getInstancia().getDependentes(titular);
		
		List<GastoDedutivel> gastos = 
				new ArrayList<GastoDedutivel>(logicaGastoDedutivel.listarGastosDedutiveis(titular));
		
		for (Dependente dependente : dependentes) {
			gastos.addAll(logicaGastoDedutivel.listarGastosDedutiveis(dependente));
		}
		
		double totalRecebido = CalculoImpostoRenda.totalRecebido(fontes);
		double baseCalculo = CalculoImpostoRenda.descontoDependentes(totalRecebido, dependentes);
		baseCalculo = CalculoImpostoRenda.descontoEducacao(baseCalculo, gastos);
		baseCalculo = CalculoImpostoRenda.descontoSaude(baseCalculo, gastos);
		double impostoDevido = CalculoImpostoRenda.impostoDevido(baseCalculo);

		double impostoPago = CalculoImpostoRenda.totalPago(fontes);
		
		Resultado resultado = new Resultado();
		resultado.setImpostoDevido(impostoDevido);
		resultado.setImpostoPago(impostoPago);
		resultado.setImpostoAPagar(impostoDevido - impostoPago); 
		return resultado;
	}

}
