package com.example.clinica.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clinica.dto.consulta.ConsultaRequestDTO;
import com.example.clinica.service.ConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
	private final ConsultaService service;
	
	public ConsultaController(ConsultaService service) {
		this.service = service;
	}
	
	public void agendar(@RequestBody ConsultaRequestDTO dto) {
		service.agendar(dto);
	}
}
