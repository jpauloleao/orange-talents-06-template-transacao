package br.com.zup.orange.Transacao.Transacoes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import br.com.zup.orange.Transacao.Cartao.Cartao;
import br.com.zup.orange.Transacao.Estabelecimento.Estabelecimento;

@Entity
public class Transacao {

	@Id
	private String id;

	@NotNull
	private BigDecimal valor;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@NotNull
	private Estabelecimento estabelecimento;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@NotNull
	private Cartao cartao;

	@NotNull
	private LocalDateTime efetivadaEm;

	public Transacao(String id, @NotNull BigDecimal valor, @NotNull Estabelecimento estabelecimento,
			@NotNull Cartao cartao, @NotNull LocalDateTime efetivadaEm) {
		super();
		this.id = id;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}

	@Deprecated
	public Transacao() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}
}
