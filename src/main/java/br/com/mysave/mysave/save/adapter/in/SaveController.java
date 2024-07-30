package br.com.mysave.mysave.save.adapter.in;

import br.com.mysave.mysave.save.application.usecases.AtualizarSaveUC;
import br.com.mysave.mysave.save.application.usecases.SalvarSaveUC;
import br.com.mysave.mysave.save.application.usecases.SaveUC;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@AllArgsConstructor
@RestController
@RequestMapping("/save")
public class SaveController {
    private final SaveUC saveUC;

    @GetMapping("/{saveId}")
    public ResponseEntity<?> findSaveById(@PathVariable Integer saveId){
        if(saveId<0){
            throw new IllegalArgumentException("Valor de input do id é inválido.");
        }
        var response = saveUC.findSaveById(saveId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("")
    public ResponseEntity<?> findSaves(){
        var response = saveUC.findSaves();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PostMapping("")
    public ResponseEntity<?> salvarSave(@RequestBody SalvarSaveUC.Request request){
        return ResponseEntity.ok("");
    }
    @PutMapping("")
    public ResponseEntity<?> atualizarSave(@RequestBody AtualizarSaveUC.Request request){
        return ResponseEntity.ok("");
    }
    @DeleteMapping("/{saveId}")
    public ResponseEntity<?> deletarSave(@PathVariable Integer saveId){
        saveUC.deletarSave(saveId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
