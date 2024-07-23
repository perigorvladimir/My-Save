package br.com.mysave.mysave.exception.handler;
import br.com.mysave.mysave.shared.ResponseError;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    public final ResponseEntity<ResponseError> handleAllExceptions(Exception ex, WebRequest request){
        ResponseError exceptionResponse = ResponseError.builder()
                .erro(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .mensagem(ex.getMessage())
                .dataHora(LocalDateTime.now())
                .detalhes(request.getDescription(true))
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity<ResponseError> handleEntityNotFound(Exception ex, WebRequest request){
        return new ResponseEntity<>(ResponseError.builder()
                .erro(HttpStatus.NOT_FOUND.getReasonPhrase())
                .mensagem(ex.getMessage())
                .dataHora(LocalDateTime.now())
                .detalhes(request.getDescription(false))
                .build(), HttpStatus.NOT_FOUND);
    }
}
