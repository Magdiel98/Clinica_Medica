package com.example.clinica.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.clinica.dto.consulta.ConsultaRequestDTO;
import com.example.clinica.dto.consulta.ConsultaResponseDTO;
import com.example.clinica.service.ConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
	private final ConsultaService service;
	
	public ConsultaController(ConsultaService service) {
		this.service = service;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void agendar(@RequestBody ConsultaRequestDTO dto) {
		service.agendar(dto);
	}
	
	@GetMapping
	public List<ConsultaResponseDTO> exibir(){
		return service.retornar();
	}
}
