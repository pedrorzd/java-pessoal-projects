package App.Entities;

public class Account {
    private int accountNumber;
    private String holder;
    private double balance;

    public Account(int accountNumber, String holder){
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = 0;
    }

    public Account(int accountNumber, String holder, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        deposit(initialDeposit);
    }


    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= (amount + 5.0);
    }

    @Override
    public String toString() {
        return "Account number: " + getAccountNumber()
                +", Holder: " + getHolder()
                +", Balance: " + "$"
                + String.format("%.2f", balance);
    }
}
