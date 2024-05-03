package br.com.mysave.mysave.save.application.usecases;

import br.com.mysave.mysave.save.application.domain.Save;
import br.com.mysave.mysave.shared.ResponseServer;
import lombok.*;

public interface AtualizarSaveUC {
    ResponseServer<Save> atualizarSave(Request request);
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    class Request{
        private String Name;
    }
}
