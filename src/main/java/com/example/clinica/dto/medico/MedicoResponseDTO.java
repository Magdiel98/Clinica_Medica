package com.example.clinica.dto.medico;

import java.util.List;

public record MedicoResponseDTO(
		Long id,
		String nome,
		String email, 
		String crm, 
		List<String> telefones
	) {

}
