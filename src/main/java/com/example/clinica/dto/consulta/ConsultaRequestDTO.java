package com.example.clinica.dto.consulta;

import java.time.LocalDate;
import java.time.LocalTime;

public record ConsultaRequestDTO(
		LocalDate data,
		LocalTime hora,
		Long pacienteId,
		Long medicoId
		) {
	
}
