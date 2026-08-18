package com.senaiflix.controller;

import com.senaiflix.model.Serie;
import com.senaiflix.repository.SerieRepository;
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
@RequestMapping("api/series")
public class SerieController {

    @Autowired
    private SerieRepository serieRepository;

    @GetMapping
    public Page<Serie> listar(
            @RequestParam(required = false) String plataforma,
            @PageableDefault(size = 10, sort = "titulo")
            @ParameterObject Pageable pageable){

        if (plataforma != null &&!plataforma.isBlank()){
            return serieRepository.findByPlataformaContainingIgnoreCase(plataforma, pageable);
        }

        return serieRepository.findAll(pageable);
    }
}
