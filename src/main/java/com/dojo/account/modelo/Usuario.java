package com.dojo.account.modelo;

import com.dojo.account.contas.ContaCorrente;

public class Usuario {
    private String nome;
    private Long idDoUsuario;
    private boolean temCC = false;
    private boolean temCP = false;
    private boolean temCI = false;
    private Conta contaCorrente;
    
    
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


}
