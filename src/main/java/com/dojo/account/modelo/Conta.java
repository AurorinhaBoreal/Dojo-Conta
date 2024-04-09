package com.dojo.account.modelo;

import com.dojo.account.interfaces.ContasMetodos;

public abstract class Conta implements ContasMetodos {
    private Long idConta;
    private Long idUsuario;

    public Conta(Long idConta, Long idUsuario) {
        this.idConta = idConta;
        this.idUsuario = idUsuario;
    }

    public abstract String consultarSaldo();

    public abstract void saque(double quantiaSaque);

    public abstract void deposito(double valor);
    
}
