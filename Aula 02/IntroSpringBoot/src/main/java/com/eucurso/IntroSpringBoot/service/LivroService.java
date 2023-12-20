package com.eucurso.IntroSpringBoot.service;

import com.eucurso.IntroSpringBoot.model.Livro;
import com.eucurso.IntroSpringBoot.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;


    public List<Livro> buscaLivroPorAutor(String autor){
        return this.livroRepository.findByAutor(autor);
    }
}
