package com.example.clinica.dto.consulta;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

public record ConsultaRequestDTO(
		@NotNull(message = "A data obrigatória")
		@FutureOrPresent(message = "A data não pode ser no passado")
		LocalDate data,
		
		@FutureOrPresent(message = "O horário não pode ser no passado")
		@NotNull(message = "O horário é obrigatório")
		LocalTime hora,
		
		@NotNull(message = "Paciente é obrigatório")
		Long pacienteId,
		
		@NotNull(message = "Médico é obrigatório")
		Long medicoId
		) {
	
}
