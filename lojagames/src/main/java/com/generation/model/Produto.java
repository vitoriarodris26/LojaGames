package com.generation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@Entity
@Table (name = "tb_produto")


public class Produto {

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	

	@NotBlank (message = "O título é obrigatório, não pode estar em branco")
	@Size (min = 5, max=100, message="O título deve ter no mínimo 5 caracteres e no máximo 100")
	private String titulo;
	
	
	@NotBlank (message = "É obrigatório o uso de fotos")
	@Size (min = 5, max=1000)
	private String foto;
	
	@NotNull (message = "O preço não pode ser nulo")
	private Double preco;
	
	@NotBlank (message = "É obrigatório um texto sobre o produto")
	@Size (min = 5, max=1000)
	private String texto;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

	
	
	
	/**************GETTERS & SETTERS***************/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	

	
	
	
}

	
	
