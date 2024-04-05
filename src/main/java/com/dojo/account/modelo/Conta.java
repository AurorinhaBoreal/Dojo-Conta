package main.java.com.dojo.account.modelo;

public abstract class Conta {
    private Long idConta;
    private Long idUsuario;
    protected double saldo;

    public Conta(Long idConta, Long idUsuario, double saldo) {
        this.idConta = idConta;
        this.idUsuario = idUsuario;
        this.saldo = 0;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public abstract void Saque(double quantiaSaque);

    public abstract void Deposito(double quantiaDeposito);
    
}
