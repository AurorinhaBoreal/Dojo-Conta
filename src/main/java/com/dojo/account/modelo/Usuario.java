package com.dojo.account.modelo;

import com.dojo.account.contas.ContaCorrente;
import com.dojo.account.contas.ContaInvestimento;
import com.dojo.account.contas.ContaPoupanca;

import java.util.ArrayList;
import java.util.Date;

public class Usuario {
    public ArrayList<Conta> accountList = new ArrayList<>();
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

    public Conta criarContaCorrente(int idConta, double desiredDeposit) {
        contaCorrente = new ContaCorrente(idConta, desiredDeposit);
        temCC = true;
        System.out.println("Sua Conta: "+contaCorrente);
        accountList.add(contaCorrente);
        return contaCorrente;
    }

    public boolean verifyCC() {
        if (temCC == true) {
            return false;
        }
        temCC = true;
        return true;
    }

    public Conta criarContaPoupanca(int idConta, double depositoInicial, Date dataAbertura) {
        contaPoupanca = new ContaPoupanca(idConta, depositoInicial, dataAbertura);
        temCP = true;
        System.out.println("Sua Conta: "+contaPoupanca);
        accountList.add(contaPoupanca);
        return contaPoupanca;
     
    }

    public boolean verifyCP() {
        if (temCP == true) {
            return false;
        }
        temCP = true;
        return true;
    }

    public Conta criarContaInvestimento(int idConta, double depositoInicial, Date dataAbertura) {
        contaInvestimento = new ContaInvestimento(idConta, depositoInicial, dataAbertura);
        temCI = true;
        System.out.println("Sua Conta: "+contaInvestimento);
        accountList.add(contaInvestimento);
        return contaInvestimento;
    }

    public boolean verifyCI() {
        if (temCC == true) {
            return false;
        }
        temCI = true;
        return true;
    }

    public void removerConta(int idConta) {
        boolean removed = accountList.removeIf(account -> account.getIdConta() == idConta);
        if (removed) {
            System.out.println("Conta removida com sucesso.");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void getAccounts() {
        System.out.println("Contas do Usuario: " + nome);
        accountList.toString();
        accountList.forEach((account) -> {
            System.out.println(account.toString());
        });
    }

    public void transferir() {

    }
}