package br.com.mysave.mysave.save.application.service;

import br.com.mysave.mysave.save.application.domain.Save;
import br.com.mysave.mysave.save.application.repositories.SaveRepository;
import br.com.mysave.mysave.save.application.usecases.AtualizarSaveUC;
import br.com.mysave.mysave.save.application.usecases.SalvarSaveUC;
import br.com.mysave.mysave.save.application.usecases.SaveUC;
import br.com.mysave.mysave.save.database.entities.SaveEntity;
import br.com.mysave.mysave.shared.ResponseServer;
import br.com.mysave.mysave.util.CustomGenericMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SaveService implements SaveUC {
    private final SaveRepository saveRepository;
    private final CustomGenericMapper mapper;
    @Override
    public ResponseServer<Save> findSaveById(Integer id) {
        try{
            Save save = saveRepository.findSaveById(id)
                            .map((saveEntity) -> mapper.map(saveEntity, Save.class))
                            .orElseThrow( () -> new EntityNotFoundException("Não existe Save com o id informado"));

            return ResponseServer.<Save>builder()
                    .statusCode(200)
                    .data(LocalDateTime.now())
                    .dado(save)
                    .mensagem("Sucesso ao buscar Saves!")
                    .mensagemDesenvolvedor("Sucesso ao buscar Saves!")
                    .build();
        } catch (EntityNotFoundException entityNotFoundException) {
            return ResponseServer.<Save>builder()
                    .statusCode(404)
                    .mensagem(entityNotFoundException.getMessage())
                    .data(LocalDateTime.now())
                    .build();
        }
        catch (Exception e){
            return ResponseServer.<Save>builder()
                    .statusCode(500)
                    .mensagem("Erro interno ao tentar buscar save. Por favor tente novamente.")
                    .mensagemDesenvolvedor(e.getMessage())
                    .data(LocalDateTime.now())
                    .build();
        }
    }
    @Override
    public ResponseServer<List<Save>> findSaves() {
        try{
            List<SaveEntity> saveEntities = saveRepository.findAllSaves();
            List<Save> saves = saveEntities.stream().map(saveEntity -> mapper.map(saveEntity, Save.class)).collect(Collectors.toList());
            return ResponseServer.<List<Save>>builder()
                    .statusCode(200)
                    .data(LocalDateTime.now())
                    .dado(saves)
                    .mensagem("Sucesso ao buscar Saves!")
                    .mensagemDesenvolvedor("Sucesso ao buscar Saves!")
                    .build();
        } catch (Exception e){
            return ResponseServer.<List<Save>>builder()
                    .statusCode(500)
                    .mensagem("Erro interno ao tentar buscar saves. Por favor tente novamente.")
                    .mensagemDesenvolvedor(e.getMessage())
                    .build();
        }
    }
    @Override
    @Transactional
    public ResponseServer<Save> salvarSave(SalvarSaveUC.Request request) {
        return null;
    }
    @Override
    @Transactional
    public ResponseServer<Save> atualizarSave(AtualizarSaveUC.Request request) {
        return null;
    }
    @Override
    @Transactional
    public ResponseServer<Boolean> deletarSave(Integer id) {
        return null;
    }

}
