package br.com.mysave.mysave.save.application.usecases;

import br.com.mysave.mysave.shared.ResponseServer;

public interface DeletarSaveUC {
    ResponseServer<Void> deletarSave(Integer id);
}
