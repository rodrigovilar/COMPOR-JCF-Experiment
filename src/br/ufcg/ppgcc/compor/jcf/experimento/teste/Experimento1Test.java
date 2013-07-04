package br.ufcg.ppgcc.compor.jcf.experimento.teste;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Declaracao;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Dependente;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.Endereco;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.FachadaExperimento;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.FontePagadora;
import br.ufcg.ppgcc.compor.jcf.experimento.fachada.RelatorioCompleto;

public class Experimento1Test {

	private FachadaExperimento fachada;

	@Before
	public void iniciar() {
		//Coloque sua Fachada aqui.
		fachada = null;
	}

	@Test
	public void novaDeclaracao() {
		Declaracao declaracao = criarDeclaracaoMinima();
		verificaCriacaoDeclaracao(declaracao);
	}

	@Test
	public void declaracaoCompleta() {
		Declaracao declaracao = criarDeclaracaoPadrao();
		verificaCriacaoDeclaracao(declaracao);
	}

	@Test
	public void duasDeclaracoes() {
		Declaracao declaracao1 = criarDeclaracaoPadrao();
		fachada.criarNovaDeclaracao(declaracao1);
		Declaracao declaracao2 = criarDeclaracaoMinima();
		fachada.criarNovaDeclaracao(declaracao2);

		List<Declaracao> declaracoes = fachada.listarDeclaracoes();
		assertEquals(2, declaracoes.size());
		assertEquals(declaracao1, declaracoes.get(0));
		assertEquals(declaracao2, declaracoes.get(1));
	}

	@Test
	public void novaFontePagadora() {
		FontePagadora fonte = criarFontePagadoraPadrao1();
		Declaracao declaracaoSalva = salvarDeclaracaoComUmaFonte(fonte);

		List<FontePagadora> fontes = fachada.listarFontes(declaracaoSalva);
		assertEquals(1, fontes.size());
		assertEquals(fonte, fontes.get(0));
	}

	@Test
	public void duasFontesPagadorasEmUmaDeclaracao() {
		Declaracao declaracao = criarDeclaracaoPadrao();
		fachada.criarNovaDeclaracao(declaracao);
		FontePagadora fonte1 = criarFontePagadoraPadrao1();
		fachada.criarFontePagadora(declaracao, fonte1);
		FontePagadora fonte2 = criarFontePagadoraPadrao2();
		fachada.criarFontePagadora(declaracao, fonte2);

		List<FontePagadora> fontes = fachada.listarFontes(declaracao);
		assertEquals(2, fontes.size());
		assertEquals(fonte1, fontes.get(0));
		assertEquals(fonte2, fontes.get(1));
	}

	@Test
	public void duasFontesPagadorasUmaEmCadaDeclaracao() {
		Declaracao declaracao1 = criarDeclaracaoPadrao();
		fachada.criarNovaDeclaracao(declaracao1);
		FontePagadora fonte1 = criarFontePagadoraPadrao1();
		fachada.criarFontePagadora(declaracao1, fonte1);

		Declaracao declaracao2 = criarDeclaracaoMinima();
		fachada.criarNovaDeclaracao(declaracao2);
		FontePagadora fonte2 = criarFontePagadoraPadrao2();
		fachada.criarFontePagadora(declaracao2, fonte2);

		List<FontePagadora> fontes1 = fachada.listarFontes(declaracao1);
		assertEquals(1, fontes1.size());
		assertEquals(fonte1, fontes1.get(0));

		List<FontePagadora> fontes2 = fachada.listarFontes(declaracao2);
		assertEquals(1, fontes2.size());
		assertEquals(fonte2, fontes2.get(0));
	}

	@Test
	public void novoDependente() {
		Declaracao declaracao = criarDeclaracaoPadrao();
		fachada.criarNovaDeclaracao(declaracao);

		Dependente dependente = criarDependentePadrao1();
		fachada.criarDependente(declaracao, dependente);

		List<Dependente> dependentes = fachada.listarDependentes(declaracao);
		assertEquals(1, dependentes.size());
		assertEquals(dependente, dependentes.get(0));
	}

