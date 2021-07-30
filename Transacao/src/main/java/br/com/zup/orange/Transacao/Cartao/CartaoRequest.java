package br.com.zup.orange.Transacao.Cartao;

import javax.validation.constraints.NotNull;

public class CartaoRequest {

	private String id;
	private String email;

	@Deprecated
	public CartaoRequest() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public @NotNull Cartao toModel() {
		return new Cartao(id, email);
	}
}
