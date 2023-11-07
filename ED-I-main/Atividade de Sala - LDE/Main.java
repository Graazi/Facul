import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        LDEChar lista = new LDEChar();
        LDEChar listaInvertida;
        String frase, fraseInversa;
        char vetor [];
        System.out.println("Digite uma frase: ");
        frase = in.nextLine();
        lista.preencherCom (frase);
        lista.exibir();
        listaInvertida = lista.criarCopiaInvertida();
        vetor = listaInvertida.listaToVetor();
        fraseInversa = new String (vetor);
        System.out.println("Frase inversa: " + fraseInversa);


    }
}
