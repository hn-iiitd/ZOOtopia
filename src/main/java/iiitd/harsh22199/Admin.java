package iiitd.harsh22199;

import java.util.InputMismatchException;
import java.util.Scanner;
//Admin Username --> admin
//Admin Password --> admin123
public class Admin {
    private static final String admin_username = "admin";
    private static final String admin_password = "admin123";
    static Scanner sc = new Scanner(System.in);
    private static void manage_attraction(){
        System.out.println("Manage Attractions:");
        System.out.println("""
                1. Add Attraction
                2. View Attractions
                3. Modify Attraction
                4. Remove Attraction
                5. Exit""");
        System.out.print("Enter your choice: ");
        try {
            int selected_option = sc.nextInt();
            if(selected_option<1 || selected_option>5){
                throw new IncorrectOptionException("Invalid Option");
            }
            else{
                if(selected_option ==1){
                    add_attraction();
                    admin_menu();
                }
                else if(selected_option==2){
                    view_attraction();
                    admin_menu();
                }
                else if(selected_option==3){
                    modify_attraction();
                    admin_menu();
                }
                else if(selected_option==4){
                    remove_attraction();
                    admin_menu();
                }
                else{
                    exit();
                }

            }
        }
        catch (IncorrectOptionException | InputMismatchException e){
            System.out.println("Invalid Option Selected! ");
            sc.nextLine();
            manage_attraction();
        }
    }

    private static void remove_attraction() {
    }

    private static void modify_attraction() {
    }

    private static void view_attraction() {
    }

    private static void add_attraction() {
    }

    public static void admin_menu() {
        System.out.println("Admin Menu:");
        System.out.println("""
                1. Manage Attractions
                2. Manage Animals
                3. Schedule Events
                4. Set Discounts
                5. Set Special Deal
                6. View Visitor Stats
                7. View Feedback
                8. Exit""");
        System.out.print("Enter your choice: ");


        try {
            int selected_option = sc.nextInt();
            if (selected_option < 1 || selected_option > 8) {
                throw new IncorrectOptionException("Invalid Option Selected");
            } else {
                if (selected_option==1){
                    manage_attraction();
                } else if (selected_option==2){
                    manage_animals();
                } else if (selected_option==3){
                    schedule_events();
                } else if (selected_option==4){
                    set_discounts();
                } else if (selected_option==5){
                    set_special_deals();
                } else if (selected_option==6){
                    view_visitor_stats();
                } else if (selected_option==7){
                    view_feedback();
                } else{
                    exit();
                }
            }
        } catch (IncorrectOptionException  | InputMismatchException e){
            System.out.println("Invalid Option Selected");
            sc.nextLine();
            admin_menu();
        }

    }

    private static void exit() {
        System.out.println("Logged out.");
        Main.start();
    }

    private static void view_feedback() {

    }

    private static void view_visitor_stats() {
    }

    private static void set_special_deals() {
    }

    private static void set_discounts() {
        System.out.println("""
                Set Discounts:
                1. Add Discount
                2. Modify Discount
                3. Remove Discount
                4. Exit""");
        System.out.print("Enter your choice : ");
        try {
            int selected_option = sc.nextInt();
            if (selected_option < 1 || selected_option > 8) {
                throw new IncorrectOptionException("Invalid Option Selected");
            } else {
                if (selected_option==1){
                    add_discount();
                } else if (selected_option==2){
                    modify_discount();
                } else if (selected_option==3){
                    remove_discount();

                } else{
                    exit();
                }
            }
        } catch (IncorrectOptionException  | InputMismatchException e){
            System.out.println("Invalid Option Selected");
            sc.nextLine();
            admin_menu();
        }
    }

    private static void remove_discount() {
    }

    private static void modify_discount() {
    }

    private static void add_discount() {
    }


    private static void schedule_events() {
    }

    private static void manage_animals() {
        System.out.println("""
                Manage Animals:
                1. Add Animal
                2. Update Animal Details
                3. Remove Animal
                4. Exit""");
        System.out.print("Enter your choice : ");
        try {
            int selected_option = sc.nextInt();
            if(selected_option<1 || selected_option>4){
                throw new IncorrectOptionException("Invalid Option");
            }
            else{
                if(selected_option==1){
                    add_animals();
                }
                else if(selected_option==2){
                    update_animal_details();
                }
                else if(selected_option==3){
                    remove_animal();
                }
                else {
                    exit();
                }
            }
        }
        catch (IncorrectOptionException | InputMismatchException e){
            System.out.println("Please Enter a valid option !");
            sc.nextLine();
            manage_animals();
        }
    }

    private static void remove_animal() {

    }

    private static void update_animal_details() {
    }

    private static void add_animals() {
    }

    public static void admin_login() {
        System.out.print("Enter Admin Username: ");
        String admin_username = sc.next();
        System.out.print("Enter Admin Password: ");
        String admin_password = sc.next();
        if(admin_login_details_check(admin_username,admin_password)){
            System.out.println("Logged in as Admin.");
            admin_menu();
        }
        else{
            System.out.println("Incorrect Username or Password");

            Main.start();
        }
    }

    public static boolean admin_login_details_check(String Username, String Password) {
        return Username.contentEquals(getAdmin_username()) && Password.contentEquals(getAdmin_password());
    }
    Admin(){
        admin_login();
    }

    public static String getAdmin_password() {
        return admin_password;
    }

    public static String getAdmin_username() {
        return admin_username;
    }
}
