package br.com.zup.orange.Transacao.Transacoes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.data.domain.Page;

import br.com.zup.orange.Transacao.Cartao.Cartao;
import br.com.zup.orange.Transacao.Estabelecimento.Estabelecimento;

public class TransacaoResponse {

	private String id;
	private BigDecimal valor;
	private Cartao donoCartao;
	private Estabelecimento estabelecimento;
	private LocalDateTime efetivadaEm;

	public TransacaoResponse(@Valid Transacao transacao) {
		this.id = transacao.getId();
		this.valor = transacao.getValor();
		this.donoCartao = transacao.getCartao();
		this.estabelecimento = transacao.getEstabelecimento();
		this.efetivadaEm = transacao.getEfetivadaEm();
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public String getDonoCartao() {
		return donoCartao.getEmail();
	}

	public String getEstabelecimento() {
		return estabelecimento.getNome();
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

	public static Page<TransacaoResponse> converter(Page<Transacao> transacoes) {
		return transacoes.map(TransacaoResponse::new);
	}

}
