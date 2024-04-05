package main.java.com.dojo.account.contas;

import java.util.Date;

public class ContaInvestimento extends Conta{
    private final double depositoInicial = 1000;
    private final double taxaRendimento = 0.10;
    private Date dataAbertura;
        
    

    @Override
    public void depositar(double valor) {
        if(saldo == 0){
            saldo = depositoInicial;
        }
    }

    @Override
    public void sacar(double valor) {
    
        if (dataAbertura != null){
            Date dataAtual = new Date();
            long diferenca = dataAtual.getTime() - dataAbertura.getTime();
            long dias = diferenca / (1000 * 60 * 60 * 24);
            this.saldo += this.saldo * taxaRendimento * dias;
            System.out.println("Deposito efetuado com Sucesso!!");
        }
        
        if (dias >= 1) {
            if(saldo >= valor){
                saldo -= valor;
                System.out.println("Saque efetuado com Sucesso!!");
            }
        }
    }


}
