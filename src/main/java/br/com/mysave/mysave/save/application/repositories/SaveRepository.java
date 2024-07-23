package br.com.mysave.mysave.save.application.repositories;

import br.com.mysave.mysave.save.database.entities.SaveEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface SaveRepository {
    List<SaveEntity> findAllSaves() throws Exception;
    Optional<SaveEntity> findSaveById(Integer id);
}
