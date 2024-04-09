package com.dojo.account.modelo;

import com.dojo.account.contas.ContaCorrente;
import com.dojo.account.contas.ContaInvestimento;
import com.dojo.account.contas.ContaPoupanca;

import java.util.Date;
import java.util.ArrayList;


public class Usuario {
    private ArrayList<Conta> accountList = new ArrayList<>();
    private String nome;
    private int idUsuario;
    private boolean temCC = false;
    private boolean temCP = false;
    private boolean temCI = false;
    private Conta contaCorrente;

    private Conta contaInvestimento;

    private Conta contaPoupanca;



    
    public Usuario(String nome, int idUsuario) {

        this.nome = nome;
        this.idUsuario = idUsuario;
    }

    private String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "| ID: "+this.idUsuario+" | Usuário: "+this.nome+" |";
    }
    

    public Conta criarContaCorrente(Long idConta) {
        if (temCC) {
            System.out.println("O usuário já possui uma conta corrente.");
            return null;
        } else {
            contaCorrente = new ContaCorrente(idConta);
            temCC = true;
            accountList.add(contaCorrente);
            return contaCorrente;
        }
    }

    public Conta criarContaPoupanca(Long idConta, double depositoInicial, Date dataAbertura) {
        if (temCP) {
            System.out.println("O usuário já possui uma conta poupança.");
            return null;
        } else {
            contaPoupanca = new ContaPoupanca(idConta, depositoInicial, dataAbertura);
            temCP = true;
            accountList.add(contaPoupanca);
            return contaPoupanca;
        }
    }

    public Conta criarContaInvestimento(Long idConta, double depositoInicial, Date dataAbertura) {
        if (temCI) {
            System.out.println("O usuário já possui uma conta de investimento.");
            return null;
        } else {
            contaInvestimento = new ContaInvestimento(idConta, depositoInicial, dataAbertura);
            temCI = true;
            accountList.add(contaInvestimento);
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


