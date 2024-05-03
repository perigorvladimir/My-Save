package br.com.mysave.mysave.save.database.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(schema = "my_save", name = "save")
@Data
public class SaveEntity {
    @Id
    private Integer id;
    private Byte[] arquivo;
    private String usuarioNome;
    private LocalDate dataCriacao;
    private String nomeJogo;
    private String emulador;
}
