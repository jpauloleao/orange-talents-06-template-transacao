package br.com.zup.orange.Transacao.Cartao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Cartao {

	@Id
	private String id;

	@Email
	@NotBlank
	private String email;

	public Cartao(String id, @Email @NotBlank String email) {
		super();
		this.id = id;
		this.email = email;
	}

	@Deprecated
	public Cartao() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}
}