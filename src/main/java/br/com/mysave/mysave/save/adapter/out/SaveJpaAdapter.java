package br.com.mysave.mysave.save.adapter.out;

import br.com.mysave.mysave.save.application.repositories.SaveRepository;
import br.com.mysave.mysave.save.database.entities.SaveEntity;
import br.com.mysave.mysave.save.database.repositories.SaveJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;

import java.sql.SQLException;
import java.util.List;

@Component
@AllArgsConstructor
public class SaveJpaAdapter implements SaveRepository {
    private final SaveJpaRepository saveJpaRepository;
    @Override
    public List<SaveEntity> findAllSaves() throws Exception{
        try{
            return saveJpaRepository.findAll();
        } catch (SQLException sqlException) {
            throw new SQLException("Erro de SQL");
        } catch (HttpServerErrorException esee){
            throw new HttpServerErrorException("Erro ao se comunicar com banco de dados");
        } catch (Exception e){

        }
    }
}
