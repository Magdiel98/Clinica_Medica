package com.example.clinica.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "medico")
public class Medico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMedico;
	
	private String nomeMedico;
	private String emailMedico;
	private String crm; 
	
	@OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TelefoneMedico> telefones;

	public Medico(Long idMedico, String nomeMedico, String emailMedico, String crm, List<TelefoneMedico> telefones) {
		this.idMedico = idMedico;
		this.nomeMedico = nomeMedico;
		this.emailMedico = emailMedico;
		this.crm = crm;
		this.telefones = telefones;
	}

	public Medico() {
	}

	public Long getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(Long idMedico) {
		this.idMedico = idMedico;
	}

	public String getNomeMedico() {
		return nomeMedico;
	}

	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}

	public String getEmailMedico() {
		return emailMedico;
	}

	public void setEmailMedico(String emailMedico) {
		this.emailMedico = emailMedico;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public List<TelefoneMedico> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneMedico> telefones) {
		this.telefones = telefones;
	}
	
	
	
}
