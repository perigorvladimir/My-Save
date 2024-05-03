package br.com.mysave.mysave.save.adapter.in;

import br.com.mysave.mysave.save.application.usecases.AtualizarSaveUC;
import br.com.mysave.mysave.save.application.usecases.SalvarSaveUC;
import br.com.mysave.mysave.save.application.usecases.SaveUC;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@AllArgsConstructor
@RestController
@RequestMapping("/save")
public class SaveController {
    private final SaveUC saveUC;

    @GetMapping("/{saveId}")
    public ResponseEntity<?> findSave(@PathVariable Integer saveId){
        return ResponseEntity.ok(saveId);
    }
    @PostMapping()
    public ResponseEntity<?> salvarSave(@RequestBody SalvarSaveUC.Request request){
        return ResponseEntity.ok("");
    }
    @PutMapping()
    public ResponseEntity<?> atualizarSave(@RequestBody AtualizarSaveUC.Request request){
        return ResponseEntity.ok("");
    }
    @DeleteMapping("/{saveId}")
    public ResponseEntity<?> deletarSave(@PathVariable Integer saveId){
        return ResponseEntity.ok("");
    }
}
