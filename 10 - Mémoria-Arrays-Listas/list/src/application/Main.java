package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// List list = new List(); //Interrface

		/*
		 * TAMANHO DA LIST : size(); INSERIR ELEMENTO NA lista: remove(obj),
		 * remove(int), removeIf(Predicate) ENCONTRA POSIÇÃO DE ELEMENTO: indexOf(obj),
		 * listIndexOf(obj) FILTRAR lista COM BASE EM PREDICADO: List<Integer> result =
		 * list.stream().filter(x -> x > 4).collectors.toList()); ENCONTRAR PRIMEIRO
		 * OCORRÊNCIA COM BASE EM PREDICADO: Interger result = list.stream().filter(x ->
		 * x > 4).findFirst().orElse(null);
		 */
		// quero declara números inteiro na List
		List<String> list = new ArrayList<>(); // Com interface Array;
		list.add("Maria");
		list.add("Thiago");
		list.add("Thalia");
		list.add("Aline");
		list.add("Mateus");

		// Quero add outro nome na minha posição 2
		list.add(2, "Viado");

		// Quuro ver o tamanho da lista
		System.out.println(list.size());

		// Quero remover 'Viado' da minha lista
		list.remove("Viado");

		// remove por posição 0 1 2 3 4 5
		list.remove(0);

		for (String x : list) {
			System.out.println(x);
		}

		System.out.println("-----------------------------------");
		// Quero remover agora pelo 'nome tem T', temos que usar um predicado.
		list.removeIf(x -> x.charAt(0) == 'V');
		for (String x : list) {
			System.out.println(x);
		}
		System.out.println("-----------------------------------");
		// Quero encontra aposição do elemento indexOf
		System.out.println("index of Thiago: " + list.indexOf("Thiago"));

		// Quero encontra aposição não tem na lista seria o nome dessa pessoa
		System.out.println("index of Thais: " + list.indexOf("thais"));
		
		// Quero filtar a minha lista começa com 'T'.
		System.out.println("-----------------------------------");
		List<String> result = list.stream().filter(x -> x.charAt(0) == 'T').collect(Collectors.toList());
		for (String x : result) {
			System.out.println(x);
		}
		System.out.println("-----------------------------------");
		// Quero pgar o primeiro nome que começã com a letra 'M'
		String nome = list.stream().filter(x -> x.charAt(0) == 'M').findFirst().orElse(null);
		System.out.println(nome);
		
		String nomeT = list.stream().filter(x -> x.charAt(0) == 'H').findFirst().orElse(null);
		System.out.println(nomeT);
	}

}
