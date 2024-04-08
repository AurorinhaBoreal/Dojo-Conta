package com.dojo.account.contas;

import java.util.Date;
import com.dojo.account.modelo.Conta;

public class ContaPoupanca extends Conta {
    private int depositoInicial = 50;
    private Date dataAbertura;
    private double taxaRendimento = 0.05;

    
    public ContaPoupanca(int depositoInicial, Date dataAbertura, double taxaRendimento) {
        this.depositoInicial = depositoInicial;
        this.dataAbertura = dataAbertura;
        this.taxaRendimento = taxaRendimento;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido");            
        } if(this.saldo - valor < 0){
            throw new IllegalArgumentException("Saldo insuficiente");          
        }
        this.saldo -= valor;
        System.out.println("Saque efetuado com Sucesso!!");
    }
    
    @Override
    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido");    
        }
        this.saldo += valor;
        System.out.println("Depósito efetuado com Sucesso!!");
    }

    public void rendimento() {
        if (dataAbertura != null){
            Date dataAtual = new Date();
            long diferenca = dataAtual.getTime() - dataAbertura.getTime();
            long dias = diferenca / (1000 * 60 * 60 * 24);
            this.saldo += this.saldo * taxaRendimento * dias;
        }
    }
}

