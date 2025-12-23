package com.example.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clinica.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
