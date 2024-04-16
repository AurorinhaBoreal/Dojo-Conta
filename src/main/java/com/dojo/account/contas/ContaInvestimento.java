package com.dojo.account.contas;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import com.dojo.account.modelo.Conta;

public class ContaInvestimento extends Conta{
    private final double taxaRendimento = 0.10;
    private LocalDate dataAbertura;
    private double saldo = 0;

    @Override
    public double getSaldo() {
        return saldo;
    }
        
    public ContaInvestimento(int idConta, double saldo, LocalDate dataAbertura) {
        super(idConta);
        this.saldo = saldo;
        this.dataAbertura = dataAbertura;
        calcRend();
    }

    public void calcRend() {
        if (dataAbertura != null){
            LocalDate dataAtual = LocalDate.now();
            Long dias = ChronoUnit.DAYS.between(dataAbertura, dataAtual);
            this.saldo += (this.saldo * taxaRendimento) * dias;
        }
    }

    @Override
    public String toString() {
        return "Conta Investimento | ID: " + getIdConta();
    }

    @Override
    public String consultarSaldo() {
        return "Seu saldo é "+this.saldo;
    }

    @Override
    public void transferir(double valor, Conta conta) {};

    @Override
    public void deposito(double valor) {
        saldo =+ saldo;
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
}

