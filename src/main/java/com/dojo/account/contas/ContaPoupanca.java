package com.dojo.account.contas;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import com.dojo.account.modelo.Conta;

public class ContaPoupanca extends Conta {
    private final double taxaRendimento = 0.05;
    private LocalDate dataAbertura;
    private double saldo = 0;
    
    public ContaPoupanca(int idConta, double saldo, LocalDate dataAbertura) {
        super(idConta);
        this.saldo = saldo;
        this.dataAbertura = dataAbertura;
    }

    @Override
    public String consultarSaldo() {

        if (dataAbertura != null){
            LocalDate dataAtual = LocalDate.now();
            Long dias = ChronoUnit.DAYS.between(dataAbertura, dataAtual);
            this.saldo += (this.saldo * taxaRendimento) * dias;
        }

        return "Seu saldo é "+saldo;
    }

    @Override
    public void saque(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        } if(this.saldo - valor < 0){
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        this.saldo -= valor;
        System.out.println("Saque efetuado com Sucesso!!");
    }

    @Override
    public void deposito(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta conta) {

    }

    @Override
    public String toString() {
        return "Conta Poupança | ID: " + getIdConta();
    }
}