	@Test
	public void doisDependentesEmUmaDeclaracao() {
		Declaracao declaracao = criarDeclaracaoPadrao();
		fachada.criarNovaDeclaracao(declaracao);
		Dependente dependente1 = criarDependentePadrao1();
		fachada.criarDependente(declaracao, dependente1);
		Dependente dependente2 = criarDependentePadrao2();
		fachada.criarDependente(declaracao, dependente2);

		List<Dependente> dependentes = fachada.listarDependentes(declaracao);
		assertEquals(2, dependentes.size());
		assertEquals(dependente1, dependentes.get(0));
		assertEquals(dependente2, dependentes.get(1));
	}

	@Test
	public void doisDependentesUmEmCadaDeclaracao() {
		Declaracao declaracao1 = criarDeclaracaoPadrao();
		fachada.criarNovaDeclaracao(declaracao1);
		Dependente dependente1 = criarDependentePadrao1();
		fachada.criarDependente(declaracao1, dependente1);

		Declaracao declaracao2 = criarDeclaracaoMinima();
		fachada.criarNovaDeclaracao(declaracao2);
		Dependente dependente2 = criarDependentePadrao2();
		fachada.criarDependente(declaracao2, dependente2);

		List<Dependente> dependentes1 = fachada.listarDependentes(declaracao1);
		assertEquals(1, dependentes1.size());
		assertEquals(dependente1, dependentes1.get(0));

		List<Dependente> dependentes2 = fachada.listarDependentes(declaracao2);
		assertEquals(1, dependentes2.size());
		assertEquals(dependente2, dependentes2.get(0));
	}

	@Test
	public void calculoImpostoIsento_1() {
		FontePagadora fonte = criarFontePagadoraPorRenda(15000);
		Declaracao declaracao = salvarDeclaracaoComUmaFonte(fonte);

		RelatorioCompleto completo = fachada.relatorioCompleto(declaracao);
		assertEquals(0, completo.getImpostoDevido(), 0.1);
	}

	@Test
	public void calculoImpostoIsento_2() {
		FontePagadora fonte = criarFontePagadoraPorRenda(19000);
		Declaracao declaracao = salvarDeclaracaoComUmaFonte(fonte);

		RelatorioCompleto completo = fachada.relatorioCompleto(declaracao);
		assertEquals(0, completo.getImpostoDevido(), 0.1);
	}

	@Test
	public void calculoImpostoFaixa2_1() {
		FontePagadora fonte = criarFontePagadoraPorRenda(20000);
		Declaracao declaracao = salvarDeclaracaoComUmaFonte(fonte);

		RelatorioCompleto completo = fachada.relatorioCompleto(declaracao);
		assertEquals(26.60, completo.getImpostoDevido(), 0.1);
	}

	@Test
	public void calculoImpostoFaixa2_2() {
		FontePagadora fonte = criarFontePagadoraPorRenda(39000);
		Declaracao declaracao = salvarDeclaracaoComUmaFonte(fonte);

		RelatorioCompleto completo = fachada.relatorioCompleto(declaracao);
		assertEquals(2168.45, completo.getImpostoDevido(), 0.1);
	}

	@Test
	public void calculoImpostoFaixa3_1() {
		FontePagadora fonte = criarFontePagadoraPorRenda(40000);
		Declaracao declaracao = salvarDeclaracaoComUmaFonte(fonte);

		RelatorioCompleto completo = fachada.relatorioCompleto(declaracao);
		assertEquals(2374.21, completo.getImpostoDevido(), 0.1);
	}

	@Test
	public void calculoImpostoFaixa3_2() {
		FontePagadora fonte = criarFontePagadoraPorRenda(49000);
		Declaracao declaracao = salvarDeclaracaoComUmaFonte(fonte);

		RelatorioCompleto completo = fachada.relatorioCompleto(declaracao);
		assertEquals(4399.21, completo.getImpostoDevido(), 0.1);
	}

