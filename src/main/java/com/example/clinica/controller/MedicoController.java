package com.example.clinica.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.clinica.dto.medico.MedicoRequestDTO;
import com.example.clinica.service.MedicoService;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
	
	private final MedicoService service;
	
	public MedicoController(MedicoService service) {
		this.service = service;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void criar(@RequestBody MedicoRequestDTO dto) {
		service.salvar(dto);
	}
}
