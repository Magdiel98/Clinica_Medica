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

import com.example.clinica.dto.consulta.ConsultaRequestDTO;
import com.example.clinica.dto.consulta.ConsultaResponseDTO;
import com.example.clinica.dto.consulta.ConsultaUpdateDTO;
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
	public ResponseEntity<ConsultaResponseDTO> agendar(@RequestBody @Valid ConsultaRequestDTO dto, UriComponentsBuilder uriBuilder) {
		var cons = service.agendar(dto);
		var uri = uriBuilder.path("consultas/{id}").buildAndExpand(cons.getIdConsulta()).toUri();
		return ResponseEntity.created(uri).body(new ConsultaResponseDTO(cons));
	}
	
	@GetMapping
	public ResponseEntity<List<ConsultaResponseDTO>> exibir(){
		return ResponseEntity.ok(service.retornar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ConsultaResponseDTO> detalhar(@PathVariable Long id){
		var consulta = service.detalhado(id);
		return ResponseEntity.ok(new ConsultaResponseDTO(consulta));
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<ConsultaResponseDTO> atualizar(
			@PathVariable Long id, 
			@RequestBody ConsultaUpdateDTO dto
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
	public ResponseEntity<ConsultaResponseDTO> ativar(@PathVariable Long id) {
		service.reativar(id);
		return ResponseEntity.noContent().build();
	}
}
