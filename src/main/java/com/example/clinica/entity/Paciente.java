package com.example.clinica.entity;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="paciente")
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPaciente;
	
	private String nomePaciente;
	private String emailPaciente;
	private String cpf;
	
	@Column(nullable = false)
	private boolean ativo = true;
	
	@OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TelefonePaciente> telefones;

	public Paciente(Long idPaciente, String nomePaciente, String emailPaciente, String cpf,
			List<TelefonePaciente> telefones) {
		this.idPaciente = idPaciente;
		this.nomePaciente = nomePaciente;
		this.emailPaciente = emailPaciente;
		this.cpf = cpf;
		this.telefones = telefones;
	}

	public Paciente() {
	}

	public Long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getEmailPaciente() {
		return emailPaciente;
	}

	public void setEmailPaciente(String emailPaciente) {
		this.emailPaciente = emailPaciente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<TelefonePaciente> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefonePaciente> telefones) {
		this.telefones = telefones;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public void ativar() {
		this.setAtivo(true);
	}
	
}
