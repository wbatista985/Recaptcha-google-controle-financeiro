package br.com.controle.financeiro.api.controller;

import br.com.controle.financeiro.api.model.Movimentacao;
import br.com.controle.financeiro.api.service.MovimentacaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@RequestMapping("/movimentacao")
@EnableSwagger2
public class MovimentacaoController {

    private final MovimentacaoService movimentacaoService;

    @Autowired
    public MovimentacaoController(MovimentacaoService movimentacaoService) {
        this.movimentacaoService = movimentacaoService;
    }

    @PostMapping("/salvar")
    public Movimentacao salvarMovimentacao(@RequestBody Movimentacao movimentacao) {
        return movimentacaoService.salvarMovimentacao(movimentacao);
    }

    @ApiOperation(value = "Retorna uma lista de movimentações")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de movimentações"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar a lista de movimentações"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })

    @GetMapping(value = "/listar-movimentacoes", produces = "application/json")
    public List<Movimentacao> listarMovimentacoes() {
        return movimentacaoService.findAll();
    }
}
