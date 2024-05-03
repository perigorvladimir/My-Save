package br.com.mysave.mysave.save.application.usecases;

import br.com.mysave.mysave.save.application.domain.Save;
import br.com.mysave.mysave.shared.ResponseServer;

import java.util.List;

public interface FindSavesUC {
    ResponseServer<List<Save>> findSaves();
}
