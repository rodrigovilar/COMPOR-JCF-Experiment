package br.ufcg.ppgcc.compor.jcf.experimento.fachada;

import java.util.List;

public interface FachadaExperimento {

	void criarNovaDeclaracao(Declaracao declaracao);

	List<Declaracao> listarDeclaracoes();

	void criarFontePagadora(Declaracao declaracao, FontePagadora fonte);

	RelatorioCompleto relatorioCompleto(Declaracao declaracao);

	void criarDependente(Declaracao declaracao, Dependente dependente);

	List<FontePagadora> listarFontes(Declaracao declaracao);

	List<Dependente> listarDependentes(Declaracao declaracao);

}
