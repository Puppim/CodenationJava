package challenge;
import java.util.LinkedList;
import java.util.ArrayDeque;

public class Estacionamento {

    private ArrayDeque<Carro> estacionados = new ArrayDeque<Carro>(10);

    public void estacionar(Carro carro) {


      if(!requisitos(carro)){
          throw new EstacionamentoException("Nao pode estacionar");
      }
      if(estacionados.size()>=10) {
          for (Carro car: estacionados){
              if(car.getMotorista().getIdade()<55){
                  estacionados.remove(car);
                  break;
              }
          }
          if(estacionados.size()==9){
              estacionados.add(carro);
          }else {
              throw new EstacionamentoException("Sem vaga.");
          }
      }
      if (estacionados.size() < 10) {
          estacionados.add(carro);
        }

    }


    public boolean requisitos(Carro carro){
        if(carro.getMotorista()==null){
            throw new EstacionamentoException("Carro nao pode ser autonomo!");
        }
        else if(carro.getMotorista().getPontos()>20){
            throw new EstacionamentoException("Motorista sem pontos!");
        }else if(carro.getMotorista().getIdade()<19){
            throw new EstacionamentoException("Motorista nao pode ser menor de idade!");
        }else if(carro.getCor().toString()==null){
            return false;
        }

        return true;
    }

    public int carrosEstacionados() {
        return estacionados.size();
    }

    public boolean carroEstacionado(Carro carro) {

        return estacionados.contains(carro);
    }
}
