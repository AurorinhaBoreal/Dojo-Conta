package com.dojo.account.contas;

import com.dojo.account.modelo.Conta;

public class ContaCorrente extends Conta{
    private final int limiteNegativo = -500;

    public ContaCorrente(Long idConta, Long idUsuario) {
        super(idConta, idUsuario);
    }

    @Override
    public void deposito(double valor){
        if(valor <= 0){
            throw new IllegalArgumentException("Valor inválido");
        }
        this.saldo += valor;
        System.out.println("Deposito efetuado com Sucesso!!");
    }

    @Override
    public void saque(double valor){
        if(valor <= 0){
            throw new IllegalArgumentException("Valor inválido");
        }if(this.saldo - valor < limiteNegativo){
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        this.saldo -= valor;
        System.out.println("Saque efetuado com Sucesso!!");
    }

}
