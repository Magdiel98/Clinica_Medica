package com.example.clinica.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "telefone_medico")
public class TelefoneMedico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTelefoneMedico;
	
	private String telefoneMedico;
	
	@ManyToOne
	@JoinColumn(name = "medico_id")
	private Medico medico;

	public TelefoneMedico(Long idTelefoneMedico, String telefoneMedico, Medico medico) {
		this.idTelefoneMedico = idTelefoneMedico;
		this.telefoneMedico = telefoneMedico;
		this.medico = medico;
	}

	public TelefoneMedico() {
		
	}

	public Long getIdTelefoneMedico() {
		return idTelefoneMedico;
	}

	public void setIdTelefoneMedico(Long idTelefoneMedico) {
		this.idTelefoneMedico = idTelefoneMedico;
	}

	public String getTelefoneMedico() {
		return telefoneMedico;
	}

	public void setTelefoneMedico(String telefoneMedico) {
		this.telefoneMedico = telefoneMedico;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	} 
	
	
	
}
