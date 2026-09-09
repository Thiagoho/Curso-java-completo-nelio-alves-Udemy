
O Bank Java é um sistema bancário desenvolvido em Java para terminal, criado com o objetivo de praticar orientação a objetos e tratamento de exceções. O projeto permite cadastrar contas corrente e poupança, realizar depósitos, saques e consultas. Foram aplicados os quatro pilares da POO: encapsulamento, herança, abstração e polimorfismo. Também foram criadas exceções personalizadas para tratar situações como nome inválido, CPF inválido, valores incorretos e saldo insuficiente. O uso de try/catch permite que o sistema trate esses erros sem interromper sua execução.

=====================================================================================================================================
Roteiro do desenvolvimento

Primeiro foi criada a classe abstrata Account, que representa uma conta bancária genérica. Nela ficaram os dados comuns a qualquer conta, como nome do cliente, CPF, número da conta e saldo. Também foram definidos comportamentos comuns, como depósito, além do método de saque, que pode ter regras diferentes dependendo do tipo de conta.

Depois foram criadas duas classes filhas: CheckingAccount e SavingsAccount. A CheckingAccount representa a conta corrente e possui um limite adicional. Já a SavingsAccount representa a conta poupança e possui uma taxa de rendimento.

A partir disso, o sistema passou a trabalhar com os 4 pilares da orientação a objetos. O encapsulamento foi aplicado utilizando atributos privados e métodos controlados para alteração dos dados. A herança apareceu quando CheckingAccount e SavingsAccount passaram a herdar de Account. A abstração foi usada ao transformar Account em uma classe abstrata. E o polimorfismo apareceu quando diferentes tipos de conta passaram a ser tratados através do tipo Account, mas executando comportamentos próprios, principalmente no saque.

Depois disso foi criada a parte de tratamento de erros. O objetivo foi impedir que o sistema simplesmente encerrasse quando o usuário informasse valores incorretos.

Foram criadas exceções personalizadas como InvalidAmountException, InsufficientBalanceException, InvalidNameException e InvalidCpfException.

Por exemplo, quando o usuário tenta fazer um saque maior que o saldo disponível, a conta lança uma InsufficientBalanceException. O Main captura essa exceção utilizando catch e mostra uma mensagem amigável.

========================================================================================================================================
Separação das responsabilidades

A estrutura ficou conceitualmente assim:

application
└── Main
    └── interação com o usuário e try/catch

model.entities
├── Account
├── CheckingAccount
└── SavingsAccount
    └── regras das contas

model.exceptions
├── InvalidAmountException
├── InsufficientBalanceException
├── InvalidNameException
└── InvalidCpfException
    └── erros específicos do sistema
    
 ========================================================================================================================================
   
Para continuar o projeto, o próximo passo natural é:



List<Account> accounts = new ArrayList<>();

Aí seu sistema realmente vira um pequeno banco.

Minha avaliação da organização atual seria 7/10. Para aprendizado, está bom e mostra vários conceitos interessantes. Para projeto de portfólio, eu faria uma pequena refatoração.

Eu dividiria assim:

application
    Program

model.entities
    Account
    CheckingAccount
    SavingsAccount

model.exceptions
    InvalidNameException
    InvalidAmountException
    InsufficientBalanceException
    AccountNotFoundException

service
    AccountService

ui
    BankMenu

Aí:

Program
   ↓
BankMenu
   ↓
AccountService
   ↓
Account / CheckingAccount / SavingsAccount

Isso reduz bastante a verbosidade do main sem esconder os conceitos que você está estudando.

E tem um ponto importante: não refatore tudo agora. Como seu objetivo atual é aprender try/catch, eu primeiro corrigiria a validação do nome na poupança e os pequenos problemas acima. Depois podemos fazer uma segunda versão refatorada e comparar lado a lado: seu Main atual vs Main organizado com métodos e AccountService.
