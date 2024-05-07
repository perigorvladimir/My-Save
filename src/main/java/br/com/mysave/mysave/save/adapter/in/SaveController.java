package br.com.mysave.mysave.save.adapter.in;

import br.com.mysave.mysave.save.application.usecases.AtualizarSaveUC;
import br.com.mysave.mysave.save.application.usecases.SalvarSaveUC;
import br.com.mysave.mysave.save.application.usecases.SaveUC;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    @GetMapping()
    public ResponseEntity<?> findSaves(){
        var response = saveUC.findSaves();
        return ResponseEntity.status(response.getStatusCode()).body(response);
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
