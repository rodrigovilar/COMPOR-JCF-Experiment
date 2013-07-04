package br.ufcg.ppgcc.compor.jcf.experimento.util;

public class Validacao {
											    
	private static final String MASCARA_CNPJ = "(^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2})$";
	private static final String MASCARA_CPF = "(^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2})$";

	public static boolean cnpj(String cnpj){
		return cnpj.matches(MASCARA_CNPJ);
	}

	public static boolean cpf(String cpf){
		return cpf.matches(MASCARA_CPF);
	}

	public static boolean cpfOuCnpj(String cpfCnpj){
		return cnpj(cpfCnpj) || cpf(cpfCnpj);
	}

	public static boolean obrigatorio(String valor) {
		return valor != null && !valor.equals(""); 
	}
}
