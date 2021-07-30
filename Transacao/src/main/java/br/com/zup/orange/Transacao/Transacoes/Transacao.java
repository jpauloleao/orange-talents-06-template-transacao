package br.com.zup.orange.Transacao.Transacoes;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Transacao {

	private String id;
	private BigDecimal valor;
	private Estabelecimento estabelecimento;
	private Cartao cartao;
	private LocalDateTime efetivadaEm;

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
