package com.cr.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cr.model.HorarioEntradaChat;
import com.cr.model.MensagemDTO;
import com.cr.service.MensagemService;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {
	
	@Autowired
	public MensagemService mensagemService;
	
	@CrossOrigin
	@PostMapping("/horario")
	public ResponseEntity<List<MensagemDTO>> getListMensagem(@RequestBody HorarioEntradaChat horarioEntradaChat) {
		List<MensagemDTO> lista = new ArrayList<>();
		lista = this.mensagemService.getMensagem(horarioEntradaChat.horario);
		return ResponseEntity.status(HttpStatus.FOUND).body(lista);
	}
	@CrossOrigin
	@PostMapping
	public ResponseEntity<String> postMensagem(@RequestBody MensagemDTO mensagemDto) {
		this.mensagemService.setMensagem(mensagemDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
