package br.com.controle.financeiro.api.controller;

import br.com.controle.financeiro.api.model.Conta;
import br.com.controle.financeiro.api.service.ContaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@RequestMapping("/conta")
@EnableSwagger2
public class ContaController {

    private final ContaService contaService;

    @Autowired
    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @PostMapping("/salvar")
    public Conta salvarConta(@RequestBody Conta conta) {
        return contaService.salvarConta(conta);
    }

    @ApiOperation(value = "Retorna uma lista de contas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de contas"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar a lista de contas"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping(value = "/listar-contas", produces = "application/json")
    public List<Conta> listarContas() {
        return contaService.findAll();
    }

}
