Sistema de controle de contas

O desafio não representa um sistema real, apenas simula condições para exercitar a prática do POO
Tendo isso em vista, o desafio deve conter o uso de herança, implementação de interfaces e classes abstratas bem como uso de polimorfismo!

# Usuário.

- O sistema deve permitir a criação de um usuário.
- Cada usuário pode ter até três contas de tipos diferentes vinculadas
    - uma conta corrente 
    - uma conta investimento
    - uma conta poupança

# Operações nas Contas:

- O sistema deve permitir as seguintes operações nas contas vinculadas ao usuário:
    - Depósito de valores.
    - Saque de valores.
    - Consulta do saldo de uma das contas.
    - Consulta do saldo total das contas.

# Requisitos Específicos por Tipo de Conta

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

# Regras Adicionais:

- Para fechar/deletar uma conta, o saldo deve ser igual a zero.
- Implemente um método em Usuario que fecha uma conta:
        - O método deve receber uma conta do tipo poupança ou investimento, não pode receber um tipo conta corrente
        - O método saca todo o dinheiro da conta e fecha a mesma, passando o saldo para conta corrente
- Crie um método em cada tipo de conta, que recebe uma outra conta e um valor: 
        - O método deve pegar o valor recebido e retirar do saldo da conta passada como parâmetro
        - O método deve creditar o valor na conta!
- Será considerado um plus se houver testes unitários para validar o comportamento das classes.
    

    
# Agora vamos testar nossa aplicação: 
    - Crie um usuario
    - Adicione uma conta corrente
    - Adicione saldo a conta
    - Adicione uma conta investimento
    - Passe todo o dinheiro da conta investimento para a conta corrente
    - Faça um saque para ficar com saldo negativo na conta corrente
    - ...
    - ...   



    vamos ter que ter 5 classes

# Estrutura do Projeto

- (-) -> Atributo
- (->) -> Método
## Usuario 
    - Long idUsuario
    - String Name
    - boolean temCC
    - boolean temCI
    - boolean temCP

## Conta (Classe Abstrata)
    - Long idConta
    - Long idUsuario
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
