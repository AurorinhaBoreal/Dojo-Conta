package com.dojo.account.modelo;

import com.dojo.account.interfaces.ContasMetodos;

public abstract class Conta implements ContasMetodos {
    private int idConta;

    public Conta(int idConta) {
        this.idConta = idConta;
    }

    public abstract String consultarSaldo();

    public abstract void saque(double quantiaSaque);

    public abstract void deposito(double valor);
    
}
