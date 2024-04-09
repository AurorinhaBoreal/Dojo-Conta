package com.dojo.account.modelo;

import com.dojo.account.contas.ContaCorrente;
import com.dojo.account.contas.ContaInvestimento;
import com.dojo.account.contas.ContaPoupanca;

import java.util.ArrayList;
import java.util.Date;

public class Usuario {
    private ArrayList<Conta> accountList = new ArrayList<>();
    private int idUsuario;
    private String nome;
    private boolean temCC = false;
    private boolean temCP = false;
    private boolean temCI = false;
    private Conta contaCorrente;
    private Conta contaInvestimento;
    private Conta contaPoupanca;

    public Usuario(String nome, int idUsuario) {
        this.nome = nome;
        this.idUsuario = idUsuario;
        this.nome = nome;
    }

    private String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "| ID: " + this.idUsuario + " | Usuario: " + this.nome + " |";
    }

    public Conta criarContaCorrente(int idConta) {
        if (temCC) {
            System.out.println("O usuário já possui uma conta corrente.");
            return null;
        } else {
            contaCorrente = new ContaCorrente(idConta);
            temCC = true;
            System.out.println("Essa é a CC:"+contaCorrente);
            accountList.add(contaCorrente);
            return contaCorrente;
        }
    }


    public Conta criarContaPoupanca(int idConta, double depositoInicial, Date dataAbertura) {
        if (temCP) {
            System.out.println("O usuário já possui uma conta poupança.");
            return null;
        } else {
            contaPoupanca = new ContaPoupanca(idConta, depositoInicial, dataAbertura);
            temCP = true;
            System.out.println("Essa é a CP:"+contaPoupanca);
            accountList.add(contaPoupanca);
            return contaPoupanca;
        }
    }

    public Conta criarContaInvestimento(int idConta, double depositoInicial, Date dataAbertura) {
        if (temCI) {
            System.out.println("O usuário já possui uma conta de investimento.");
            return null;
        } else {
            contaInvestimento = new ContaInvestimento(idConta, depositoInicial, dataAbertura);
            temCI = true;
            System.out.println("Essa é a CI:"+contaInvestimento);
            accountList.add(contaInvestimento);
            return contaInvestimento;
        }
    }

    public void removerConta(int idConta) {
        boolean removed = accountList.removeIf(account -> account.getIdConta() == idConta);
        if (removed) {
            System.out.println("Conta removida com sucesso.");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public ContaInvestimento getContaInvestimento() {
        return (ContaInvestimento) contaInvestimento;
    }

    public void getAccounts() {
        System.out.println("Contas do Usuario:" + nome);
        accountList.forEach((account) -> {
            System.out.println(account);
        });
    }
}