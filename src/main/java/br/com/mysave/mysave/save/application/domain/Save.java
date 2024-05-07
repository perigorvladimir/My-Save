package br.com.mysave.mysave.save.application.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Save {
    byte[] arquivo;
    String usuarioNome;
    LocalDate dataCriacao;
    String nomeJogo;
    String emulador;
}
