package com.example.clinica.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.clinica.dto.paciente.PacienteRequestDTO;
import com.example.clinica.dto.paciente.PacienteResponseDTO;
import com.example.clinica.dto.paciente.PacienteUpdateDTO;
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
	public  ResponseEntity<PacienteResponseDTO> criar(@RequestBody @Valid PacienteRequestDTO dto, UriComponentsBuilder uriBuilder) {
		
		var pac = service.salvar(dto);
		var uri = uriBuilder.path("medicos/{id}").buildAndExpand(pac.getIdPaciente()).toUri();
		return ResponseEntity.created(uri).body(new PacienteResponseDTO(pac));
	}
	
	@GetMapping
	public ResponseEntity<List<PacienteResponseDTO>> exibir(){
		return ResponseEntity.ok(service.retornar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PacienteResponseDTO> detalhar(@PathVariable Long id){
		var paciente = service.detalhado(id);
		return ResponseEntity.ok(new PacienteResponseDTO(paciente));
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<PacienteResponseDTO> atualizar(
			@PathVariable Long id,
			@RequestBody PacienteUpdateDTO dto
			)
	{
		service.modificar(id, dto);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("inativar/{id}")
	public ResponseEntity<Void> inativar(@PathVariable Long id) {
		service.cancelar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("ativar/{id}")
	public ResponseEntity<PacienteResponseDTO> ativar(@PathVariable Long id) {
		service.reativar(id);
		return ResponseEntity.noContent().build();
	}
}
