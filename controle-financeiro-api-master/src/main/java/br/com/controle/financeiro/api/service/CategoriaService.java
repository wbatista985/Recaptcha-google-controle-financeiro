package br.com.controle.financeiro.api.service;

import br.com.controle.financeiro.api.model.Categoria;

import java.util.List;


public interface CategoriaService {

    Categoria salvarCategoria(Categoria categoria);
    List<Categoria> findAll();

}
