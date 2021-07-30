package br.com.zup.orange.Transacao.Estabelecimento;

import javax.validation.constraints.NotNull;

public class EstabelecimentoRequest {

	private String nome;
	private String cidade;
	private String endereco;

	@Deprecated
	public EstabelecimentoRequest() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public @NotNull Estabelecimento toModel() {
		return new Estabelecimento(nome, cidade, endereco);
	}
}
