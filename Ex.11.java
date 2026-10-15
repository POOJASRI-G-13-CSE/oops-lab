// BankApp.java

class InsufficientFundsException extends Exception {
    InsufficientFundsException(String message) {
        super(message);
    }
}

abstract class Account {
    private int accNo;              // encapsulation
    private String holder;
    protected double balance;

    Account(int accNo, String holder, double balance) {
        this.accNo = accNo;
        this.holder = holder;
        this.balance = balance;
    }

    void deposit(double amt) {
        if (amt <= 0) {
            throw new IllegalArgumentException("Invalid deposit amount");
        }
        balance += amt;
        System.out.println("Deposited Rs." + String.format("%.2f", amt)
                + " | Balance: Rs." + String.format("%.2f", balance));
    }

    abstract void withdraw(double amt) throws InsufficientFundsException;  // abstraction

    abstract double calculateInterest();

    void display() {
        System.out.println(getClass().getSimpleName() + " | Acc No: " + accNo
                + " | Holder: " + holder
                + " | Balance: Rs." + String.format("%.2f", balance));
    }
}

class SavingsAccount extends Account {          // inheritance
    private static final double MIN_BALANCE = 1000;
    private static final double RATE = 0.04;

    SavingsAccount(int accNo, String holder, double balance) {
        super(accNo, holder, balance);
    }

    @Override
    void withdraw(double amt) throws InsufficientFundsException {
        if (balance - amt < MIN_BALANCE) {
            throw new InsufficientFundsException("Minimum balance of Rs.1000 must be maintained");
        }
        balance -= amt;
        System.out.println("Withdrawn Rs." + String.format("%.2f", amt)
                + " | Balance: Rs." + String.format("%.2f", balance));
    }

    @Override
    double calculateInterest() {
        return balance * RATE;
    }
}

class CurrentAccount extends Account {
    private static final double OVERDRAFT = 5000;

    CurrentAccount(int accNo, String holder, double balance) {
        super(accNo, holder, balance);
    }

    @Override
    void withdraw(double amt) throws InsufficientFundsException {
        if (balance - amt < -OVERDRAFT) {
            throw new InsufficientFundsException("Overdraft limit exceeded");
        }
        balance -= amt;
        System.out.println("Withdrawn Rs." + String.format("%.2f", amt)
                + " | Balance: Rs." + String.format("%.2f", balance));
    }

    @Override
    double calculateInterest() {
        return 0;
    }
}

public class BankApp {
    public static void main(String[] args) {
        Account[] accounts = {                  // polymorphism
            new SavingsAccount(101, "Poojasri", 10000),
            new CurrentAccount(102, "Arun", 5000)
        };

        System.out.println("--- Account Details ---");
        for (Account a : accounts) {
            a.display();
        }

        System.out.println("\n--- Savings Account Transactions ---");
        try {
            accounts[0].deposit(2000);
            accounts[0].withdraw(3000);
            accounts[0].withdraw(9500);         // will fail
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }

        System.out.println("\n--- Current Account Transactions ---");
        try {
            accounts[1].withdraw(8000);
            accounts[1].withdraw(3000);         // will fail
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }

        System.out.println("\n--- Interest ---");
        for (Account a : accounts) {
            System.out.println(a.getClass().getSimpleName() + " interest: Rs."
                    + String.format("%.2f", a.calculateInterest()));
        }
    }
}