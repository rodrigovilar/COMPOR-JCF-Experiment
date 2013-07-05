package br.ufcg.ppgcc.compor.jcf.experimento.fachada;

import java.util.List;

public interface FachadaExperimento {

	void criarTitular(Titular titular);

	List<Titular> listarTitulares();

	void criarFontePagadora(Titular titular, FontePagadora fonte);

	Relatorio relatorioCompleto(Titular titular);

	void criarDependente(Titular titular, Pessoa dependente);

	List<FontePagadora> listarFontes(Titular titular);

	List<Dependente> listarDependentes(Titular titular);

	void criarGastoDedutivel(Titular titular, Pessoa realizador, GastoDedutivel gastoDedutivel);

	List<GastoDedutivel> listarGastosDedutiveis(Titular titular, Pessoa realizador);

	Relatorio relatorioSimplificado(Titular titular);

}
