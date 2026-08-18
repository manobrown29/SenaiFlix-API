package com.senaiflix.controller;

import com.senaiflix.model.Filme;
import com.senaiflix.repository.FilmeRepository;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping
    public Page<Filme> listar(
            @RequestParam(required = false) String genero,
            @PageableDefault(size = 10, sort = "titulo")
            @ParameterObject Pageable pageable){

        if(genero != null && !genero.isBlank()){
           return filmeRepository.findByGeneroContainingIgnoreCase(genero, pageable);
        }

        return filmeRepository.findAll(pageable);
    }
}
