package br.com.zup.orange.Transacao.Transacoes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.zup.orange.Transacao.Cartao.CartaoRequest;
import br.com.zup.orange.Transacao.Estabelecimento.EstabelecimentoRequest;

public class TransacaoRequest {
	
	private String id;
	private BigDecimal valor;
	private EstabelecimentoRequest estabelecimento;
	private CartaoRequest cartao;
	private LocalDateTime efetivadaEm;
	
	
	public TransacaoRequest(String id, BigDecimal valor, EstabelecimentoRequest estabelecimento, CartaoRequest cartao,
			LocalDateTime efetivadaEm) {
		super();
		this.id = id;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}
	
	@Deprecated
	public TransacaoRequest() {
		// TODO Auto-generated constructor stub
	}

	public Transacao toModel() {
		return new Transacao(id, valor, estabelecimento.toModel(), cartao.toModel(), efetivadaEm);
	}
	
	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public EstabelecimentoRequest getEstabelecimento() {
		return estabelecimento;
	}

	public CartaoRequest getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}
	
}
