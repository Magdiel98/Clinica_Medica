package com.example.clinica.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.clinica.dto.paciente.PacienteRequestDTO;
import com.example.clinica.dto.paciente.PacienteResponseDTO;
import com.example.clinica.dto.paciente.PacienteUpdateDTO;
import com.example.clinica.entity.Paciente;
import com.example.clinica.entity.TelefonePaciente;
import com.example.clinica.repository.PacienteRepository;

import jakarta.persistence.EntityNotFoundException;




/*
 * Use o Transactional quando for:
 * Gravar Dados;
 * Alterar Dados;
 * Remover Dados.
 * */


@Service
public class PacienteService {
	
	private final PacienteRepository repository;
	
	public PacienteService(PacienteRepository repository) {
		this.repository = repository;
	}
	
	
	@Transactional
	public Paciente salvar(PacienteRequestDTO dto) {
		Paciente paciente = new Paciente();
		paciente.setNomePaciente(dto.nome());
		paciente.setEmailPaciente(dto.email());
		paciente.setCpf(dto.cpf());
		
		List<TelefonePaciente> telefones = dto.telefones().stream()
				.map(t -> {
					TelefonePaciente tel = new TelefonePaciente();
					tel.setTelefonePaciente(t);
					tel.setPaciente(paciente);
					return tel; 
				}).toList();
		paciente.setTelefones(telefones);
		
		repository.save(paciente);
		return paciente;
	}
	
	public List<PacienteResponseDTO> retornar() {
		return repository.findAllByAtivoTrue().stream()
				.map(PacienteResponseDTO::new).toList();
	}
	
	public Paciente detalhado(Long id) {
		return repository.getReferenceById(id);
	}
	
	@Transactional
	public void reativar(Long id){
		var paciente = repository.getReferenceById(id);
		paciente.ativar();
	}
	
	
	@Transactional
	public Paciente modificar(Long id, PacienteUpdateDTO dto) {
		Paciente paciente = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));
		
		if(dto.nome() != null){
			paciente.setNomePaciente(dto.nome());
		}
		
		if(dto.email() != null) {
			paciente.setEmailPaciente(dto.email());
		}
		
		if(dto.cpf() != null) {
			paciente.setCpf(dto.cpf());
		}
		
		if(dto.telefones() != null) {
			paciente.getTelefones().clear();
			
			List<TelefonePaciente> novosTelefones = dto.telefones().stream()
					.map( t -> {
						TelefonePaciente tel = new TelefonePaciente();
						tel.setTelefonePaciente(t);
						tel.setPaciente(paciente);
						return tel;
					})
					.toList();
			paciente.getTelefones().addAll(novosTelefones);
		}
		
		return paciente;
		
	}
	
	@Transactional
	public void cancelar(Long id) {
		Paciente paciente = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
		
		paciente.setAtivo(false);
	}

}
