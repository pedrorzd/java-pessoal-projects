import java.util.Locale;
import java.util.Scanner;

public class Exec3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.println("Digite a quantidade de numeros: ");
        int num = sc.nextInt();
        double soma = 0;
        double []numeros = new double[num];

        for (int i = 0; i < num; i++) {
            System.out.println("Digite um numero: ");
            numeros[i] = sc.nextInt();
        }

        for (int i = 0; i < num; i++) {
            System.out.print(numeros[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < num; i++) {
            soma += numeros[i];
        }

        System.out.println("A soma dos numeros é: " + soma);
        System.out.println("A média dos numeros é: " + soma/num);

        sc.close();

    }
}
