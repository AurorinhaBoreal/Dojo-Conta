package com.dojo.account.main;

import com.dojo.account.modelo.Usuario;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("João", 1);
        System.out.println(usuario);
        usuario.criarContaCorrente(101L);
        usuario.criarContaPoupanca(102L, 500.0, new Date());
        usuario.criarContaInvestimento(103L, 1000.0, new Date());
        usuario.getAccounts();
    }
}