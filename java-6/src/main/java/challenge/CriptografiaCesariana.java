package challenge;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {
        if (texto.isEmpty() || texto == null) {
            throw new IllegalArgumentException("Texto inválido");
        }else {
//        throw new UnsupportedOperationException("esse method nao esta implementado aainda");
            texto = texto.toLowerCase();
            String alfabeto = "abcdefghijklmnopqrstuvwxyz";
            String newText = "";
            char c;
            int n, posicao;
            n = texto.length();
            for (int i = 0; i < n; i++) {
                c = texto.charAt(i);
                posicao = alfabeto.indexOf(c);
                if (posicao == -1) {
                    newText = newText + c;
                } else if (posicao < alfabeto.length() - 3) {
                    newText = newText + alfabeto.charAt(posicao + 3);
                } else {
                    posicao = (posicao + 3) - alfabeto.length();
                    newText = newText + alfabeto.charAt(posicao);
                }
            }

            return newText;
        }

    }


    @Override
    public String descriptografar(String texto) {
        if (texto.isEmpty() || texto == null) {
            throw new IllegalArgumentException("Texto inválido");
        }else {
           String alfabeto = "abcdefghijklmnopqrstuvwxyz";
           texto = texto.toLowerCase();
           String newText = "";
           char c;
           int cry = 3;
           int n, posicao;
           int alfLength = alfabeto.length();
           n = texto.length();
           for (int i = 0; i < n; i++) {
               c = texto.charAt(i);
//            System.out.println(c);
               posicao = alfabeto.indexOf(c);
               if (posicao == -1) {
//                System.out.println(c);
                   newText = newText + c;
               } else if (posicao >= cry) {
//                System.out.print(alfabeto.charAt(posicao+3));
                   newText = newText + alfabeto.charAt(posicao - 3);
               } else {
                   posicao = alfLength + (posicao - cry);
                   newText = newText + alfabeto.charAt(posicao);
               }

           }

           return newText;
       }
    }

}
