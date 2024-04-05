package main.java.com.dojo.account.modelo;

import main.java.com.dojo.account.contas.ContaCorrente;

public class Usuario {
    private String nome;
    private Long idDoUSuario;
    private boolean temCC;
    private boolean temCP;
    private boolean temCI;
    private Conta contaCorrente;
    
    
    public Usuario(String nome, Long idDoUSuario, boolean temCC, boolean temCP, boolean temCI) {
        this.nome = nome;
        this.idDoUSuario = idDoUSuario;
        this.temCC = false;
        this.temCP = false;
        this.temCI = false;
        this.contaCorrente = new ContaCorrente(idDoUSuario, idDoUSuario, 0);
    }

    public String getNome() {
        return nome;
    }

    public Long getIdDoUSuario() {
        return idDoUSuario;
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
