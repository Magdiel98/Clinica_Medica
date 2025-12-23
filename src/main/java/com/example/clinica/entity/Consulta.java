package com.example.clinica.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import com.example.clinica.enums.StatusConsulta;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "consulta")
public class Consulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConsulta; 
	
	private LocalDate dataConsulta; 
	private LocalTime horaConsulta;
	
	@Enumerated(EnumType.STRING)
	private StatusConsulta statusConsulta;
	
	@ManyToOne
	@JoinColumn(name="paciente_id")
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name = "medico_id")
	private Medico medico;

	public Consulta(Long idConsulta, LocalDate dataConsulta, LocalTime horaConsulta, StatusConsulta statusConsulta,
			Paciente paciente, Medico medico) {
		this.idConsulta = idConsulta;
		this.dataConsulta = dataConsulta;
		this.horaConsulta = horaConsulta;
		this.statusConsulta = statusConsulta;
		this.paciente = paciente;
		this.medico = medico;
	}

	public Consulta() {
		
	}

	public Long getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(Long idConsulta) {
		this.idConsulta = idConsulta;
	}

	public LocalDate getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public LocalTime getHoraConsulta() {
		return horaConsulta;
	}

	public void setHoraConsulta(LocalTime horaConsulta) {
		this.horaConsulta = horaConsulta;
	}

	public StatusConsulta getStatusConsulta() {
		return statusConsulta;
	}

	public void setStatusConsulta(StatusConsulta statusConsulta) {
		this.statusConsulta = statusConsulta;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	} 
	
	
	
	
}
