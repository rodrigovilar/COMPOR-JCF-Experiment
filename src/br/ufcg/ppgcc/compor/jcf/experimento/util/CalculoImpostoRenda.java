package br.ufcg.ppgcc.compor.jcf.experimento.util;

import java.util.List;

import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Titular;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Dependente;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.FontePagadora;

public class CalculoImpostoRenda {
	
	public static double impostoAPagar(double impostoDevido, double impostoPago) {
		return impostoDevido - impostoPago;
	}

	public static double impostoDevido(Titular declaracao, List<FontePagadora> fontes, 
			List<Dependente> dependentes) {
		double totalRecebido = somaRenda(fontes);
		double baseCalculo = descontoDependentes(totalRecebido, dependentes);
		
		if (baseCalculo < 1637.1100 * 12) { //isento
			return 0.0; 
		} 
		
		if (baseCalculo < 2453.5100 * 12) {
			return impostoDevidoFaixa2(baseCalculo);
		} 

		if (baseCalculo < 3271.3900 * 12) {
			return impostoDevidoFaixa3(baseCalculo);
		} 

		if (baseCalculo < 4087.6600 * 12) {
			return impostoDevidoFaixa4(baseCalculo);			
		} 
		
		return impostoDevidoFaixa5(baseCalculo);
	}
	
	private static double somaRenda(List<FontePagadora> fontes) {
		double soma = 0.0;
		
		for (FontePagadora fontePagadora : fontes) {
			soma += fontePagadora.getRendimentoRecebidos();
		}
		
		return soma;
	}
	
	private static double descontoDependentes(double totalRecebido,
			List<Dependente> dependentes) {
		return Math.max(0, totalRecebido - (dependentes.size() * 1974.72));
	}

	private static double impostoDevidoFaixa2(double totalRecebido) {
		return calculoGenerico(totalRecebido, 0.07500, 122.78 * 12);
	}

	private static double impostoDevidoFaixa3(double totalRecebido) {
		return calculoGenerico(totalRecebido, 0.1500, 306.80 * 12);
	}

	private static double impostoDevidoFaixa4(double totalRecebido) {
		return calculoGenerico(totalRecebido, 0.22500, 552.15 * 12);
	}

	private static double impostoDevidoFaixa5(double totalRecebido) {
		return calculoGenerico(totalRecebido, 0.27500, 756.53 * 12);
	}

	private static double calculoGenerico(double totalRecebido, double taxa,
			double parcelaADeduzir) {
		return (totalRecebido * taxa) - parcelaADeduzir;
	}

}
