package com.dojo.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dojo.account.modelo.Usuario;

import java.util.Scanner;
@SpringBootApplication
public class AccountApplication {
	static Scanner scanner = new Scanner(System.in);
	static int action = -1;
	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
		
		usuarioMenu();
	};

	public static void usuarioMenu() {
		System.out.println("Bem vindo! Que ação deseja executar?");
		System.out.println("| 1 - Se Registrar | 2 - Criar Conta |\n"
		+"| 3 - Sacar | 4 - Depositar |\n| 5 - Transferir | 6 - Apagar Conta");

		action = scanner.nextInt();
		scanner.nextLine();
		// Captura a quebra de linha

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
				// sacar();
				usuarioMenu();
				break;
			case 4:
				// depositar();
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
		Usuario usuario = new Usuario(userName, 1);
	}

	public static void criarConta() {
		int accountType;
		System.out.println("Que tipo de conta deseja criar?");
		System.out.println("| 1 - Conta Corrente (CC) | 2 - Conta Poupança (CP) | 3 - Conta Investimento (CI) |");
		accountType = scanner.nextInt();
		
		System.out.println(accountType);
	}
}
