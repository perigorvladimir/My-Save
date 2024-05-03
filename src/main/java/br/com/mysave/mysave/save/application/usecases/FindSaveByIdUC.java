package br.com.mysave.mysave.save.application.usecases;

import br.com.mysave.mysave.save.application.domain.Save;
import br.com.mysave.mysave.shared.ResponseServer;

public interface FindSaveByIdUC {
    ResponseServer<Save> findSaveById(Integer Id);

}
