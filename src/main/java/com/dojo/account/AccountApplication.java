package com.dojo.account;


import com.dojo.account.contas.ContaInvestimento;
import com.dojo.account.contas.ContaPoupanca;
import com.dojo.account.modelo.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AccountApplication {
	static Scanner scanner = new Scanner(System.in);
	static List<Usuario> usuarios = new ArrayList<>();

	public static void main(String[] args) {
		usuarioMenu();
	}

	public static void usuarioMenu() {
		System.out.println("Bem vindo! Que ação deseja executar?");
		System.out.println("| 1 - Se Registrar | 2 - Criar Conta |\n"
				+ "| 3 - Sacar | 4 - Depositar |\n| 5 - Transferir | 6 - Apagar Conta");

		int action = scanner.nextInt();
		scanner.nextLine();

		switch (action) {
			case 1:
				criarUsuario();
				usuarioMenu();
				break;
			case 2:
				criarConta();
				usuarioMenu();
				break;
			case 3:
				ContaInvestimento ci = new ContaInvestimento(2,2960,new Date());
				ci.consultarSaldo();
				ci.saque(300);
				System.out.println("Conta após saque");
				ci.consultarSaldo();
				usuarioMenu();
				break;
			case 4:
				ContaPoupanca cp = new ContaPoupanca(1,50,new Date());
				cp.deposito(50);


				usuarioMenu();
				break;
			case 5:
				// transferir();
				usuarioMenu();
				break;
			case 6:
				// deleteAccount();
				usuarioMenu();
				break;
			default:
				System.out.println("Ação Inválida! Voltando ao Menu...");
				usuarioMenu();
				break;
		}
	}

	public static void criarUsuario() {
		String userName;
		System.out.println("Informe o seu primeiro Nome: ");
		userName = scanner.nextLine();
		Usuario usuario = new Usuario(userName, usuarios.size() + 1);
		usuarios.add(usuario);
		System.out.println("Usuário " + userName + " criado com sucesso!");
	}

	public static void criarConta() {
		if (usuarios.isEmpty()) {
			System.out.println("Nenhum usuário registrado. Crie um usuário primeiro.");
			return;
		}

		System.out.println("Para qual usuário deseja criar a conta? Informe o número do usuário:");
		for (int i = 0; i < usuarios.size(); i++) {
			System.out.println((i + 1) + " - " + usuarios.get(i).getNome());
		}

		int userChoice = scanner.nextInt();
		scanner.nextLine();

		if (userChoice < 1 || userChoice > usuarios.size()) {
			System.out.println("Número de usuário inválido.");
			return;
		}

		Usuario usuario = usuarios.get(userChoice - 1);

		int accountType;
		System.out.println("Que tipo de conta deseja criar?");
		System.out.println("| 1 - Conta Corrente (CC) | 2 - Conta Poupança (CP) | 3 - Conta Investimento (CI) |");
		accountType = scanner.nextInt();

		switch (accountType) {
			case 1:
				usuario.criarContaCorrente(8);
				System.out.println("Conta Corrente criada com sucesso para " +  new Date());
				break;
			case 2:
				usuario.criarContaPoupanca(9, 0.0,  new Date());
				System.out.println("Conta Poupança criada com sucesso para " + usuario.getNome());
				break;
			case 3:
				usuario.criarContaInvestimento(10, 0.0, new Date());
				System.out.println("Conta Investimento criada com sucesso para " + usuario.getNome());
				break;
			default:
				System.out.println("Opção inválida.");
		}
	}
}
