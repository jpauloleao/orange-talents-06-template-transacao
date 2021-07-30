package br.com.zup.orange.Transacao.Kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.zup.orange.Transacao.Transacoes.TransacaoRepository;
import br.com.zup.orange.Transacao.Transacoes.TransacaoRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class TransacaoListener {

	private final Logger logger = LoggerFactory.getLogger(TransacaoListener.class);
	private TransacaoRepository transacaoRepository;

	public TransacaoListener(TransacaoRepository repository) {
		this.transacaoRepository = repository;
	}

	// Faz a verificação e lê as mensagens que foram gravadas no tópico em que foi
	// definido.
	@KafkaListener(topics = "${spring.kafka.topic.transactions}")
	public void listener(TransacaoRequest eventoTransacao) {
		try {
			logger.info("-------------------------------------------------");
			logger.info("Id: {}", eventoTransacao.getId());
			logger.info("Valor: {}", eventoTransacao.getValor());
			logger.info("Nome do estabelecimento: {}", eventoTransacao.getEstabelecimento().getNome());
			logger.info("Dono do Cartão: {}", eventoTransacao.getCartao().getEmail());
			logger.info("Efetivada em: {}", eventoTransacao.getEfetivadaEm());

			transacaoRepository.save(eventoTransacao.toModel());

			logger.info("Cadastrado no Banco com sucesso");

		} catch (Exception e) {
			logger.error("Erro: {}", e.getMessage());
		}
	}
}
