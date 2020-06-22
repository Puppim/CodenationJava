package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-

		if (salarioBase < 1039.00) {
			return 0;
		}
		double inss = calcularInss(salarioBase);
		double irrf = calcularIrrf(inss);
		return Math.round(irrf);
	}


	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double salarioBase) {

		if( salarioBase>0 && salarioBase <= 1500.00){
			return salarioBase - salarioBase*0.08;
		}else if(salarioBase <= 4000.00){
			return salarioBase - salarioBase*0.09;
		}else{
			return salarioBase - salarioBase*0.11;
		}
	}

	private double calcularIrrf(double salarioInss ) {


		if(salarioInss > 0 && salarioInss <= 3000.00){
			return salarioInss;
		}else if(salarioInss <= 6000.00){
			return salarioInss-(salarioInss*0.075);
		}else{
			return salarioInss-(salarioInss*0.15);
		}

	}



}


/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/