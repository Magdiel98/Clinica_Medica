package com.example.clinica.dto.consulta;

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.clinica.enums.StatusConsulta;

import jakarta.validation.constraints.FutureOrPresent;

public record ConsultaUpdateDTO(
		@FutureOrPresent(message = "A data não pode ser no passado")
		LocalDate data,
		
		@FutureOrPresent(message = "A data não pode ser no passado")
		LocalTime hora, 
		
		StatusConsulta status,
		Long medicoId,
		Long pacienteId
		) {}
