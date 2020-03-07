package com.cr.respository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cr.model.MensagemModel;

@Repository
public interface MensagemRepository extends JpaRepository<MensagemModel, Long> {
	
	@Query("SELECT m FROM Mensagem m WHERE :myDate >= m.data ORDER BY m.data")
	List<MensagemModel> findaAllMensagensAPartirDe(@Param("myDate") LocalDateTime myDate);
	
}
