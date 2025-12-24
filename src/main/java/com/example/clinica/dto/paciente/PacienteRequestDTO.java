package com.example.clinica.dto.paciente;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public record PacienteRequestDTO(
		@NotBlank(message = "O nome é obrigatório")
		String nome,
		
		@NotBlank(message="O email é obrigatório")
		@Email(message = "Email inválido")
		String email,
		
		@NotBlank(message="Cpf obrigatório")
		@Pattern(regexp="\\d{3}.\\d{3}.\\d{3}-\\d{2}")
		String cpf, 
		
		@NotEmpty(message = "Informe ao menos um telefone")
		List<@Pattern(regexp = "\\(\\d{2}\\)\\d{4,5}-\\d{4}",
				message = "Telefone inválido. Use (XX)XXXXX-XXXX")String> telefones
		) {	
}
