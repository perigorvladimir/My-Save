package br.com.mysave.mysave.save.database.repositories;

import br.com.mysave.mysave.save.database.entities.SaveEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaveJpaRepository extends JpaRepository<SaveEntity, Integer> {
}
