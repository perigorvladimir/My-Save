package br.com.mysave.mysave.save.application.usecases;

import br.com.mysave.mysave.shared.ResponseServer;

public interface DeletarSaveUC {
    ResponseServer<Boolean> deletarSave(Integer id);
}
