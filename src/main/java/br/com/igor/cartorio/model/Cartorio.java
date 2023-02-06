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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "cartorios")
public class Cartorio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	public String nome;
	
	@Column(name = "endereco", nullable = false)
	public String endereco;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "cartorio_certidao",
			joinColumns = @JoinColumn(name = "cartorio_id"),
			inverseJoinColumns = @JoinColumn(name = "certidao_id"))
    private Set<Certidao> certidoes = new HashSet<>();
	

	public Cartorio() {
		
	}

	public Cartorio(String nome, String endereco) {
		super();
		this.nome = nome;
		this.endereco = endereco;
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



	public String getEndereco() {
		return endereco;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}



	public Set<Certidao> getCertidoes() {
		return certidoes;
	}



	public void setCertidoes(Set<Certidao> certidoes) {
		this.certidoes = certidoes;
	}
}
