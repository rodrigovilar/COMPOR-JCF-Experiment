package br.ufcg.ppgcc.compor.jcf.experimento.impl;

import net.compor.frameworks.jcf.api.Decorator;
import net.compor.frameworks.jcf.api.Service;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.ExcecaoImpostoDeRenda;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.FontePagadora;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Titular;
import br.ufcg.ppgcc.compor.jcf.experimento.util.Validacao;

public class ValidacaoFontePagadora extends Decorator<GerenteFontePagadora>{

	private Validacao validacao = new Validacao();
	
	public ValidacaoFontePagadora(GerenteFontePagadora innerComponent) {
		super(innerComponent);
	}

	@Service(name = "criarFontePagadora")
	public void criarNovaFontePagadora(Titular titular,
			FontePagadora fontePagadora) {
		if (!validacao.obrigatorio(fontePagadora.getNome())) {
			throw new ExcecaoImpostoDeRenda("O campo nome é obrigatório");
		}

		if (!validacao.obrigatorio(fontePagadora.getCpfCnpj())) {
			throw new ExcecaoImpostoDeRenda("O campo CPF/CNPJ é obrigatório");
		}

		if (!validacao.cpfOuCnpj(fontePagadora.getCpfCnpj())) {
			throw new ExcecaoImpostoDeRenda("O campo CPF/CNPJ está inválido");
		}

		if (fontePagadora.getRendimentoRecebidos() <= 0) {
			throw new ExcecaoImpostoDeRenda("O campo rendimantos recebidos deve ser maior que zero");
		}

		getInnerComponent().criarNovaFontePagadora(titular, fontePagadora);
	}	
}
