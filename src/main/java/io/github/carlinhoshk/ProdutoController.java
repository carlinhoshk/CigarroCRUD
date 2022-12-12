package io.github.carlinhoshk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService service;
    @GetMapping("/produtos")
    public List<Produto> list(){
        return service.listAll();
    }
    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produto> get(@PathVariable Integer id){
        try {
            Produto produto = service.get(id);
            return new ResponseEntity<Produto>(produto, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Produto>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/produtos")
    public void add(@RequestBody Produto produto){
        service.save(produto);
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<?> update(@RequestBody Produto produto,
        @PathVariable Integer id){
        try {
            Produto existProduto = service.get(id);
            service.save(produto);

            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/produtos/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}
