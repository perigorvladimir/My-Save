package br.com.mysave.mysave.shared;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.annotations.NotFound;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@Setter
public class ResponseServer<T>{
    private Integer statusCode;
    protected String mensagem;
    protected String mensagemDesenvolvedor;
    private T data;
}
