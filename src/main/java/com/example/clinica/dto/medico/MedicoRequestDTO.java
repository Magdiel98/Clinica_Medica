package com.example.clinica.dto.medico;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public record MedicoRequestDTO(
		@NotBlank(message = "O nome é obrigatório")
		String nome,
		
		@NotBlank(message = "O email é obrigatório")
		@Email(message = "Email inválido")
		String email, 
		
		@NotBlank(message = "O CRM é obrigatório")
		@Pattern(
				regexp = "(?i)^CRM/[A-Z]{2} \\d{6}$",
				message = "CRM inválido. Use o formato: CRM/UF 123456")
		String crm, 
		
		@NotEmpty(message = "Informe ao menos um telefone")
		List<
		@Pattern(regexp = "\\(\\d{2}\\)\\d{4,5}-\\d{4}",
		message = "Telefone inválido. Use (XX)XXXXX-XXXX")
		String> telefones) {
	
}
