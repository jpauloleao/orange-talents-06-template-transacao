package br.com.zup.orange.Transacao.Transacoes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/transacao")
@RestController
public class TransacaoController {

	private final TransacaoRepository repository;
	private final Logger logger = LoggerFactory.getLogger(TransacaoController.class);

	public TransacaoController(TransacaoRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/cartao/{id}")
	public ResponseEntity<?> listaTransacoes(@PathVariable String id,
			@PageableDefault(sort = "efetivadaEm", direction = Direction.DESC, page = 0, size = 2) Pageable pageable) {

		if (!repository.existsByCartaoId(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cartão Invalido");
		}

		Page<Transacao> transacoes = repository.findAllByCartaoId(id, pageable);

		return ResponseEntity.ok(TransacaoResponse.converter(transacoes));
	}
}
