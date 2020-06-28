package challenge;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Principal {

//    public static int quantosSenior(Queue<Carro> estacionados){
//        int count=0;
//        while(estacionados.peek().getMotorista().getIdade()>55){
//            count=count+1;
//            estacionados.poll();
//        }
//        return count;
//    }

    public static void main(String[] args) {
//        Estacionamento est = new Estacionamento();
//
//        for(int i = 0 ; i<10 ; i++){
        Motorista ada = Motorista.builder().withNome("Ada").withIdade(56)
                .withPontos(3)
                .withHabilitacao("1231")
                .build();
        Motorista ada2 = Motorista.builder().withNome("Ada").withIdade(56)
                .withPontos(3)
                .withHabilitacao("1231")
                .build();

        Carro carroBranco = Carro.builder().withCor(Cor.BRANCO).
                withPlaca("123")
                .withMotorista(ada)
                .build();
        Carro carroPreto = Carro.builder().withCor(Cor.BRANCO).
                withPlaca("123")
                .withMotorista(ada2)
                .build();

//            est.estacionar(carroBranco);


        Queue<Carro> estacionados = new LinkedList<Carro>();
        estacionados.add(carroBranco);
        estacionados.add(carroBranco);
        estacionados.add(carroBranco);
        estacionados.add(carroBranco);



        //access via Iterator

        Queue<Carro> novoestacionados = new LinkedList<Carro>();
        novoestacionados=estacionados;
            for(Carro car : estacionados) {
                if(car.getMotorista().getIdade()>55){
                    estacionados.remove(car);
                }
            }


        System.out.println(estacionados.size());

//        if (!estacionados.isEmpty())
//        {
//            Iterator<Carro> iterator = estacionados.iterator();
//
//            while (iterator.hasNext()&&estacionados.peek().getMotorista().getIdade()>55)
//            {
//                Particle particle = (Particle)iterator.next();
//                this.tickParticle(particle);
//
//                if (!particle.isAlive())
//                {
//                    iterator.remove();
//                }
//            }
//        }
//        int tam = estacionados.size();
//        if(estacionados.peek().getMotorista().getIdade() > 55){
//
////            for(Carro c: estacionados){
////                estacionados.poll();
////
////                System.out.println(estacionados.size());
////                if(estacionados.peek().getMotorista().getIdade() <= 55){
////                 break;
////                }
////            }
////            estacionados.poll();
//            System.out.println(estacionados.size());
//        }

        for (Carro carroEstacionado: estacionados){
            if(carroEstacionado == carroBranco){
                System.out.println("truessss");
            }else {
                System.out.println("false");
            }
        }

        System.out.println(estacionados.contains(carroPreto));
//        estacionados.poll();
        System.out.println(estacionados.size());
    }




//
//        System.out.println(est.carrosEstacionados());




}
