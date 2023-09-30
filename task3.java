import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;
class BankAccount {
    private double balance;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public String getName() {
        return name;
    public double getBalance() {
        return balance;
    }

    public int getRollNumber() {
        return rollNumber;
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public String getGrade() {
        return grade;
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
    private BankAccount bankAccount;

    public void setGrade(String grade) {
        this.grade = grade;
    public ATM(BankAccount account) {
        bankAccount = account;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    public void displayMenu() {
        System.out.println("ATM MENU");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();
    public void checkBalance() {
        System.out.println("Your balance is: $" + bankAccount.getBalance());
    }

    public void addStudent(Student student) {
        students.add(student);
    public void deposit(double amount) {
        if (amount > 0) {
            bankAccount.deposit(amount);
            System.out.println("Deposit of $" + amount + " successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    public void withdraw(double amount) {
        boolean success = bankAccount.withdraw(amount);
        if (success) {
            System.out.println("Withdrawal of $" + amount + " successful.");
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
}

public class ATMJava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Exiting ATM. Have a great day!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
