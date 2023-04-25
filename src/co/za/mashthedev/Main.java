package co.za.mashthedev;

import java.util.Scanner;
class BankDetails {
    private String AccountNumber;
    private String name;
    private String TypeOfAccount;
    private long Bank_Balance;
    Scanner sc = new Scanner(System.in);
    //method to open new account
    public void openBankAccount() {
        System.out.print("Enter Account No: ");
        AccountNumber = sc.next();
        System.out.print("Enter Account type: ");
        TypeOfAccount = sc.next();
        System.out.print("Enter Name: ");
        name = sc.next();
        System.out.print("Enter Bank_Balance: ");
        Bank_Balance = sc.nextLong();
    }
    //method to display account details
    public void showAccount() {
        System.out.println("Name of account holder: " + name);
        System.out.println("Account no.: " + AccountNumber);
        System.out.println("Account type: " + TypeOfAccount);
        System.out.println("Bank_Balance: " + Bank_Balance);
    }
    //method to depositMoney money
    public void depositMoney() {
        long amt;
        System.out.println("Enter the amount you want to depositMoney: ");
        amt = sc.nextLong();
        Bank_Balance = Bank_Balance + amt;
    }
    //method to withdraw money
    public void withdrawMoney() {
        long amt;
        System.out.println("Enter the amount you want to withdraw: ");
        amt = sc.nextLong();
        if (Bank_Balance >= amt) {
            Bank_Balance = Bank_Balance - amt;
            System.out.println("Bank_Balance after withdrawMoney: " + Bank_Balance);
        } else {
            System.out.println("Your Bank_Balance is less than " + amt + "\tTransaction failed...!!" );
        }
    }
    //method to searchAccount an account number
    public boolean searchAccount(String ac_no) {
        if (AccountNumber.equals(ac_no)) {
            showAccount();
            return (true);
        }
        return (false);
    }
}
public class Main {

        public static void main(String arg[]) {
            Scanner sc = new Scanner(System.in);
            //create initial accounts
            System.out.print("How many number of customers do you want to input? ");
            int n = sc.nextInt();
            BankDetails C[] = new BankDetails[n];
            for (int i = 0; i < C.length; i++) {
                C[i] = new BankDetails();
                C[i].openBankAccount();
            }
            // loop runs until number 5 is not pressed to exit
            int ch;
            do {
                System.out.println("\n ***Banking System Application***");
                System.out.println("1. Display all account details \n 2. searchAccount by Account number\n 3. depositMoney the amount \n 4. Withdraw the amount \n 5.Exit ");
                System.out.println("Enter your choice: ");
                ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        for (int i = 0; i < C.length; i++) {
                            C[i].showAccount();
                        }
                        break;
                    case 2:
                        System.out.print("Enter account no. you want to searchAccount: ");
                        String ac_no = sc.next();
                        boolean found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].searchAccount(ac_no);
                            if (found) {
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("searchAccount failed! Account doesn't exist..!!");
                        }
                        break;
                    case 3:
                        System.out.print("Enter Account no. : ");
                        ac_no = sc.next();
                        found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].searchAccount(ac_no);
                            if (found) {
                                C[i].depositMoney();
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("searchAccount failed! Account doesn't exist..!!");
                        }
                        break;
                    case 4:
                        System.out.print("Enter Account No : ");
                        ac_no = sc.next();
                        found = false;
                        for (int i = 0; i < C.length; i++) {
                            found = C[i].searchAccount(ac_no);
                            if (found) {
                                C[i].withdrawMoney();
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("searchAccount failed! Account doesn't exist..!!");
                        }
                        break;
                    case 5:
                        System.out.println("See you soon...");
                        break;
                }
            }
            while (ch != 5);
        }
    }

