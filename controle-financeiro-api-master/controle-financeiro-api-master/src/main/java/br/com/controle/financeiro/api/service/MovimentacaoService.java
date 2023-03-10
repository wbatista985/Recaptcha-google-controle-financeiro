package br.com.controle.financeiro.api.service;

import br.com.controle.financeiro.api.model.Movimentacao;

import java.util.List;


public interface MovimentacaoService {

    Movimentacao salvarMovimentacao(Movimentacao movimentacao);
    List<Movimentacao> findAll();

}
