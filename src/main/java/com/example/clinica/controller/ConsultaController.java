package com.example.clinica.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.clinica.dto.consulta.ConsultaRequestDTO;
import com.example.clinica.dto.consulta.ConsultaResponseDTO;
import com.example.clinica.dto.consulta.ConsultaUpdateDTO;
import com.example.clinica.entity.Consulta;
import com.example.clinica.service.ConsultaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
	private final ConsultaService service;
	
	public ConsultaController(ConsultaService service) {
		this.service = service;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void agendar(@RequestBody @Valid ConsultaRequestDTO dto) {
		service.agendar(dto);
	}
	
	@GetMapping
	public List<ConsultaResponseDTO> exibir(){
		return service.retornar();
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<ConsultaResponseDTO> atualizar(
			@PathVariable Long id, 
			@RequestBody ConsultaUpdateDTO dto
			)
	{
		Consulta consulta = service.modificar(id, dto);
		return ResponseEntity.ok(new ConsultaResponseDTO(consulta));
	}
	
	@DeleteMapping("inativar/{id}")
	public ResponseEntity<Void> inativar(@PathVariable Long id) {
		service.cancelar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("ativar/{id}")
	public void ativar(@PathVariable Long id) {
		service.reativar(id);
	}
}
