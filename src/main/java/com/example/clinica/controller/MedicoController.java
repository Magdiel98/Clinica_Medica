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

import com.example.clinica.dto.medico.MedicoRequestDTO;
import com.example.clinica.dto.medico.MedicoResponseDTO;
import com.example.clinica.dto.medico.MedicoUpdateDTO;
import com.example.clinica.service.MedicoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
	
	private final MedicoService service;
	
	public MedicoController(MedicoService service) {
		this.service = service;
	}
	
	@PostMapping
	public  ResponseEntity<MedicoResponseDTO> criar(@RequestBody @Valid MedicoRequestDTO dto, UriComponentsBuilder uriBuilder) {
		
		var med = service.salvar(dto);
		var uri = uriBuilder.path("medicos/{id}").buildAndExpand(med.getIdMedico()).toUri();
		return ResponseEntity.created(uri).body(new MedicoResponseDTO(med));
	}
	
	@GetMapping
	public ResponseEntity<List<MedicoResponseDTO>> exibir(){
		return ResponseEntity.ok(service.retornar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MedicoResponseDTO> detalhar(@PathVariable Long id){
		var medico = service.detalhado(id);
		return ResponseEntity.ok(new MedicoResponseDTO(medico));
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<MedicoResponseDTO> atualizar(
			@PathVariable Long id,
			@RequestBody MedicoUpdateDTO dto
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
	public ResponseEntity<MedicoResponseDTO> ativar(@PathVariable Long id) {
		service.reativar(id);
		return ResponseEntity.noContent().build();
	}
}
