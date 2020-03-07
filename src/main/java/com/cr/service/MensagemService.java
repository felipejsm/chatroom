package com.cr.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cr.model.MensagemDTO;
import com.cr.model.MensagemModel;
import com.cr.model.UsuarioModel;
import com.cr.respository.MensagemRepository;
import com.cr.respository.UsuarioRepository;

@Component
public class MensagemService {
	@Autowired
	private MensagemRepository mensagemRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
	
	public List<MensagemDTO> getMensagem(String horario) {
		LocalDateTime myDate = LocalDateTime.parse(horario, formatter);
		
		MensagemDTO msgDto = new MensagemDTO();
		List<MensagemDTO> mensagensDTO = new ArrayList<>();
		List<MensagemModel> mensagens = this.mensagemRepository.findaAllMensagensAPartirDe(myDate);
		for(MensagemModel m:mensagens) {
			msgDto.conteudo = m.getConteudo();
			msgDto.id = m.getId();
			msgDto.usuario = m.getUsuario().getId();
			msgDto.nick = m.getUsuario().getNick();
			msgDto.data = m.getData();
			mensagensDTO.add(msgDto);
			msgDto = new MensagemDTO();
		}
		
		return mensagensDTO;
	}
	
	public void setMensagem(MensagemDTO mensagemDto) {
		Optional<UsuarioModel> usuarioModelo = this.usuarioRepository.findById(mensagemDto.usuario);
		MensagemModel msg = new MensagemModel();
		msg.setConteudo(mensagemDto.conteudo);
		msg.setId(mensagemDto.id);
		msg.setUsuario(usuarioModelo.get());
		this.mensagemRepository.saveAndFlush(msg);
		this.usuarioRepository.saveAndFlush(usuarioModelo.get());
	}
}
