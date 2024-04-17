package com.dojo.account;

import org.springframework.boot.SpringApplication;
import java.time.LocalDate;

import com.dojo.account.contas.ContaCorrente;
import com.dojo.account.contas.ContaInvestimento;
import com.dojo.account.contas.ContaPoupanca;
import com.dojo.account.modelo.Conta;
import com.dojo.account.modelo.Usuario;

import java.util.Scanner;
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
				+ "| 3 - Sacar | 4 - Depositar |\n| 5 - Ver Saldo | 6 - Transferir | 7 - Apagar Conta");


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
				verSaldo(usuario);
				usuarioMenu(usuario);
			case 6:
				transferir(usuario);
				usuarioMenu(usuario);
				break;
			case 7:
				removerConta(usuario);
				usuarioMenu(usuario);
				break;
			default:
				System.out.println("Ação Inválida! Voltando ao Menu...");
				usuarioMenu(usuario);
				break;
		}
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


		boolean balanceResult = balanceVerify(accountType, desiredDeposit);
		if (balanceResult == false) {
			System.out.println("Deposito Insuficiente para criação da conta desejada!");
		}
		switch (accountType) {
			case 1:
				usuario.criarContaCorrente(desiredId, desiredDeposit);
				// Identificar o ID da conta criada e calcular rendimento
				break;
			case 2:
				usuario.criarContaPoupanca(desiredId, desiredDeposit, LocalDate.of(2024, 4, 1));
				// Identificar o ID da conta criada e calcular rendimento
				break;
			case 3:
				usuario.criarContaInvestimento(desiredId, desiredDeposit, LocalDate.of(2024, 4, 1));
				// Identificar o ID da conta criada e calcular rendimento
				break;
			default:
				System.out.println("Opção Inválida!");
				usuarioMenu(usuario);
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

	private static boolean balanceVerify(int accountType, double desiredDeposit) {
		boolean result;
		switch (accountType) {
			case 1:
				if (desiredDeposit < -1) result = false;
				else result = true;
				return result;
			case 2:
				if (desiredDeposit < 50) result = false;
				else result = true;
				return result;
			default:
				if (desiredDeposit < 1000) result = false;
				else result = true;
				return result;
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

		System.out.println("Você escolheu o ID: " + desiredId);
		usuario.accountList.forEach((account) -> {
			if (account.getIdConta() == desiredId) {
				desiredAccount[0] = account;
			}
		});
		desiredAccount[0].saque(desiredWithdraw);
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

		System.out.println("Você escolheu o ID: " + desiredId);
		usuario.accountList.forEach((account) -> {
			if (account.getIdConta() == desiredId) {
				desiredAccount[0] = account;
			}
		});
		desiredAccount[0].deposito(desiredDeposit);
	}

	private static void verSaldo(Usuario usuario) {
		int desiredId;
		Conta[] desiredAccount = new Conta[1];
		System.out.println("Informe o ID conta deseja depositar:");
		usuario.getAccounts();
		desiredId = scanner.nextInt();

		System.out.println("Você escolheu o ID: " + desiredId);
		usuario.accountList.forEach((account) -> {
			if (account.getIdConta() == desiredId) {
				desiredAccount[0] = account;
			}
		});

		System.out.println(desiredAccount[0].consultarSaldo());
	}

	public static void transferir(Usuario usuario) {
		int fromAccountId, toAccountId;
		double amount = 0;

		usuario.getAccounts();
		System.out.println("Informe o ID da conta de origem:");
		fromAccountId = scanner.nextInt();

		System.out.println("Informe o ID da conta de destino:");
		toAccountId = scanner.nextInt();

		System.out.println("Informe o valor a ser transferido:");
		amount = scanner.nextDouble();

		saqueTrans(fromAccountId, amount, usuario);
		depositoTrans(toAccountId, amount, usuario);

		System.out.println("Valor Transferido: "+amount);
  	}

	private static void saqueTrans(int fromAccountId, double amount, Usuario usuario) {
		Conta[] desiredAccount = new Conta[1];

		usuario.accountList.forEach((account) -> {
			if (account.getIdConta() == fromAccountId) {
				desiredAccount[0] = account;
			}
		});
		System.out.println("Saq. Antes: "+desiredAccount[0].consultarSaldo());
		desiredAccount[0].saque(amount);
		System.out.println("O quantidade de "+amount+" foi sacada da sua conta!");
		System.out.println("Saq. Depois: "+desiredAccount[0].consultarSaldo());
	}


	private static void depositoTrans(int toAccountId, double amount, Usuario usuario) {
		Conta[] desiredAccount = new Conta[1];

		usuario.accountList.forEach((account) -> {
			if (account.getIdConta() == toAccountId) {
				desiredAccount[0] = account;
			}
		});
		System.out.println("Dep. Antes: "+desiredAccount[0].consultarSaldo());
		desiredAccount[0].deposito(amount);
		System.out.println("A quantidade de "+amount+" foi depositada na sua conta!");
		System.out.println("Dep. Depois: "+desiredAccount[0].consultarSaldo());
	}


	private static void removerConta(Usuario usuario) {
		int originId;
		Conta[] originAccount = new Conta[1];
		System.out.println("Informe o ID da conta que deseja remover:");
		usuario.getAccounts();
		originId = scanner.nextInt();

		System.out.println("Você escolheu o ID: "+originId);

		usuario.accountList.forEach((account) -> {
			if (account.getIdConta() == originId) originAccount[0] = account;
		});

		if (originAccount[0] instanceof ContaCorrente) {
			System.out.println("Não é possivel apagar a conta corrente!");
		}
		else {
			double originBalance;
			Conta[] destinyAccount = new Conta[1];
			usuario.accountList.forEach((account) -> {
				if(account instanceof ContaCorrente) {
					destinyAccount[0] = account;
				}
			});

			if (originAccount[0] instanceof ContaInvestimento) {
				System.out.println("Deletada Conta Investimento!");
				usuario.changeTemCI();
			} else if (originAccount[0] instanceof ContaPoupanca) {
				System.out.println("Deletada Conta Poupança!");
				usuario.changeTemCP();
			}

			originBalance = originAccount[0].getSaldo();

			originAccount[0].saque(originBalance);
			destinyAccount[0].deposito(originBalance);
			System.out.println("Transferência efetuada com sucesso");
			originAccount[0].getSaldo();
			destinyAccount[0].getSaldo();

			
			boolean removed = usuario.accountList.removeIf(account -> account.getIdConta() == originId);
			if (removed) {
				System.out.println("Conta removida com sucesso.");
			} else {
				System.out.println("Conta não encontrada.");
			}
		}
	}
}