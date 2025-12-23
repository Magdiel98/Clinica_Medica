package com.example.clinica.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "telefone_paciente")
public class TelefonePaciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTelefonePaciente;
	
	private String telefonePaciente;
	
	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;

	public TelefonePaciente(Long idTelefonePaciente, String telefonePaciente, Paciente paciente) {
		this.idTelefonePaciente = idTelefonePaciente;
		this.telefonePaciente = telefonePaciente;
		this.paciente = paciente;
	}

	public TelefonePaciente() {
		
	}

	public Long getIdTelefonePaciente() {
		return idTelefonePaciente;
	}

	public void setIdTelefonePaciente(Long idTelefonePaciente) {
		this.idTelefonePaciente = idTelefonePaciente;
	}

	public String getTelefonePaciente() {
		return telefonePaciente;
	}

	public void setTelefonePaciente(String telefonePaciente) {
		this.telefonePaciente = telefonePaciente;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	
	
	
	
	
}
