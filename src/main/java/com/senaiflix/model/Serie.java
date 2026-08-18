package com.senaiflix.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "series")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(nullable = false)
    private String criador;

    @Column(name = "ano_lancamento", nullable = false)
    private Integer anoLancamento;

    @Column(nullable = false)
    private String Genero;

    private Integer temporadas;

    private Integer episodios;

    @Column(name = "nota_avaliacao", precision = 3, scale = 1)
    private BigDecimal notaAvaliacao;

    @Column(nullable = false)
    private String plataforma;
}
