package com.example.clinica.dto.medico;

import java.util.List;

public record MedicoRequestDTO(
		String nome,
		String email, 
		String crm, 
		List<String> telefones) {
	
}
