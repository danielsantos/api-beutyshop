package com.danielrocha.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.danielrocha.model.enumeration.TipoSituacao;

@Entity
public class Horario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length=1)
	private TipoSituacao situacao = TipoSituacao.A;	
	
	@OneToOne
	@JoinColumn(name="idCliente")
	private Cliente cliente;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "horarioservico", joinColumns = { 
                               @JoinColumn(name = "horario", nullable = false, updatable = false) }, 
		inverseJoinColumns = { @JoinColumn(name = "servico", nullable = false, updatable = false)})
	private List<Servico> servicos;

	@Transient
	private Long idCliente;
	
	@Transient
	private List<ServicoDTO> servs;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoSituacao getSituacao() {
		return situacao;
	}

	public void setSituacao(TipoSituacao situacao) {
		this.situacao = situacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public List<ServicoDTO> getServs() {
		return servs;
	}

	public void setServs(List<ServicoDTO> servs) {
		this.servs = servs;
	}
	
}
