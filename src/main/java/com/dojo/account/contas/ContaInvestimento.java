package com.dojo.account.contas;

import java.util.Date;
import com.dojo.account.modelo.Conta;

public class ContaInvestimento extends Conta{
    private final int minDepositoInicial = 1000;
    private final double taxaRendimento = 0.10;
    private double depositoInicial;
    private Date dataAbertura;
        
    public ContaInvestimento(Long idConta, Long idUsuario, double depositoInicial, Date dataAbertura) {
        super(idConta, idUsuario);
        this.depositoInicial = depositoInicial;
        this.dataAbertura = dataAbertura;
    }

    @Override
    public void deposito(double valor) {
        if(saldo == 0){
            saldo = depositoInicial;
        }
    }

    @Override
    public void saque(double valor) {
    Long dias = 0L;

        if (dataAbertura != null){
            Date dataAtual = new Date();
            Long diferenca = dataAtual.getTime() - dataAbertura.getTime();
            dias = diferenca / (1000 * 60 * 60 * 24);
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
