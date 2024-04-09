package com.dojo.account.modelo;

import java.util.ArrayList;

public class Usuario {
    private ArrayList<Conta> accountList = new ArrayList<>();
    private String name;
    private int userID;
    private boolean hasCA = false;
    private boolean hasSA = false;
    private boolean hasIA = false;
    
    
    public Usuario(String name, int userID) {
        this.name = name;
        this.userID = userID;
    }

    private String getName() {
        return name;
    }

    private void creatingCA() {
        hasCA = true;
    }

    private void creatingSA() {
        hasSA = true;
    }

    private void creatingIA() {
        hasIA = true;
    }

    @Override
    public String toString() {
        return "| ID: "+this.userID+" | Usuário: "+this.name+" |";
    }
    
    public void getAccounts() {
        System.out.println(String.format("Contas do Usuário: %s", name));
        accountList.forEach((account) -> {
            System.out.println(account);
        });
    }
}
