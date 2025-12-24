package com.example.clinica.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.clinica.dto.consulta.ConsultaRequestDTO;
import com.example.clinica.dto.consulta.ConsultaResponseDTO;
import com.example.clinica.entity.Consulta;
import com.example.clinica.enums.StatusConsulta;
import com.example.clinica.repository.ConsultaRepository;
import com.example.clinica.repository.MedicoRepository;
import com.example.clinica.repository.PacienteRepository;



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
		
		return consultaRepository.save(consulta);
	}
	
	public List<ConsultaResponseDTO> retornar(){
		return consultaRepository.findAll().stream()
				.map(ConsultaResponseDTO::new).toList();
	}
}
