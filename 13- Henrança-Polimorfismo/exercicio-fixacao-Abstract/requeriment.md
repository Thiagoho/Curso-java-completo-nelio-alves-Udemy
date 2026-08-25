Esse exercicio entender mais sobre a class abstract.

A classe abstrata serve como uma classe-base para outras classses. Você não cria o objeto dela
diretamente, mas as classes filhas aproveitam seu atributos e métodos.

## 1 Imagine uma classe Animal
Todo animal pode ter: nome idade;
e todo animal pode: dormir();
---------------------------------
Porém, existe uma pergunta:
## Qual é o som de um Animal genérico?
Não sabemos. Um cachorro late, um gato mia, uma vaca muge.

Então 'Animal' é um otimo candidato para classe abstrata:
Observe duas coisas diferentes.
public abstract class Animal {

    private String nome;

    public Animal(String nome) {
        this.nome = nome;
    }

    public void dormir() {
        System.out.println(nome + " está dormindo.");
    }

    public abstract void emitirSom();
} 

Temos um método normal:

    public void dormir() {
        System.out.println(nome + " está dormindo.");
    }

E um método abstrato:
public abstract void emitirSom(); 
O método abstrato:
public abstract void emitirSom();
O método abstrato diz:

## Todo Animal precisa emitir um som, mas eu não sei qual. A classe filha será obrigada a definir.

## 2 Não podemos fazer isso
Como Animal é abstrata:
No main não pode fazer essa maneiro:
Animal animal = new Animal("Rex"); X Erro.
Porque estamos tentando instanciar diretamente 'Animal'.
É justamente aqui que costuma surgir sua dúvida.
" Então se não posso criar o objeto, para que ela serve? "
Eles serve atráves da herança.

## 3 Criamos a class cachorro
public class Cachorro extends Animal {

    public Cachorro(String nome) {
        super(nome);
    }

    @Override
    public void emitirSom() {
        System.out.println("Au au!");
    }
}
A palavra importante é:
' extends Animal '
Estamos dizendo:
Animal
   ↑
   │ herança
   │
Cachorro
O Cachorro recebe as caracteristicas de 'Animal':
Agora podemos:
Cachorro cachorro = new Cachorro("Rex");

cachorro.dormir();
cachorro.emitirSom();
Resultado: 
Rex esta dormindo.
Au au!
Perceba algo muito importante.
Nós não fizemos:
new Animal()
Mas o cachorrro esta usando:
dormir()
que foi criado dentro de Animal.
É assim que a classe abstrata está sendo usada.


## 4 Agora entra a parte mais interessante
Podemos criar outro animal:
public class Gato extends Animal {

    public Gato(String nome) {
        super(nome);
    }

    @Override
    public void emitirSom() {
        System.out.println("Miau!");
    }
}
Agora temos:
              Animal
            <<abstract>>
                 │
          ┌──────┴──────┐
          ↓             ↓
      Cachorro         Gato
Os dois ganham:
nome dormir()
Mas cada um implementa:
emitirSom()
de maneira diferente.

Cachorro
@Override
public void emitirSom() {
    System.out.println("Au au!");
}

Gato:
@Override
public void emitirSom() {
    System.out.println("Miau!");
}

## 5 Uma coisa que confunde bastante
Mesmo não podemos fazer:
Animal animal = new Animal("Rex"); // ❌
podemos fazer:
Animal animal = new Cachorro("Rex"); // ✅
Isso é permitido.
Leia essa linha como:
 "Minha variável é do tipo 'Animal', mas o objeto verdadeiro é um cachorro."
 Então:
 	animal.emitirSom();
 produz: AU au!
 Isso começa a entrar em outro conceito importantíssimo de POO: polimorfismo.
 
## 6 Pense desta maneira
A Classe abstrata funciona como um modelo incompleto.
              Animal
          CLASSE ABSTRATA
        ┌─────────────────┐
        │ nome            │
        │ dormir()        │
        │ emitirSom() ??? │
        └────────┬────────┘
                 │
              extends
        ┌────────┴────────┐
        ↓                 ↓

    Cachorro       Gato
  ┌─────────────┐    ┌─────────────┐
  │ dormir() ✓  │    │ dormir() ✓  │
  │             │    │             │
  │ emitirSom() │    │ emitirSom() │
  │ "Au au"     │    │ "Miau"      │
  └─────────────┘    └─────────────┘

A classe animal diz:
 	"Todos os meus filhos terão essas características."
Mas também pode dizer:
	"Esse comportamento eu ñ void definir. Cada filho precisa criar sua propria implementação."
Regra para você guardar
Classe abstrata
      ↓
não pode usar new diretamente

Animal a = new Animal(); ❌

      ↓
serve como classe-base

class Cachorro extends Animal

      ↓
a classe filha pode ser instanciada

Cachorro c = new Cachorro(); ✅

      ↓
e aproveita atributos/métodos
da classe abstrata
E tem um detalhe na frase que você usou^: não e exatamente que a classe abstrada "
só funciona quando for chamada". O mais correto seria dizer que ele é usada princi-
palmente através das classes que herdam dela.
























