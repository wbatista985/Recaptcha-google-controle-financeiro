package br.com.controle.financeiro.api.service.impl;

import br.com.controle.financeiro.api.model.Categoria;
import br.com.controle.financeiro.api.repository.CategoriaRepository;
import br.com.controle.financeiro.api.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria salvarCategoria(Categoria categoria) {
        try {
            categoriaRepository.save(categoria);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar categoria.");
        }
        return categoria;
    }

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }
}
