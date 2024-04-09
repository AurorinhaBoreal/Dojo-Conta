package com.dojo.account.modelo;

import com.dojo.account.contas.ContaCorrente;
import com.dojo.account.contas.ContaInvestimento;
import com.dojo.account.contas.ContaPoupanca;

import java.util.Date;

public class Usuario {
    private String nome;
    private Long idDoUsuario;
    private boolean temCC = false;
    private boolean temCP = false;
    private boolean temCI = false;
    private Conta contaCorrente;

    private Conta contaInvestimento;

    private Conta contaPoupanca;


    public Usuario(String nome, Long idDoUsuario) {
        this.nome = nome;
        this.idDoUsuario = idDoUsuario;
        // Ao criarmos contaCorrente temos o IdUsuario da Conta e do Usuario
        // this.contaCorrente = new ContaCorrente(idDoUsuario, idDoUsuario, 0);
    }

    public String getNome() {
        return nome;
    }

    public Long getIdDoUSuario() {
        return idDoUsuario;
    }

    public boolean getTemCC() {
        return temCC;
    }

    public boolean getTemCP() {
        return temCP;
    }

    public boolean getTemCI() {
        return temCI;
    }

    public Conta criarContaCorrente(Long idConta) {
        if (temCC) {
            System.out.println("O usuário já possui uma conta corrente.");
            return null;
        } else {
            contaCorrente = new ContaCorrente(idConta, idDoUsuario);
            temCC = true;
            return contaCorrente;
        }
    }

    public Conta criarContaPoupanca(Long idConta, double depositoInicial, Date dataAbertura) {
        if (temCP) {
            System.out.println("O usuário já possui uma conta poupança.");
            return null;
        } else {
            contaPoupanca = new ContaPoupanca(idConta, idDoUsuario, depositoInicial, dataAbertura);
            temCP = true;
            return contaPoupanca;
        }
    }

    public Conta criarContaInvestimento(Long idConta, double depositoInicial, Date dataAbertura) {
        if (temCI) {
            System.out.println("O usuário já possui uma conta de investimento.");
            return null;
        } else {
            contaInvestimento = new ContaInvestimento(idConta, idDoUsuario, depositoInicial, dataAbertura);
            temCI = true;
            return contaInvestimento;
        }
    }
}

