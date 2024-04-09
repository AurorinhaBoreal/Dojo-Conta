package com.dojo.account.modelo;

import com.dojo.account.contas.ContaCorrente;
import com.dojo.account.contas.ContaInvestimento;
import com.dojo.account.contas.ContaPoupanca;

import java.util.Date;
import java.util.ArrayList;


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
        this.idUsuario = idUsuario;
        this.nome = nome;
    }

    private String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "| ID: "+this.idUsuario+" | Usuário: "+this.nome+" |";
    }

    public Conta criarContaCorrente(int idConta) {
        if (temCC) {
            System.out.println("O usuário já possui uma conta corrente.");
            return null;
        } else {
            contaCorrente = new ContaCorrente(idConta);
            temCC = true;
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
            return contaInvestimento;
        }
    }
    public void getAccounts() {
        System.out.println(String.format("Contas do Usuário: %s", nome));
        accountList.forEach((account) -> {
            System.out.println(account);
        });
        }
    }


