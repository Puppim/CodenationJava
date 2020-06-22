package br.com.codenation.calculadora;

public class Principal {

    	public static void main(String[] args) {
		CalculadoraSalario liquido = new CalculadoraSalario();
		System.out.println(liquido.calcularSalarioLiquido(-949));
		System.out.println(liquido.calcularSalarioLiquido(1039.00));
	}
}
