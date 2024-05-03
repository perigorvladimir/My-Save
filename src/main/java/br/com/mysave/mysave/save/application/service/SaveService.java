package br.com.mysave.mysave.save.application.service;

import br.com.mysave.mysave.save.application.domain.Save;
import br.com.mysave.mysave.save.application.usecases.AtualizarSaveUC;
import br.com.mysave.mysave.save.application.usecases.SalvarSaveUC;
import br.com.mysave.mysave.save.application.usecases.SaveUC;
import br.com.mysave.mysave.shared.ResponseServer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaveService implements SaveUC {
    @Override
    public ResponseServer<Save> findSaveById(Integer Id) {
        return null;
    }
    @Override
    public ResponseServer<List<Save>> findSaves() {
        return null;
    }
    @Override
    public ResponseServer<Save> salvarSave(SalvarSaveUC.Request request) {
        return null;
    }
    @Override
    public ResponseServer<Save> atualizarSave(AtualizarSaveUC.Request request) {
        return null;
    }
    @Override
    public ResponseServer<Boolean> deletarSave(Integer id) {
        return null;
    }

}
