package com.example.clinica.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.clinica.dto.paciente.PacienteRequestDTO;
import com.example.clinica.dto.paciente.PacienteResponseDTO;
import com.example.clinica.entity.Paciente;
import com.example.clinica.entity.TelefonePaciente;
import com.example.clinica.repository.PacienteRepository;




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
		
		return repository.save(paciente);
	}
	
	public List<PacienteResponseDTO> retornar() {
		return repository.findAll().stream()
				.map(PacienteResponseDTO::new).toList();
	}

}
