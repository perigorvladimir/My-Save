package br.com.mysave.mysave.save.application.repositories;

import br.com.mysave.mysave.save.database.entities.SaveEntity;

import java.util.List;

public interface SaveRepository {
    List<SaveEntity> findAllSaves();
}
