package com.dojo.account.modelo;

public abstract class Conta {
    private Long idConta;
    private Long idUsuario;
    protected double saldo;

    public Conta(Long idConta, Long idUsuario) {
        this.idConta = idConta;
        this.idUsuario = idUsuario;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public abstract void saque(double quantiaSaque);

    public abstract void deposito(double quantiaDeposito);
    
}
