package com.dojo.account.modelo;

public abstract class Conta {
    private Long idConta;
    private Long idUsuario;

    public Conta(Long idConta, Long idUsuario) {
        this.idConta = idConta;
        this.idUsuario = idUsuario;
    }

    public abstract String consultarSaldo();

    public abstract void saque(double quantiaSaque);

    public abstract void deposito(double quantiaDeposito);
    
}