	@Test
	public void calculoImpostoFaixa4() {
		FontePagadora fonte = criarFontePagadoraPorRenda(50000);
		Declaracao declaracao = salvarDeclaracaoComUmaFonte(fonte);

		RelatorioCompleto completo = fachada.relatorioCompleto(declaracao);
		assertEquals(4671.62, completo.getImpostoDevido(), 0.1);
	}

	@Test
	public void calculoImpostoFaixa4ComDependente() {
		FontePagadora fonte = criarFontePagadoraPorRenda(50000);
		Declaracao declaracao = salvarDeclaracaoComUmaFonte(fonte);
		Dependente dependente1 = criarDependentePadrao1();
		fachada.criarDependente(declaracao, dependente1);

		RelatorioCompleto completo = fachada.relatorioCompleto(declaracao);
		assertEquals(4179.89, completo.getImpostoDevido(), 0.1);
	}

	private Declaracao criarDeclaracaoMinima() {
		Declaracao declaracao = new Declaracao();
		declaracao.setNome("Jose");
		declaracao.setCpf("000.000.000-00");
		return declaracao;
	}

	private Declaracao criarDeclaracaoPadrao() {
		Declaracao declaracao = criarDeclaracaoMinima();
		declaracao.setDataNascimento(Calendar.getInstance());
		declaracao.setTituloEleitoral("000");
		declaracao.setEndereco(criarEnderecoPadrao());
		declaracao.setNaturezaOcupacao(10);
		declaracao.setOcupacaoPrincipal(100);
		return declaracao;
	}

	private Declaracao salvarDeclaracaoComUmaFonte(FontePagadora fonte) {
		Declaracao declaracao = criarDeclaracaoPadrao();
		fachada.criarNovaDeclaracao(declaracao);
		fachada.criarFontePagadora(declaracao, fonte);
		List<Declaracao> declaracoes = fachada.listarDeclaracoes();
		Declaracao declaracaoSalva = declaracoes.get(0);
		return declaracaoSalva;
	}

	private void verificaCriacaoDeclaracao(Declaracao declaracao) {
		fachada.criarNovaDeclaracao(declaracao);
		List<Declaracao> declaracoes = fachada.listarDeclaracoes();

		assertEquals(1, declaracoes.size());
		assertEquals(declaracao, declaracoes.get(0));
	}

	private Endereco criarEnderecoPadrao() {
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Log");
		endereco.setNumero(0);
		endereco.setComplemento("A");
		endereco.setBairro("Bai");
		endereco.setMunicipio("Mun");
		endereco.setEstado("Est");
		endereco.setCEP("00000-000");
		return endereco;
	}

	private FontePagadora criarFontePagadora(String nome, String cpfCnpj,
			int rendimentoRecebidos) {
		FontePagadora fonte = new FontePagadora();
		fonte.setNome(nome);
		fonte.setCpfCnpj(cpfCnpj);
		fonte.setRendimentoRecebidos(rendimentoRecebidos);
		return fonte;
	}

	private FontePagadora criarFontePagadoraPorRenda(int renda) {
		return criarFontePagadora("UFCG", "000.000.000/0000-00", renda);
	}

	private FontePagadora criarFontePagadoraPadrao1() {
		return criarFontePagadora("UFCG", "000.000.000/0000-00", 50000);
	}

	private FontePagadora criarFontePagadoraPadrao2() {
		return criarFontePagadora("UFPB", "000.000.000/0000-00", 20000);
	}

	private Dependente criarDependentePadrao1() {
		return criarDependente("000", Calendar.getInstance(), "Filho 1", 21);
	}

	private Dependente criarDependentePadrao2() {
		return criarDependente("111", Calendar.getInstance(), "Filho 2", 21);
	}

	private Dependente criarDependente(String cpf, Calendar dataNascimento,
			String nome, int tipo) {
		Dependente dependente = new Dependente();
		dependente.setCpf(cpf);
		dependente.setDataNascimento(dataNascimento);
		dependente.setNome(nome);
		dependente.setTipo(tipo);
		return dependente;
	}

}
