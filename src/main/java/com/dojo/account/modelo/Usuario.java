package com.dojo.account.modelo;

import java.util.ArrayList;

public class Usuario {
    private ArrayList<Conta> accountList = new ArrayList<>();
    private String nome;
    private int idUsuario;
    private boolean temCC = false;
    private boolean temCP = false;
    private boolean temCI = false;
    
    
    public Usuario(String nome, int idUsuario) {
        this.nome = nome;
        this.idUsuario = idUsuario;
    }

    private String getNome() {
        return nome;
    }

    private void criandoCC() {
        temCC = true;
    }

    private void criandoCP() {
        temCP = true;
    }

    private void criandoCI() {
        temCI = true;
    }

    @Override
    public String toString() {
        return "| ID: "+this.idUsuario+" | Usuário: "+this.nome+" |";
    }

    public void getAccounts() {
        System.out.println(String.format("Contas do Usuário: %s", nome));
        accountList.forEach((account) -> {
            System.out.println(account);
        });
    }
}
