package br.com.mysave.mysave.exception.handler;
import br.com.mysave.mysave.shared.ResponseError;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    public final ResponseEntity<ResponseError> handleAllExceptions(Exception ex, WebRequest request){
        System.out.println("entrou aqui?");
        ResponseError exceptionResponse = ResponseError.builder()
                .mensagem(ex.getMessage())
                .dataHora(LocalDateTime.now())
                .detalhes(request.getDescription(true))
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
