package br.ufcg.ppgcc.compor.jcf.experimento.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidacaoTest {

	Validacao validacao = new Validacao();
	
	@Test
	public void cnpj() {
		assertTrue(validacao.cnpj("00.000.000/0000-00"));
		assertTrue(validacao.cnpj("23.456.789/1011-12"));

		assertFalse(validacao.cnpj("00000000000000"));
		assertFalse(validacao.cnpj("00.000.000/0000-00a"));
		assertFalse(validacao.cnpj("abc"));
	}

	@Test
	public void cpf() {
		assertTrue(validacao.cpf("000.000.000-00"));
		assertTrue(validacao.cpf("123.456.789-10"));

		assertFalse(validacao.cpf("00000000000"));
		assertFalse(validacao.cpf("000.000.000-00a"));
		assertFalse(validacao.cpf("abc"));
	}

	@Test
	public void cpfCnpj() {
		assertTrue(validacao.cpfOuCnpj("000.000.000-00"));
		assertTrue(validacao.cpfOuCnpj("123.456.789-10"));
		assertTrue(validacao.cpfOuCnpj("00.000.000/0000-00"));
		assertTrue(validacao.cpfOuCnpj("23.456.789/1011-12"));

		assertFalse(validacao.cpfOuCnpj("00000000000"));
		assertFalse(validacao.cpfOuCnpj("000.000.000-00a"));
		assertFalse(validacao.cpfOuCnpj("00.000.000/0000-00a"));
		assertFalse(validacao.cpfOuCnpj("00000000000000"));
		assertFalse(validacao.cpfOuCnpj("abc"));
	}
	
	@Test
	public void obrigatorio() {
		assertTrue(validacao.obrigatorio("a"));
		assertFalse(validacao.obrigatorio(""));
		assertFalse(validacao.obrigatorio(null));		
	}
}
