package main.java.com.dojo.account.contas;

import main.java.com.dojo.account.modelo.Conta;

public class ContaCorrente extends Conta{
    private final int limiteNegativo = -500;

    public ContaCorrente(Long idConta, Long idUsuario, double saldo) {
        super(idConta, idUsuario, saldo);
    }

    @Override
    public void depositar(double valor){
        if(valor <= 0){
            throw new IllegalArgumentException("Valor inválido");
        }
        this.saldo += valor;
        System.out.println("Deposito efetuado com Sucesso!!");
    }

    @Override
    public void sacar(double valor){
        if(valor <= 0){
            throw new IllegalArgumentException("Valor inválido");
        }if(this.saldo - valor < limiteNegativo){
            throw new IllegalArgumentException("Saldo insuficiente");
        }
        this.saldo -= valor;
        System.out.println("Saque efetuado com Sucesso!!");
    }

}
