import java.util.Scanner;

public class Exec2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos numeros deseja ler?");
        int numRep = sc.nextInt();
        double [] vetor = new double[numRep];

        for (int i = 0; i < numRep; i++) {
            System.out.println("Digite um numero: ");
            int numDigitado = sc.nextInt();
                vetor[i]= numDigitado;
        }

        System.out.println("Numeros negativos: ");
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] < 0) {
                System.out.println(vetor[i]);
            }
        }
    }
}
