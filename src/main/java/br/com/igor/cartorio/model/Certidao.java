package br.com.igor.cartorio.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "certidoes")
public class Certidao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@ManyToMany(mappedBy = "certidoes")
	private Set<Cartorio> cartorios = new HashSet<>();

	public Certidao() {
		
	}
	
	public Certidao(String nome) {
		super();
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Cartorio> getCartorios() {
		return cartorios;
	}

	public void setCartorios(Set<Cartorio> cartorios) {
		this.cartorios = cartorios;
	}	
}
