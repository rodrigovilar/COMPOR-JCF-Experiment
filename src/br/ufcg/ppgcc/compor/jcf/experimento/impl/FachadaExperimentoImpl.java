package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import java.util.List;

import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Dependente;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.FachadaExperimento;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.FontePagadora;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Resultado;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Titular;

public class FachadaExperimentoImpl implements FachadaExperimento {

	private LogicaTitular logicaTitular = new LogicaTitular();
	private LogicaFontePagadora logicaFontePagadora = LogicaFontePagadora.getInstancia();
	private LogicaDependente logicaDependente = LogicaDependente.getInstancia();
	private LogicaRelatorioCompleto logicaRelatorioCompleto = new LogicaRelatorioCompleto();

	
	public FachadaExperimentoImpl() {
		logicaFontePagadora.limpar();
		logicaDependente.limpar();
	}
	
	public void criarNovoTitular(Titular titular) {
		logicaTitular.criarNovoTitular(titular);
	}

	public List<Titular> listarTitulares() {
		return logicaTitular.listarTitulares();
	}

	public void criarFontePagadora(Titular titular, FontePagadora fonte) {
		logicaFontePagadora.criarFontePagadora(titular, fonte);
	}

	public Resultado declaracaoCompleta(Titular titular) {
		return logicaRelatorioCompleto.declaracaoCompleta(titular);
	}

	public void criarDependente(Titular titular, Dependente dependente) {
		logicaDependente.criarDependente(titular, dependente);
	}

	public List<FontePagadora> listarFontes(Titular titular) {
		return logicaFontePagadora.getFontes(titular);
	}

	public List<Dependente> listarDependentes(Titular titular) {
		return logicaDependente.getDependentes(titular);
	}
}
