package com.biblioteca.meuslivros.repository;

import com.biblioteca.meuslivros.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    // Spring Data JPA cria magicamente os métodos CRUD (findAll, findById, save, deleteById)
}