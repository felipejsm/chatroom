package com.cr.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.cr.model.HorarioEntradaChat;
import com.cr.model.MensagemDTO;
import com.cr.service.MensagemService;

@RestController
@RequestMapping("/async/mensagem")
public class MensagemControllerAsync {
	
	@Autowired
	public MensagemService mensagemService;
	
	@CrossOrigin
	@PostMapping("/horario")
	public DeferredResult<ResponseEntity<List<MensagemDTO>>> getListMensagem(@RequestBody HorarioEntradaChat horarioEntradaChat) {
		DeferredResult<ResponseEntity<List<MensagemDTO>>> output = new DeferredResult<>();
		ForkJoinPool.commonPool().submit(() -> {
			List<MensagemDTO> lista = new ArrayList<>();
			lista = this.mensagemService.getMensagem(horarioEntradaChat.horario);
			ResponseEntity<List<MensagemDTO>> response = ResponseEntity.status(HttpStatus.FOUND).body(lista);
			output.setResult(response);
		});
		return output;
	}
	@CrossOrigin
	@PostMapping
	public DeferredResult<ResponseEntity<String>> postMensagem(@RequestBody MensagemDTO mensagemDto) {
		DeferredResult<ResponseEntity<String>> output = new DeferredResult<>();
		ForkJoinPool.commonPool().submit(() -> {
			this.mensagemService.setMensagem(mensagemDto);
			ResponseEntity<String> response = ResponseEntity.status(HttpStatus.CREATED).build();
			output.setResult(response);
		});
		return output;
	}

}
