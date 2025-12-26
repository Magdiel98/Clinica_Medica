package com.example.clinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clinica.entity.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long>{
	List<Consulta> findAllByAtivoTrue();
}
