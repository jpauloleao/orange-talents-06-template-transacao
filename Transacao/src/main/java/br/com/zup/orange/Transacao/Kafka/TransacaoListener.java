package br.com.zup.orange.Transacao.Kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.zup.orange.Transacao.Transacoes.Transacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class TransacaoListener {

    private final Logger logger = LoggerFactory.getLogger(TransacaoListener.class);

	
	//Faz a verificação e lê as mensagens que foram gravadas no tópico em que foi definido.
	@KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void listener(Transacao eventoTransacao) {
		logger.info("-------------------------------------------------");
        logger.info("Id: {}", eventoTransacao.getId());
        logger.info("Valor: {}", eventoTransacao.getValor());
        logger.info("Nome do estabelecimento: {}", eventoTransacao.getEstabelecimento().getNome());
        logger.info("Dono do Cartão: {}", eventoTransacao.getCartao().getEmail());
        logger.info("Efetivada em: {}", eventoTransacao.getEfetivadaEm());
    }
}
