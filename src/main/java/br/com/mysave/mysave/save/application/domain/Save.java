package br.com.mysave.mysave.save.application.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Save {
    byte[] arquivo;
    String usuarioNome;
    LocalDate dataCriacao;
    String nomeJogo;
    String emulador;
}
