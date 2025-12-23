package com.example.clinica.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.clinica.dto.paciente.PacienteRequestDTO;
import com.example.clinica.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	private final PacienteService service; 
	
	public PacienteController(PacienteService service) {
		this.service = service;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void criar(@RequestBody PacienteRequestDTO dto) {
		service.salvar(dto);
	}
}
