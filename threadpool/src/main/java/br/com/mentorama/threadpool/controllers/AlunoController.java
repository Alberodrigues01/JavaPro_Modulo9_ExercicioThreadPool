package br.com.mentorama.threadpool.controllers;

import br.com.mentorama.threadpool.exceptions.RegistroInexistenteException;
import br.com.mentorama.threadpool.models.Aluno;
import br.com.mentorama.threadpool.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RequestMapping("/aluno")
@RestController
@Async
public class AlunoController {

    @Autowired
    private final AlunoService alunoService;

   public AlunoController(AlunoService alunoService){
        this.alunoService = alunoService;
    }

    @GetMapping
    public CompletableFuture<List<Aluno>> findAll(){
        System.out.println("Controller Thread: " + Thread.currentThread().getName());
        return this.alunoService.findAll();
    }

    @GetMapping("/{id}")
    public CompletableFuture<Aluno> findById(@PathVariable ("id") Long id) {
        System.out.println("Controller Thread: " + Thread.currentThread().getName());
            return this.alunoService.findById(id).thenApply(aluno -> aluno
                    .orElseThrow(RegistroInexistenteException::new));
    }

    @PostMapping
    public CompletableFuture<Aluno> save(@RequestBody Aluno aluno){
        System.out.println("Controller Thread: " + Thread.currentThread().getName());
        return this.alunoService.save(aluno);
    }

    @PutMapping
    public CompletableFuture<Aluno> update(@RequestBody Aluno aluno) {
        System.out.println("Controller Thread: " + Thread.currentThread().getName());
        return this.alunoService.save(aluno);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<Aluno> delete(@PathVariable ("id") Long id) {
        System.out.println("Controller Thread: " + Thread.currentThread().getName());
        return this.alunoService.delete(id);
    }

    @ExceptionHandler({RegistroInexistenteException.class})
    public ResponseEntity <String> handle(final RegistroInexistenteException e){
       return new ResponseEntity<> ("Id Aluno Não Encontrado", HttpStatus.NOT_FOUND);
    }
}
