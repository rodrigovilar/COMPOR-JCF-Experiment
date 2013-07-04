package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import java.util.List;

import net.compor.frameworks.jcf.api.ComporFacade;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Declaracao;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Dependente;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.FachadaExperimento;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.FontePagadora;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.RelatorioCompleto;

public class FachadaExperimentoImpl extends ComporFacade implements
		FachadaExperimento {

	@Override
	protected void addComponents() {
		add(new GerenteDeclaracao());
		add(new GerenteFontePagadora());
		add(new GerenteDependente());
		add(new GerenteImpostoRenda());
	}

	public void criarNovaDeclaracao(Declaracao declaracao) {
		requestService("criarDeclaracao", declaracao);
	}

	@SuppressWarnings("unchecked")
	public List<Declaracao> listarDeclaracoes() {
		return (List<Declaracao>) requestService("listarDeclaracoes");
	}

	public void criarFontePagadora(Declaracao declaracao, FontePagadora fonte) {
		requestService("criarFontePagadora", declaracao, fonte);
	}

	public RelatorioCompleto relatorioCompleto(Declaracao declaracao) {
		return (RelatorioCompleto) requestService("relatorioCompleto",
				declaracao);
	}

	public void criarDependente(Declaracao declaracao, Dependente dependente) {
		requestService("criarDependente", declaracao, dependente);
	}

	@SuppressWarnings("unchecked")
	public List<FontePagadora> listarFontes(Declaracao declaracao) {
		return (List<FontePagadora>) requestService("listarFontesPagadoras",
				declaracao);
	}

	@SuppressWarnings("unchecked")
	public List<Dependente> listarDependentes(Declaracao declaracao) {
		return (List<Dependente>) requestService("listarDependentes",
				declaracao);
	}

}
