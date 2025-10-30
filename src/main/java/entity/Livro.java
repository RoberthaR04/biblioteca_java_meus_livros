package com.biblioteca.meuslivros.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    private String genero;

    @Lob // Large Object, para textos mais longos
    @Column(length = 2000)
    private String notas;

    @Column(nullable = false)
    private String urlImagem; // URL da capa do livro

    // Construtor padrão (necessário para JPA)
    public Livro() {
    }

    // Construtor para facilitar a criação de dados
    public Livro(String titulo, String autor, String genero, String notas, String urlImagem) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.notas = notas;
        this.urlImagem = urlImagem;
    }

    // Getters e Setters
    // (Omitidos por brevidade, mas você deve gerá-los na sua IDE)

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public String getNotas() { return notas; }
    public void setNotas(String notas) { this.notas = notas; }
    public String getUrlImagem() { return urlImagem; }
    public void setUrlImagem(String urlImagem) { this.urlImagem = urlImagem; }
}
