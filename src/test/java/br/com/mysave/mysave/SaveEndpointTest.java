package br.com.mysave.mysave;

import br.com.mysave.mysave.save.adapter.in.SaveController;
import br.com.mysave.mysave.save.application.domain.Save;
import br.com.mysave.mysave.save.application.repositories.SaveRepository;
import br.com.mysave.mysave.save.database.entities.SaveEntity;
import br.com.mysave.mysave.shared.ResponseServer;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.el.parser.AstSetData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@RequiredArgsConstructor
public class SaveEndpointTest {
    @Autowired
    private SaveController saveController;
    @Autowired
    private SaveRepository saveRepository;
    @Test
    @Transactional
    public void testeDeveDeletarSaveById(){
        ResponseEntity<?> response = saveController.deletarSave(2);
        Assertions.assertEquals(204, response.getStatusCode().value(), "Status code diferente de 204.");

        Object responseBody = response.getBody();
        Assertions.assertNull(responseBody, "Response body deve ser nulo.");

        Optional<SaveEntity> saveDeletado= saveRepository.findSaveById(2);
        Assertions.assertTrue(saveDeletado.isEmpty());
    }
    @Test
    @Transactional
    public void testeDeletarSaveComIdNaoExistente(){
        // TESTE deletar save que não há no banco
        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            saveController.deletarSave(1);
        }, "Excessão diferente da esperada, esperada: EntityNotFound");

        // TESTE deletar save 2 vezes, segunda deve retornar excessão
        saveController.deletarSave(2);

        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            saveController.deletarSave(2);
        });
    }
    @Test
    public void testeDeveRetornarTodosOsSavesTeste() {
        ResponseEntity<?> response = saveController.findSaves();
        Assertions.assertEquals(200, response.getStatusCode().value(), "Status code diferente de 200.");

        Object responseBody = response.getBody();
        Assertions.assertNotNull(responseBody, "Response body nulo.");

        Assertions.assertInstanceOf(ResponseServer.class, responseBody, "Resposta diferente da classe de resposta do servidor.");
        ResponseServer responseServer = (ResponseServer) responseBody;

        Assertions.assertTrue(responseServer.getDado() instanceof List<?>, "Dado diferente do tipo List<>");
        List<?> saves = (List<?>) responseServer.getDado();

        Assertions.assertEquals(10, saves.size());
    }

    @Test
    public void testeDeveEncontrarSavePorId() {
        ResponseEntity<?> response =  saveController.findSaveById(2);
        Assertions.assertEquals(200, response.getStatusCode().value(), "Status code diferente de 200");

        Object responseBody = response.getBody();
        Assertions.assertNotNull(responseBody, "Response body nulo");

        Assertions.assertInstanceOf(ResponseServer.class, responseBody, "Resposta diferente da classe de resposta do servidor.");
        ResponseServer responseServer = (ResponseServer) responseBody;

        Assertions.assertTrue(responseServer.getDado() instanceof Save, "Dado diferente do tipo Save");
        Save save = (Save) responseServer.getDado();

        Assertions.assertEquals(save.getId(), 2);
    }

    @Test
    public void testeNaoDeveRetornarSave(){
        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            saveController.findSaveById(1);
        }, "Excessão diferente da esperada, esperada: EntityNotFound");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            saveController.findSaveById(-2);
        }, "Excessão diferente da esperada, esperada: IllegalArgumentException");
    }
}
