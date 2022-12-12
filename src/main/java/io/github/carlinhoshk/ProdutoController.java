package io.github.carlinhoshk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService service;
    @GetMapping("/produtos")
    public List<Produto> list(){
        return service.listAll();
    }
}
