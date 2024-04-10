package com.dojo.account.interfaces;

public interface ContasMetodos {
    String consultarSaldo();
    void saque(double valor);
    void deposito(double valor);

}