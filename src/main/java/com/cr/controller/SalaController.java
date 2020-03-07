package com.cr.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cr.model.SalaDTO;

@RestController
@RequestMapping
public class SalaController {

	@CrossOrigin
	@PostMapping
	public ResponseEntity<SalaDTO> criarSala(@RequestBody SalaDTO sala) {
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
}
