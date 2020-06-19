package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {


	public static List<Integer> fibonacci() {

		List<Integer>  fibonacci = new ArrayList<>();
		fibonacci.add(0);
		int ante = 0;
		int prox = 1;
		int atual = 1;

		while(ante<=350){
			prox= ante+prox;
			fibonacci.add(atual);
			ante=atual;
			atual=prox;
		}
		return fibonacci;
	}



	public static Boolean isFibonacci(Integer a) {

		return fibonacci().contains(a);
	}

//	public static void main(String[] args) {
//		List<Integer> lista = fibonacci();
//		for (Integer ab: lista) {
//			System.out.println(ab);
//		}
//
//	}

}