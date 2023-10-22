package iiitd.harsh22199;

import java.util.InputMismatchException;
import java.util.Scanner;
//Admin Username --> admin
//Admin Password --> admin123
public class Admin extends Main{
    private static final String admin_username = "admin";
    private static final String admin_password = "admin123";
    static int attraction_count = 0;
    static Scanner sc = new Scanner(System.in);

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
                    Attraction.manage_attraction();
                } else if (selected_option==2){
                    Animal.manage_animals();
                } else if (selected_option==3){
                    Attraction.schedule_event();
                } else if (selected_option==4){
                    Discount.set_discounts();
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


    static void exit() {
        System.out.println("Logged out.");
        Main.start();
    }

    private static void view_feedback() {
        for (String s : Main.feedback) {
            System.out.println(s);
        }
    }

    private static void view_visitor_stats() {

    }

    private static void set_special_deals() {

//to be done
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
