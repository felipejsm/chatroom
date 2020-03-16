package com.cr.controller;

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

import com.cr.model.UsuarioDTO;
import com.cr.service.UsuarioService;


@RestController
@RequestMapping("/async/usuario")
public class UsuarioControllerAsync {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@CrossOrigin
	@PostMapping
	public DeferredResult<ResponseEntity<UsuarioDTO>> criarUsuario(@RequestBody UsuarioDTO usuario) {
		DeferredResult<ResponseEntity<UsuarioDTO>> output = new DeferredResult<>();
		ForkJoinPool.commonPool().submit(() -> {
			UsuarioDTO usuarioCriado = this.usuarioService.criarOuAtualizar(usuario);
			output.setResult(ResponseEntity.status(HttpStatus.CREATED).body(usuarioCriado));
		});
		return output;
	}
}
