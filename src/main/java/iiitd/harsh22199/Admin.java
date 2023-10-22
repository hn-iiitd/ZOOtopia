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
        System.out.println();
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
        System.out.println();
        System.out.print("Enter your choice: ");


        try {
            int selected_option = sc.nextInt();
            if (selected_option < 1 || selected_option > 8) {
                throw new IncorrectOptionException("Invalid Option Selected");
            } else {
                if (selected_option==1){
                    System.out.println();
                    Attraction.manage_attraction();
                } else if (selected_option==2){
                    System.out.println();
                    Animal.manage_animals();
                } else if (selected_option==3){
                    System.out.println();
                    Attraction.schedule_event();
                } else if (selected_option==4){
                    System.out.println();
                    Discount.set_discounts();
                } else if (selected_option==5){
                    System.out.println();
                    set_special_deals();
                } else if (selected_option==6){
                    System.out.println();
                    view_visitor_stats();
                } else if (selected_option==7){
                    System.out.println();
                    view_feedback();
                } else{
                    System.out.println();
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
        System.out.println("Feedback: ");
        for (String s : Main.feedback) {
            System.out.println(s);
        }
        admin_menu();
    }

    private static void view_visitor_stats() {
        System.out.println("- Total Visitors: " + Main.visitor_count);
        System.out.println("- Total Revenue: " + Main.revenue);
        System.out.println("- Most Popular Attraction:  " + extract_most_popular());
        admin_menu();
    }

    private static String extract_most_popular() {
        String popular_event = "";
        int maxi = -1;
        for(int i = 0 ; i<Main.attractions.size() ; i++){
            if(Main.attractions.get(i).getCountOfvisitors() > maxi){
                popular_event = Main.attractions.get(i).getEvent_name();
                maxi = Main.attractions.get(i).getCountOfvisitors();
            }
        }
        return popular_event;
    }

    private static void set_special_deals() {
        System.out.println("Set Special Deal :");
        System.out.println("1. " +
                "If a person buys more than 2 attractions, they get a special discount of 15% on the " +
                "total amount. \n" +
                "2. If a person buys more than 3 attractions, they get a special discount of 30% on the " +
                "total amount." );
        System.out.println("1.Turn On Deal 1.");
        System.out.println("2.Turn On Deal 2.");
        System.out.println("3.Turn Off Deal 1.");
        System.out.println("4.Turn Off Deal 2.");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        if(choice>4||choice<1){
            System.out.println("Invalid input!");
        }
        else{
            if(choice==1){
                Main.Deal1 = true;
                System.out.println("Deal 1 is turned on Successfully!");
            }else if(choice==2){
                Main.Deal2 = true;
                System.out.println("Deal 2 is turned on Successfully!");
            }else if(choice==3){
                Main.Deal1 = false;
                System.out.println("Deal 1 is turned off Successfully!");
            }else {
                Main.Deal2 = false;
                System.out.println("Deal 2 is turned off Successfully!");
            }

        }
        admin_menu();


    }



    public static void admin_login() {
        System.out.println("Welcome Admin : ");
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
    Admin(String username){
        admin_login();
    }
    Admin(){

    }

    public static String getAdmin_password() {
        return admin_password;
    }

    public static String getAdmin_username() {
        return admin_username;
    }
}
