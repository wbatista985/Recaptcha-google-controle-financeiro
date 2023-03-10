package br.com.controle.financeiro.api.controller;

import br.com.controle.financeiro.api.model.Categoria;
import br.com.controle.financeiro.api.service.CategoriaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@EnableSwagger2
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/salvar")
    public Categoria salvarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.salvarCategoria(categoria);
    }

    @ApiOperation(value = "Retorna uma lista de categorias")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de categoria"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar a lista de categoria"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping(value = "/listar-categorias", produces = "application/json")
    public List<Categoria> listarCategorias() {
        return categoriaService.findAll();
    }

}
