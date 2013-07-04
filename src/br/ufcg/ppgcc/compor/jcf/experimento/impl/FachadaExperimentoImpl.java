package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import java.util.List;

import net.compor.frameworks.jcf.api.ComporFacade;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Dependente;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.FachadaExperimento;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.FontePagadora;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Resultado;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Titular;

public class FachadaExperimentoImpl extends ComporFacade implements
		FachadaExperimento {

	@Override
	protected void addComponents() {
		add(new GerenteDeclaracao());
		add(new GerenteFontePagadora());
		add(new GerenteDependente());
		add(new GerenteImpostoRenda());
	}

	public void criarNovoTitular(Titular titular) {
		requestService("criarTitular", titular);
	}

	@SuppressWarnings("unchecked")
	public List<Titular> listarTitulares() {
		return (List<Titular>) requestService("listarTitulares");
	}

	public void criarFontePagadora(Titular titular, FontePagadora fonte) {
		requestService("criarFontePagadora", titular, fonte);
	}

	public Resultado declaracaoCompleta(Titular titular) {
		return (Resultado) requestService("declaracaoCompleta", titular);
	}

	public void criarDependente(Titular titular, Dependente dependente) {
		requestService("criarDependente", titular, dependente);
	}

	@SuppressWarnings("unchecked")
	public List<FontePagadora> listarFontes(Titular titular) {
		return (List<FontePagadora>) requestService("listarFontesPagadoras",
				titular);
	}

	@SuppressWarnings("unchecked")
	public List<Dependente> listarDependentes(Titular titular) {
		return (List<Dependente>) requestService("listarDependentes",
				titular);
	}

}
