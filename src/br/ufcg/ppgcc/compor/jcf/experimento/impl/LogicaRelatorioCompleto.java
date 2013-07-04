package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import java.util.List;

import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Dependente;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.FontePagadora;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Resultado;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Titular;
import br.ufcg.ppgcc.compor.jcf.experimento.util.CalculoImpostoRenda;

public class LogicaRelatorioCompleto {

	public Resultado declaracaoCompleta(Titular titular) {
		List<FontePagadora> fontes = 
				LogicaFontePagadora.getInstancia().getFontes(titular);
		List<Dependente> dependentes = 
				LogicaDependente.getInstancia().getDependentes(titular);
		
		double totalRecebido = CalculoImpostoRenda.totalRecebido(fontes);
		double baseCalculo = CalculoImpostoRenda.descontoDependentes(totalRecebido, dependentes);
		double impostoDevido = CalculoImpostoRenda.impostoDevido(baseCalculo);
		
		Resultado resultado = new Resultado();
		resultado.setImpostoDevido(impostoDevido);
		return resultado;
	}

}
