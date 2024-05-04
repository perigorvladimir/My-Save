package br.com.mysave.mysave.save.adapter.out;

import br.com.mysave.mysave.save.application.repositories.SaveRepository;
import br.com.mysave.mysave.save.database.entities.SaveEntity;
import br.com.mysave.mysave.save.database.repositories.SaveJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class SaveJpaAdapter implements SaveRepository {
    private final SaveJpaRepository saveJpaRepository;
    @Override
    public List<SaveEntity> findAllSaves() {
        return saveJpaRepository.findAll();
    }
}
