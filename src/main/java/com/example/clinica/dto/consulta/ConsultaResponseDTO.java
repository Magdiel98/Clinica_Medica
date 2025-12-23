package com.example.clinica.dto.consulta;

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.clinica.enums.StatusConsulta;

public record ConsultaResponseDTO(
		Long id, 
		LocalDate data,
		LocalTime hora,
		StatusConsulta status,
		String nomePaciente,
		String nomeMedico
		) {

}
