package com.cr.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cr.model.SalaModel;

@Repository
public interface SalaRepository extends JpaRepository<SalaModel, Long> {

}
