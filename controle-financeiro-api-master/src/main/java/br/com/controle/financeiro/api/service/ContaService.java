package br.com.controle.financeiro.api.service;

import br.com.controle.financeiro.api.model.Conta;

import java.util.List;


public interface ContaService {

    Conta salvarConta(Conta conta);
    List<Conta> findAll();
    void creditar(double valor, Long id);
    void debitar(double valor, Long id);
}
