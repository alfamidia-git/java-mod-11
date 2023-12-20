package com.eucurso.IntroSpringBoot.repository;

import com.eucurso.IntroSpringBoot.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

    List<Livro> findByAutor(String autor);

    List<Livro> findByTitulo(String titulo);
}
