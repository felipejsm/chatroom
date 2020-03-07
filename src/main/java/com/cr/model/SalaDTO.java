package com.cr.model;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SalaDTO {
	public Long id;
	public List<Long> usuarios;
	public String topico;
	public AtomicInteger numeroMaximoParticipantes;
	public Boolean restricaoDeIdade;
}
