package br.com.controle.financeiro.api.service.impl;

import br.com.controle.financeiro.api.model.Conta;
import br.com.controle.financeiro.api.repository.ContaRepository;
import br.com.controle.financeiro.api.service.ContaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaServiceImpl implements ContaService {

    private final ContaRepository contaRepository;

    public ContaServiceImpl(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @Override
    public Conta salvarConta(Conta conta) {
        try {
            contaRepository.save(conta);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar conta.");
        }
        return conta;
    }

    @Override
    public List<Conta> findAll() {
        return contaRepository.findAll();
    }

    @Override
    public void creditar(double valor, Long id) {
        contaRepository.setFixedSaldoFor(valor, id);
    }

    @Override
    public void debitar(double valor, Long id) {
        try {
            double saldo = contaRepository.getSaldoById(id);
            if ((saldo - valor) >= 0) {
                contaRepository.setFixedSaldo(valor, id);
            } else {
                throw new RuntimeException("Saldo insuficiente");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar debitar valor da conta.");
        }
    }

}
