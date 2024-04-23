# ⚙️ Sistema de Controle de Contas

O desafio não representa um sistema real, apenas simula condições para exercitar a prática do POO
Tendo isso em vista, o desafio deve conter o uso de herança, implementação de interfaces e classes abstratas bem como uso de polimorfismo!

<br>

# 👤 Usuário.

- O sistema deve permitir a criação de um usuário.
- Cada usuário pode ter até três contas de tipos diferentes vinculadas
    - uma conta corrente 
    - uma conta investimento
    - uma conta poupança

<br>

# 🧾 Operações nas Contas:

- O sistema deve permitir as seguintes operações nas contas vinculadas ao usuário:
    - Depósito de valores.
    - Saque de valores.
    - Consulta do saldo de uma das contas.
    - Consulta do saldo total das contas.

# 🔎 Requisitos Específicos por Tipo de Conta

- Para a conta de investimento:
    - Só pode ser aberta com depósito inicial de R$ 1000,00.
    - Só é permitido sacar dinheiro se o primeiro depósito foi realizado há mais de 1 dia e não pode sacar mais que o total de crédito na conta.
    - Ao visualizar o saldo, o valor deve ser acrescido de 10% para cada dia desde o primeiro depósito.
- Para a conta corrente:
    - Pode ser aberta sem depósito inicial.
    - Permite saques e pode ficar negativa até R$ -500,00.
    - Ao visualizar o saldo, deve mostrar o saldo total sem alteração.
- Para a conta poupança:
    - Só pode ser aberta com depósito inicial de R$ 50,00.
    - Permite saques, mas não pode ficar negativa.
    - Ao visualizar o saldo, o valor deve ser acrescido de 5% para cada dia desde o primeiro depósito.

## Regras Adicionais:

- Para fechar/deletar uma conta, o saldo deve ser igual a zero.
- Implemente um método em Usuario que fecha uma conta:
        - O método deve receber uma conta do tipo poupança ou investimento, não pode receber um tipo conta corrente
        - O método saca todo o dinheiro da conta e fecha a mesma, passando o saldo para conta corrente
- Crie um método em cada tipo de conta, que recebe uma outra conta e um valor: 
        - O método deve pegar o valor recebido e retirar do saldo da conta passada como parâmetro
        - O método deve creditar o valor na conta!
- Será considerado um plus se houver testes unitários para validar o comportamento das classes.
    

## Agora vamos testar nossa aplicação: 
    - Crie um usuario
    - Adicione uma conta corrente
    - Adicione saldo a conta
    - Adicione uma conta investimento
    - Passe todo o dinheiro da conta investimento para a conta corrente
    - Faça um saque para ficar com saldo negativo na conta corrente
    - ...
    - ...   



    vamos ter que ter 5 classes

<br>

# 📖 User Stories

### ✅ [US001] Como Cliente, quero poder criar um usuário para utilizar o sistema.

### ✅ [US002] Como Usuário, quero poder criar uma conta de cada tipo vinculadas a mim.

### ✅ [US002-1] Como Usuário, quero poder abrir minha Conta Investimento

### ✅ [US002-2] Como Usuário, quero poder abrir minha Conta Corrente

### ✅ [US002-3] Como Usuário, quero poder abrir minha Conta Popupança

### ✅ [US003-1] Como Usuário utilizando a Conta Investimento, quero poder depositar dinheiro na mesma

### ✅ [US003-2] Como Usuário utilizando a Conta Investimento, quero poder sacar o dinheiro da mesma

### ✅ [US003-3] Como Usuário utilizando a Conta de Investimento, quero poder visualizar o saldo acrescido

### ✅ [US004-1] Como Usuário utilizando a Conta Corrente, quero poder depositar dinheiro na Conta

### ✅ [US004-2] Como Usuário utilizando a Conta Corrente, quero poder realizar saques e ficar negativado

### ✅ [US004-3] Como Usuário utilizando a Conta Corrente, quero visualizar o meu saldo sem acrescimo

### ✅ [US005-1] Como Usuário utilizando a Conta Poupança, quero poder realizar depositos

### ✅ [US005-2] Como Usuário utilizando a Conta Poupança, quero realizar saques

### ✅ [US005-3] Como Usuário utilizando a Conta Popuança, quero poder visualizar o saldo acrescido

### ✅ [US006] Como Usuário vinculado a uma Conta Corrente, quero poder deletar uma conta poupança ou de investimento

### ✅ [US006-1] Impedir Removimento da Conta Corrente e Tranferir Saldo para a Mesma ao Removimento de Outras

### ✅ [US007] Como Usuário vinculado a mais de uma conta, quero poder transferir saldo entre elas.

### ✅ [US008] Como usuário quero uma interface para poder utilizar o sistema

### ✅ [US008] Como usuário quero uma interface para poder utilizar o sistema

<br>

# 🏗️ Estrutura Inicial do Projeto

- (-) -> Atributo
- (->) -> Método
## Usuario 
    - int idUsuario
    - String name
    - boolean hasCA
    - boolean hasIA
    - boolean hasSA

## Conta (Classe Abstrata)
    - int idConta
    - int idUsuario
    - double saldo
    -> Saque() - Override caso Necessário
    -> Deposito() - Override caso Necessário

## ContaCorrente (Herdada)
    - int limiteNegativo;

## ContaInvestimento (Herdada)
    - Date contaCriada;
    - int depositoInicial = 1000;
    -> taxaRendimento() 

## ContaPoupanca (Herdada)
    - int depositoInicial = 50;
