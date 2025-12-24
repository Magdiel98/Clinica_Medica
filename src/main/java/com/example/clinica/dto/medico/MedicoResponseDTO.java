package com.example.clinica.dto.medico;

import java.util.List;

import com.example.clinica.entity.Medico;

public record MedicoResponseDTO(
		Long id,
		String nome,
		String email, 
		String crm, 
		List<String> telefones
	) {
	
	public MedicoResponseDTO(Medico medico) {
		this(medico.getIdMedico(),
			 medico.getNomeMedico(),
			 medico.getEmailMedico(),
			 medico.getCrm(),
			 medico.getTelefones().stream()
			 .map(t -> t.getTelefoneMedico())
			 .toList());
	}
}
