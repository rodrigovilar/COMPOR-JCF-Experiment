package br.ufcg.ppgcc.compor.jcf.experimento.fachada;

import java.util.Calendar;

public class Declaracao {

	private String nome;
	private String cpf;
	private Calendar dataNascimento;
	private String tituloEleitoral;
	private Endereco endereco;
	private int naturezaOcupacao;
	private int ocupacaoPrincipal;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result
				+ ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + naturezaOcupacao;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ocupacaoPrincipal;
		result = prime * result
				+ ((tituloEleitoral == null) ? 0 : tituloEleitoral.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Declaracao other = (Declaracao) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (naturezaOcupacao != other.naturezaOcupacao)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (ocupacaoPrincipal != other.ocupacaoPrincipal)
			return false;
		if (tituloEleitoral == null) {
			if (other.tituloEleitoral != null)
				return false;
		} else if (!tituloEleitoral.equals(other.tituloEleitoral))
			return false;
		return true;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTituloEleitoral() {
		return tituloEleitoral;
	}

	public void setTituloEleitoral(String tituloEleitoral) {
		this.tituloEleitoral = tituloEleitoral;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public int getNaturezaOcupacao() {
		return naturezaOcupacao;
	}

	public void setNaturezaOcupacao(int naturezaOcupacao) {
		this.naturezaOcupacao = naturezaOcupacao;
	}

	public int getOcupacaoPrincipal() {
		return ocupacaoPrincipal;
	}

	public void setOcupacaoPrincipal(int ocupacaoPrincipal) {
		this.ocupacaoPrincipal = ocupacaoPrincipal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
