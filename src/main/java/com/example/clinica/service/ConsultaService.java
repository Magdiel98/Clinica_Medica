package com.example.clinica.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.clinica.dto.consulta.ConsultaRequestDTO;
import com.example.clinica.dto.consulta.ConsultaResponseDTO;
import com.example.clinica.dto.consulta.ConsultaUpdateDTO;
import com.example.clinica.entity.Consulta;
import com.example.clinica.enums.StatusConsulta;
import com.example.clinica.repository.ConsultaRepository;
import com.example.clinica.repository.MedicoRepository;
import com.example.clinica.repository.PacienteRepository;

import jakarta.persistence.EntityNotFoundException;



/*
 * Use o Transactional quando for:
 * Gravar Dados;
 * Alterar Dados;
 * Remover Dados.
 * */

@Service
public class ConsultaService {
	
	private final ConsultaRepository consultaRepository;
	private final PacienteRepository pacienteRepository;
	private final MedicoRepository medicoRepository;
	
	public ConsultaService(
			ConsultaRepository consultaRepository,
			PacienteRepository pacienteRepository,
			MedicoRepository medicoRepository)
	{
		this.consultaRepository = consultaRepository;
		this.pacienteRepository = pacienteRepository;
		this.medicoRepository = medicoRepository;
	}
	
	@Transactional
	public Consulta agendar(ConsultaRequestDTO dto) {
		Consulta consulta = new Consulta();
		consulta.setDataConsulta(dto.data());
		consulta.setHoraConsulta(dto.hora());
		consulta.setStatusConsulta(StatusConsulta.AGENDADA);
		
		consulta.setPaciente(pacienteRepository.findById(dto.pacienteId()).orElseThrow());
		
		consulta.setMedico(medicoRepository.findById(dto.medicoId()).orElseThrow());
		
		consultaRepository.save(consulta);
		return consulta; 
	}
	
	public List<ConsultaResponseDTO> retornar(){
		return consultaRepository.findAllByAtivoTrue().stream()
				.map(ConsultaResponseDTO::new).toList();
	}
	
	@Transactional
	public void reativar(Long id){
		var consulta = consultaRepository.getReferenceById(id);
		consulta.ativar();
	}
	
	@Transactional
	public Consulta modificar(Long id, ConsultaUpdateDTO dto) {
		Consulta consulta = consultaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Consulta não encontrada"));
		
		if(dto.data() != null) {
			consulta.setDataConsulta(dto.data());
		}
		
		if(dto.hora() != null) {
			consulta.setHoraConsulta(dto.hora());
		}
		
		if(dto.status() != null) {
			consulta.setStatusConsulta(dto.status());
		}
		
		if(dto.medicoId() != null) {
			consulta.setMedico(
					medicoRepository.findById(dto.medicoId())
						.orElseThrow(() -> 
						new IllegalArgumentException("Médico não encontrado"))
					);
		}
		
		return consulta;		
	}
	
	
	@Transactional
	public void cancelar(Long id) {
		Consulta consulta = consultaRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
		
		consulta.setAtivo(false);
		consulta.setStatusConsulta(StatusConsulta.CANCELADA);
	}
}
