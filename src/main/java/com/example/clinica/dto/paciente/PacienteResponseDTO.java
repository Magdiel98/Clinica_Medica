package com.example.clinica.dto.paciente;

import java.util.List;

import com.example.clinica.entity.Paciente;

public record PacienteResponseDTO(
		Long id, 
		String nome, 
		String email,
		String cpf, 
		List<String> telefones
	) {
	
	public PacienteResponseDTO(Paciente paciente) {
		this(paciente.getIdPaciente(), 
			paciente.getNomePaciente(), 
			paciente.getEmailPaciente(),
			paciente.getCpf(), 
			paciente.getTelefones().stream()
			.map(t -> t.getTelefonePaciente())
			.toList());
	}
	
}
