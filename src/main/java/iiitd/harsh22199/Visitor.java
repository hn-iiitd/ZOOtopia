package iiitd.harsh22199;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Visitor {
    static Scanner sc  = new Scanner(System.in);
    Visitor(){
        signup();
    }

    private void signup() {
        System.out.println("""
                1. Register
                2. Login""");
        System.out.print("Enter your choice : ");
        try {
            int selected_option = sc.nextInt();
            if (selected_option < 1 || selected_option > 5) {
                throw new IncorrectOptionException("Invalid Option!");
            } else {
                if (selected_option == 1) {
                    register();
                } else if (selected_option == 2) {
                    login();
                }
            }

        }
        catch(IncorrectOptionException | InputMismatchException e){
                System.out.println("Invalid Option!");
            }
        }

    private void login() {

    }

    private void register() {
        
    }
}