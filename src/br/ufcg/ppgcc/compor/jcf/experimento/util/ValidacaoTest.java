package br.ufcg.ppgcc.compor.jcf.experimento.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidacaoTest {

	@Test
	public void cnpj() {
		assertTrue(Validacao.cnpj("00.000.000/0000-00"));
		assertTrue(Validacao.cnpj("23.456.789/1011-12"));

		assertFalse(Validacao.cnpj("00000000000000"));
		assertFalse(Validacao.cnpj("00.000.000/0000-00a"));
		assertFalse(Validacao.cnpj("abc"));
	}

	@Test
	public void cpf() {
		assertTrue(Validacao.cpf("000.000.000-00"));
		assertTrue(Validacao.cpf("123.456.789-10"));

		assertFalse(Validacao.cpf("00000000000"));
		assertFalse(Validacao.cpf("000.000.000-00a"));
		assertFalse(Validacao.cpf("abc"));
	}

	@Test
	public void cpfCnpj() {
		assertTrue(Validacao.cpfOuCnpj("000.000.000-00"));
		assertTrue(Validacao.cpfOuCnpj("123.456.789-10"));
		assertTrue(Validacao.cpfOuCnpj("00.000.000/0000-00"));
		assertTrue(Validacao.cpfOuCnpj("23.456.789/1011-12"));

		assertFalse(Validacao.cpfOuCnpj("00000000000"));
		assertFalse(Validacao.cpfOuCnpj("000.000.000-00a"));
		assertFalse(Validacao.cpfOuCnpj("00.000.000/0000-00a"));
		assertFalse(Validacao.cpfOuCnpj("00000000000000"));
		assertFalse(Validacao.cpfOuCnpj("abc"));
	}
	
	@Test
	public void obrigatorio() {
		assertTrue(Validacao.obrigatorio("a"));
		assertFalse(Validacao.obrigatorio(""));
		assertFalse(Validacao.obrigatorio(null));		
	}
}
