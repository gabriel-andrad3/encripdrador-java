package com.encripdrador;

import java.util.Scanner;

public class Application {
    public static void main (String[] args) {
        Encripdrador encripdrador = new Encripdrador();

        Scanner keyboard = new Scanner(System.in);
        char action;
        do {
            System.out.println("\nDo you want to encrypt (e) or decrypt (d) your password?");
            action = keyboard.next().charAt(0);
        } while (action != 'e' && action != 'd');

        System.out.println("Input your pwd:");
        String pwd = keyboard.next();
        encripdrador.setOldPwd(pwd);

        if (action == 'e') {
            encripdrador.setNewPwd(encripdrador.encripdrar());
            System.out.println("\n--- encrypted pwd --- \n\t" + encripdrador.getNewPwd() + "\n---------------------");
        }
        else {  // action == 'd'
            encripdrador.setNewPwd(encripdrador.decripdrar());
            System.out.println("\n--- decrypted pwd --- \n\t" + encripdrador.getNewPwd() + "\n---------------------");
        }

    }
}
