package com.example.clinica.dto.paciente;

import java.util.List;

public record PacienteRequestDTO(
		String nome,
		String email,
		String cpf, 
		List<String> telefones
		) {	
}
