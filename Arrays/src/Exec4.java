import java.util.Locale;
import java.util.Scanner;

public class Exec4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.println("Quantas pessoas serão digitadas?");
        int numPessoas = sc.nextInt();
        String[] pessoa = new String[numPessoas];
        int [] idadePessoa = new int[numPessoas];
        double [] alturaPessoa = new double[numPessoas];

        for (int i = 0; i < numPessoas; i++) {
            System.out.println("Digite o nome da "+ (i+1) +"º pessoa: ");
            System.out.print("Nome: ");
            pessoa[i] = sc.next();
            System.out.print("Idade: ");
            idadePessoa[i] = sc.nextInt();
            System.out.print("Altura: ");
            alturaPessoa[i] = sc.nextDouble();
            System.out.println();
        }
        double alturaTotal = 0;
        for (int i = 0; i < numPessoas; i++) {
            alturaTotal += alturaPessoa[i];
        }
        double alturaMedia = alturaTotal / numPessoas;
        System.out.println("A altura média das pessoas citadas é: "+alturaMedia);

        int idade = 0;

        for (int i = 0; i < numPessoas; i++) {
            if (idadePessoa[i] < 16) {
                idade++;
            }
        }

        double porcentagem = (100.0 / idade);
        System.out.printf("Pessoas com menos de 16 anos de idade: %.2f%%\n", porcentagem);



        String [] pessoasMenoresDezesseis = new String[idade];
        for (int i = 0; i < numPessoas; i++) {
            pessoasMenoresDezesseis[i] = pessoa[i];
        }

        for (int i = 0; i < numPessoas; i++) {
            System.out.println(pessoasMenoresDezesseis[i]);
        }

        sc.close();
    }
}
