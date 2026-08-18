package com.senaiflix.Config;

import org.springframework.data.core.PropertyReferenceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PropertyReferenceException.class)
    public ResponseEntity<Map<String, Object>> handlePropertyReferenceException(PropertyReferenceException ex){
        Map<String, Object> body = Map.of(
                "erro", "Campo de ordenação invalído",
                "mensagem", "Campos valídos: id, titulo, diretor, anoLancamento, genero e duração"
        );

        return ResponseEntity.badRequest().body(body);
    }
}
