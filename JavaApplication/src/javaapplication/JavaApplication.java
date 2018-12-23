package javaapplication;

import java.util.Scanner;

public class JavaApplication {

    public static void main(String[] args) {
        ATM atm = new ATM();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter an amount");     
        while (sc.hasNextInt()) {
            Integer amount = sc.nextInt();
            atm.withdraw(amount);
            System.out.println("Please enter an amount");
        }
    }
}
