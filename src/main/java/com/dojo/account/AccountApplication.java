package com.dojo.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.Calendar;
import com.dojo.account.contas.ContaCorrente;
import com.dojo.account.contas.ContaInvestimento;
import com.dojo.account.contas.ContaPoupanca;
import com.dojo.account.modelo.Conta;
import com.dojo.account.modelo.Usuario;

import java.util.Scanner;
@SpringBootApplication
public class AccountApplication {
	static Scanner scanner = new Scanner(System.in);
	static int action = -1;
	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
		Usuario usuario = new Usuario("Aurora", 23);
		usuarioMenu(usuario);
	};

	public static void usuarioMenu(Usuario usuario) {
		System.out.println("Bem vindo! Que ação deseja executar?");
		System.out.println("| 1 - Se Registrar | 2 - Criar Conta |\n"
		+"| 3 - Sacar | 4 - Depositar |\n| 5 - Transferir | 6 - Apagar Conta");

		action = scanner.nextInt();
		scanner.nextLine();
		// Captura a quebra de linha

		switch (action) {
			case 1:
				usuario = criarUsuario();
				usuarioMenu(usuario);
				break;
			case 2:
				criarConta(usuario);
				usuarioMenu(usuario);
				break;
			case 3:
				sacar(usuario);
				usuarioMenu(usuario);				
				break;
			case 4:
				depositar(usuario);
				usuarioMenu(usuario);
				break;
			case 5:
				// transferir(usuario);
				usuarioMenu(usuario);
				break;
			case 6:
				// deleteAccount(usuario);
				usuarioMenu(usuario);
				break;
			default:
				System.out.println("Ação Inválida! Voltando ao Menu...");
				usuarioMenu(usuario);
				break;
		}
	}

	private static Date AnteOntem() {

		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.DAY_OF_YEAR, -2);

		return calendar.getTime();

	}

	private static Usuario criarUsuario() {
		String userName;
		System.out.println("Informe o seu primeiro Nome: ");
		userName = scanner.nextLine();
		Usuario usuario = new Usuario(userName, 1);
		return usuario;
	}

	private static void criarConta(Usuario usuario) {
		int accountType;
		int desiredId;
		double desiredDeposit = 0;

		System.out.println("Que tipo de conta deseja criar?");
		System.out.println("| 1 - Conta Corrente (CC) | 2 - Conta Poupança (CP) | 3 - Conta Investimento (CI) |");
		accountType = scanner.nextInt();
		
		boolean result = verifyAccount(accountType, usuario);
		if (result == false) {
			System.out.println("Você ja possui uma conta desse tipo!");
			criarConta(usuario);
		}
		System.out.println("Informe o ID desejado para a Conta:");
		desiredId = scanner.nextInt();

		System.out.println("Informe o Deposito Inicial da Conta:");
		System.out.println("Para a criação de Conta Poupança - Min: 50");
		System.out.println("Para a criação de Conta Investimento - Min: 1000");

		desiredDeposit = scanner.nextDouble();

		switch (accountType) {
			case 1:
				usuario.criarContaCorrente(desiredId, desiredDeposit);
				break;
			case 2:
				usuario.criarContaPoupanca(desiredId, desiredDeposit, AnteOntem());
				break;
			case 3:
				usuario.criarContaInvestimento(desiredId, desiredDeposit, AnteOntem());
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
		}
	}

	private static boolean verifyAccount(int accountType, Usuario usuario) {
		boolean verifiedCC = true;
		boolean verifiedCP = true;
		boolean verifiedCI = true;
		switch (accountType) {
			case 1:
				verifiedCC = usuario.verifyCC();
				return verifiedCC;
			case 2:
				verifiedCP = usuario.verifyCP();
				return verifiedCP;	
			default:
				verifiedCI = usuario.verifyCI();
				return verifiedCI;	
		}
		
	}

	private static void sacar(Usuario usuario) {
		int desiredId;
		double desiredWithdraw;
		Conta[] desiredAccount = new Conta[1];
		System.out.println("Informe o ID da conta que deseja sacar:");
		usuario.getAccounts();
		desiredId = scanner.nextInt();

		System.out.println("Informe quanto você deseja sacar:");
		desiredWithdraw = scanner.nextInt();

		System.out.println("Você escolheu o ID: "+desiredId);
		usuario.accountList.forEach((account) -> {
			if (account.getIdConta() == desiredId) {
				desiredAccount[0] = account;
			} 
		});
		desiredAccount[0].saque(desiredWithdraw);
		System.out.println(desiredAccount[0].consultarSaldo());
	}

	private static void depositar(Usuario usuario) {
		int desiredId;
		double desiredDeposit;
		Conta[] desiredAccount = new Conta[1];
		System.out.println("Informe o ID conta deseja depositar:");
		usuario.getAccounts();
		desiredId = scanner.nextInt();

		System.out.println("Informe quanto você deseja depositar:");
		desiredDeposit = scanner.nextDouble();

		System.out.println("Você escolheu o ID: "+desiredId);
		usuario.accountList.forEach((account) -> {
			if (account.getIdConta() == desiredId) {
				desiredAccount[0] = account;
			} 
		});
		desiredAccount[0].deposito(desiredDeposit);
		System.out.println(desiredAccount[0].consultarSaldo());
	}
}
