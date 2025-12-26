package com.example.clinica.dto.medico;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record MedicoUpdateDTO(String nome,

		@Email(message = "Email inválido") String email,

		@Pattern(regexp = "(?i)^CRM/[A-Z]{2} \\d{6}$", message = "CRM inválido. Use o formato: CRM/UF 123456") String crm,

		List<@Pattern(regexp = "\\(\\d{2}\\)\\d{4,5}-\\d{4}", message = "Telefone inválido. Use (XX)XXXXX-XXXX") String> telefones) {

}
