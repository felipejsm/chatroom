package com.cr.model;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Sala")
@Table(name = "sala")
public class SalaModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7346009952754851521L;

	@Id
	@GeneratedValue
	private Long id;
	private AtomicInteger numeroMaximoParticipantes;
	//https://stackoverflow.com/questions/17076546/org-hibernate-annotationexception-onetoone-or-manytoone-on-entities-question/19099985
	@ManyToOne(targetEntity = UsuarioModel.class)
	private List<UsuarioModel> participantesOnline;
	private Boolean restricaoDeIdade;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public AtomicInteger getNumeroMaximoParticipantes() {
		return numeroMaximoParticipantes;
	}
	public void setNumeroMaximoParticipantes(AtomicInteger numeroMaximoParticipantes) {
		this.numeroMaximoParticipantes = numeroMaximoParticipantes;
	}
	public List<UsuarioModel> getParticipantesOnline() {
		return participantesOnline;
	}
	public void setParticipantesOnline(List<UsuarioModel> participantesOnline) {
		this.participantesOnline = participantesOnline;
	}
	public Boolean getRestricaoDeIdade() {
		return restricaoDeIdade;
	}
	public void setRestricaoDeIdade(Boolean restricaoDeIdade) {
		this.restricaoDeIdade = restricaoDeIdade;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
