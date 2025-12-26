package com.example.clinica.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.clinica.dto.medico.MedicoRequestDTO;
import com.example.clinica.dto.medico.MedicoResponseDTO;
import com.example.clinica.dto.medico.MedicoUpdateDTO;
import com.example.clinica.entity.Medico;
import com.example.clinica.entity.TelefoneMedico;
import com.example.clinica.repository.MedicoRepository;

import jakarta.persistence.EntityNotFoundException;


/*
 * Use o Transactional quando for:
 * Gravar Dados;
 * Alterar Dados;
 * Remover Dados.
 * */

@Service
public class MedicoService {

    
	
	private final MedicoRepository repository;
	
	public MedicoService(MedicoRepository repository) {
		this.repository = repository;

	}
	
	
	@Transactional
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
		repository.save(medico);
		return medico;
	}
	
	public List<MedicoResponseDTO> retornar(){
		return repository.findAllByAtivoTrue().stream()
				.map(MedicoResponseDTO::new).toList();
	}
	
	public Medico detalhado(Long id) {
		return repository.getReferenceById(id);
	}
	
	@Transactional
	public void reativar(Long id){
		var medico = repository.getReferenceById(id);
		medico.ativar();
	}
	
	
	@Transactional
	public Medico modificar(Long id, MedicoUpdateDTO dto) {
		Medico medico = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Médico não encontrado"));

		
		if(dto.nome() != null){
			medico.setNomeMedico(dto.nome());
		}
		
		if(dto.email() != null) {
			medico.setEmailMedico(dto.email());
		}
		
		if(dto.crm() != null) {
			medico.setCrm(dto.crm());
		}
		
		if(dto.telefones() != null) {
			medico.getTelefones().clear();
			
			List<TelefoneMedico> novosTelefones = dto.telefones().stream()
					.map(t -> {
						TelefoneMedico tel = new TelefoneMedico();
						tel.setTelefoneMedico(t);
						tel.setMedico(medico);
						return tel;
					})
					.toList();
			medico.getTelefones().addAll(novosTelefones);
		}
		
		return medico; 
	}
	
	
	@Transactional
	public void cancelar(Long id) {
		Medico medico = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException());
		
		medico.setAtivo(false);
	}
}
