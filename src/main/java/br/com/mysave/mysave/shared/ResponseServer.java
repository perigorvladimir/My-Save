package br.com.mysave.mysave.shared;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.annotations.NotFound;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@Setter
public class ResponseServer<T>{
    private T dado;
    private Integer statusCode;
    private String mensagem;
    private String mensagemDesenvolvedor;
    private LocalDate data;
}
