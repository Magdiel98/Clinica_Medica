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

import com.example.clinica.dto.paciente.PacienteRequestDTO;
import com.example.clinica.dto.paciente.PacienteResponseDTO;
import com.example.clinica.dto.paciente.PacienteUpdateDTO;
import com.example.clinica.entity.Paciente;
import com.example.clinica.service.PacienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	private final PacienteService service; 
	
	public PacienteController(PacienteService service) {
		this.service = service;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void criar(@RequestBody @Valid PacienteRequestDTO dto) {
		service.salvar(dto);
	}
	
	@GetMapping
	public List<PacienteResponseDTO> exibir(){
		return service.retornar();
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<PacienteResponseDTO> atualizar(
			@PathVariable Long id,
			@RequestBody PacienteUpdateDTO dto
			)
	{
		Paciente paciente = service.modificar(id, dto);
		return ResponseEntity.ok(new PacienteResponseDTO(paciente));
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
