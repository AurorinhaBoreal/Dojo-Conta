package com.dojo.account.contas;

import com.dojo.account.modelo.Conta;

public class ContaCorrente extends Conta{
    private final int limiteNegativo = -500;
    private double saldo = 0;

    public ContaCorrente(int idConta, double saldo) {
        super(idConta);
        this.saldo = saldo;
    }

    @Override
    public String consultarSaldo() {
        return "Seu saldo é "+saldo;
    }

    @Override
    public String toString() {
        return "Conta Corrente | ID: " + getIdConta();
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
    public void transferir(double valor, Conta conta) {

    }

    @Override
    public void saque(double valor){
        if(valor <= 0){
            throw new IllegalArgumentException("Valor inválido");
        }if(this.saldo - valor < limiteNegativo){
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        saldo -= valor;
        System.out.println("Saque efetuado com Sucesso!!");
    }

}