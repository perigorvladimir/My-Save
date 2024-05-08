package br.com.mysave.mysave.save.database.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(schema = "my_save", name = "save")
@SequenceGenerator(schema = "my_save", name = "seq_save", sequenceName = "seq_save", allocationSize = 1)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_save")
    private Integer id;
    private byte[] arquivo;
    private String usuarioNome;
    private LocalDate dataCriacao;
    private String nomeJogo;
    private String emulador;

}
