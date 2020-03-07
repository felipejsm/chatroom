package com.cr.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cr.model.SalaDTO;
import com.cr.respository.SalaRepository;

@Service
public class SalaService {

		@Autowired
		private SalaRepository salaRepository;
		
		public SalaDTO criarOuAtualizar(SalaDTO salaDto) {
			Boolean isSalaJaCadastrada = Optional.ofNullable(salaDto.id).isPresent();//isEmpty();
			if (!isSalaJaCadastrada) {
			//	return criar(salaDto);
			} else {
			//	return atualizar(salaDto);
			}
			return null;
		}
		
//		public SalaDTO criar(SalaDTO novaSala) {
//			SalaModel modelo = new SalaModel();
//			modelo.setNumeroMaximoParticipantes(novaSala.numeroMaximoParticipantes);
//			modelo.setRestricaoDeIdade(novaSala.restricaoDeIdade);
//			modelo.setParticipantesOnline(participantesOnline);
//			modelo.setPassword(novoUsuario.password);
//			modelo = this.usuarioRepository.save(modelo);
//			novoUsuario.id = modelo.getId();
//			return novoUsuario;
//			
//		}
}
