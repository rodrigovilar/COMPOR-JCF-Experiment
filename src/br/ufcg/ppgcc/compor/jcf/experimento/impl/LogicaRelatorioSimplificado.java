package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import java.util.List;

import br.ufcg.ppgcc.compor.jcf.experimento.fachada.FontePagadora;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Resultado;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Titular;
import br.ufcg.ppgcc.compor.jcf.experimento.util.CalculoImpostoRenda;

public class LogicaRelatorioSimplificado {

	public Resultado declaracaoSimplificada(Titular titular) {
		List<FontePagadora> fontes = 
				LogicaFontePagadora.getInstancia().getFontes(titular);
		double totalRecebido = CalculoImpostoRenda.totalRecebido(fontes);
		double baseCalculo = CalculoImpostoRenda.deducaoSimplificada(totalRecebido);

		double impostoDevido = 
				CalculoImpostoRenda.impostoDevido(baseCalculo);
		
		Resultado resultado = new Resultado();
		resultado.setImpostoDevido(impostoDevido);
		return resultado;
	}

}
