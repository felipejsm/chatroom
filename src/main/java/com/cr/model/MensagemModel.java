package com.cr.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity(name = "Mensagem")
@Table(name = "mensagem")
public class MensagemModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4062327087921346171L;
	@Id
	@GeneratedValue
	private Long id;
	@CreationTimestamp
	private LocalDateTime data;
	private String conteudo;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private UsuarioModel usuario;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
}
