package com.senaiflix.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "filmes")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(nullable = false)
    private String diretor;

    @Column(nullable = false)
    private String genero;

    @Column(name = "pais_origem")
    private String paisOrigem;

    @Column(name = "ano_lancamento", nullable = false)
    private Integer anoLancamento;

    @Column(name = "duracao_minutos", nullable = false)
    private Integer duracaominutos;

    @Column(name = "nota_avaliacao", precision = 3, scale = 1)
    private BigDecimal notaAvaliacao;
}
