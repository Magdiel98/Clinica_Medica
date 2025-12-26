package com.example.clinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clinica.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{
	List<Medico> findAllByAtivoTrue();
}
