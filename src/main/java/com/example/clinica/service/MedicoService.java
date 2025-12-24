package com.example.clinica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.clinica.dto.medico.MedicoRequestDTO;
import com.example.clinica.dto.medico.MedicoResponseDTO;
import com.example.clinica.entity.Medico;
import com.example.clinica.entity.TelefoneMedico;
import com.example.clinica.repository.MedicoRepository;

@Service
public class MedicoService {
	
	private final MedicoRepository repository;
	
	public MedicoService(MedicoRepository repository) {
		this.repository = repository;
	}
	
	public Medico salvar(MedicoRequestDTO dto)
	{
		Medico medico = new Medico();
		medico.setNomeMedico(dto.nome());
		medico.setEmailMedico(dto.email());
		medico.setCrm(dto.crm());
		
		List<TelefoneMedico> telefones = dto.telefones().stream()
				.map(t -> {
					TelefoneMedico tel = new TelefoneMedico();
					tel.setTelefoneMedico(t);
					tel.setMedico(medico);
					return tel; 
				}).toList();
		
		medico.setTelefones(telefones);
		return repository.save(medico);
	}
	
	public List<MedicoResponseDTO> retornar(){
		return repository.findAll().stream()
				.map(MedicoResponseDTO::new).toList();
	}
}
