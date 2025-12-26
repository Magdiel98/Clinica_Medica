package com.example.clinica.dto.paciente;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record PacienteUpdateDTO(String nome,

		@Email(message = "Email inválido") String email,

		@Pattern(regexp = "\\d{3}.\\d{3}.\\d{3}-\\d{2}") String cpf,

		List<@Pattern(regexp = "\\(\\d{2}\\)\\d{4,5}-\\d{4}", message = "Telefone inválido. Use (XX)XXXXX-XXXX") String> telefones) {

}
