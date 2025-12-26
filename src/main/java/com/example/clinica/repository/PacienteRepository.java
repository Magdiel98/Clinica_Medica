package com.example.clinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clinica.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{
	List<Paciente> findAllByAtivoTrue();
}
