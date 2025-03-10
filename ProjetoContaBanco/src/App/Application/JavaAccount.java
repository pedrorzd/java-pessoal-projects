package App.Application;

import App.Entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class JavaAccount {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Account account = null;

        System.out.print("Enter account number: ");
        int number = sc.nextInt();
        System.out.print("Enter account holder: ");
        sc.nextLine();
        String holder = sc.nextLine();
        System.out.print("Is there a initial depositValue? (y/n) ");
        char response = sc.next().charAt(0);
        if (response == 'n') {
            account = new Account(number, holder);
            return;
        } if (response == 'y') {
            System.out.println("Enter initial depositValue value: ");
            double initialDeposit = sc.nextDouble();
            account = new Account(number, holder, initialDeposit);
        }

        System.out.println();
        System.out.println("Account data: ");
        System.out.print(account);

        System.out.println();
        System.out.print("Enter a deposit value: ");
        double depositValue = sc.nextDouble();
        account.deposit(depositValue);
        System.out.println();

        System.out.println("Updated account data: ");
        System.out.print(account);

        System.out.println();
        System.out.print("Enter a withdraw value: ");
        double withdrawValue = sc.nextDouble();
        account.withdraw(withdrawValue);
        System.out.println();

        System.out.println("Updated account data: ");
        System.out.print(account);


        sc.close();
    }
}
