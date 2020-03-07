package com.cr.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cr.model.UsuarioDTO;
import com.cr.model.UsuarioModel;
import com.cr.respository.UsuarioRepository;

@Component
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UsuarioDTO criarOuAtualizar(UsuarioDTO usuarioDto) {
		Boolean isUsuarioCadastrado = Optional.ofNullable(usuarioDto.id).isPresent();//isEmpty()
		if (!isUsuarioCadastrado) {
			return criar(usuarioDto);
		} else {
			return atualizar(usuarioDto);
		}
	}

	private UsuarioDTO criar(UsuarioDTO novoUsuario) {
		UsuarioModel modelo = new UsuarioModel();
		modelo.setNick(novoUsuario.nick);
		modelo.setIdade(novoUsuario.idade);
		modelo.setNome(novoUsuario.nome);
		modelo.setPassword(novoUsuario.password);
		modelo = this.usuarioRepository.save(modelo);
		novoUsuario.id = modelo.getId();
		return novoUsuario;
	}

	private UsuarioDTO atualizar(UsuarioDTO usuario) {
		UsuarioModel modelo = new UsuarioModel(); //this.usuarioRepository.getOne(usuario.id);
		modelo.setIdade(usuario.idade);
		modelo.setNick(usuario.nick);
		modelo.setNome(usuario.nome);
		modelo.setPassword(usuario.password);
		this.usuarioRepository.save(modelo);
		return usuario;
	}
}
