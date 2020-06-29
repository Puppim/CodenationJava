package br.com.codenation;

import java.util.*;

public class StatisticUtil {

	public static int average(int[] elements) {
		int soma=0;
		int elementos = elements.length;
		for( int i: elements){
			soma=soma+i;
		}
		return soma/elementos;
	}

	public static int mode(int[] elements) {
		List<ElementsModa> elementsModas = new ArrayList<>();
		for( int i: elements){
			elementsModas.add(new ElementsModa(i,1));
		}
		for(ElementsModa ele: elementsModas){
			for( int i: elements){
				if(ele.element==i){
					ele.quantity= ele.quantity+1;
				}
			}

		}
		elementsModas.sort(Comparator.comparingInt(ElementsModa::getQuantity).reversed());

		return elementsModas.get(0).getElement();
	}

	public static int median(int[] elements) {

		List<Integer> elementsMedian = new ArrayList<>();
		for (Integer ele: elements) {
			elementsMedian.add(ele);
		}
		elementsMedian.sort(Integer::compareTo);
		System.out.println(elementsMedian);
		int quantity = elements.length;
		int posicao;
		if(quantity%2==0){
			return (elementsMedian.get((quantity-1)/2)+elementsMedian.get((quantity)/2))/2;
		}
		if(!(quantity%2==0)){
			posicao = (quantity)/2;
			return elementsMedian.get(posicao);
		}

		return 0;
	}
}