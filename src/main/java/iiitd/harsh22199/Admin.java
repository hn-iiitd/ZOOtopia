package iiitd.harsh22199;

import java.util.InputMismatchException;
import java.util.Scanner;
//Admin Username --> admin
//Admin Password --> admin123
public class Admin extends Main{
    private static final String admin_username = "admin";

    private static final String admin_password = "admin123";
    private static int attraction_count = 0;

    //------------------------Setters Getters ---------------------------------
    public static String getAdmin_password() {
        return admin_password;
    }

    public static String getAdmin_username() {
        return admin_username;
    }
    public static int getAttraction_count() {
        return attraction_count;
    }

    public static void setAttraction_count(int attraction_count) {
        Admin.attraction_count = attraction_count;
    }
    //-----------------------Setter Getter end -----------------------------------
    static Scanner sc = new Scanner(System.in);

    public static void admin_menu() { // Menu for admin
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
                    Attraction.manage_attraction();
                } else if (selected_option==2){
                    manage_animals();
                } else if (selected_option==3){
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


    static void exit() { //method used for admin logout
        System.out.println("Logged out.");
        System.out.println();
        Main.start();
    }
    //Animal Classes
    static void manage_animals() { //method used for manage animals
        System.out.println();
        System.out.println("""
                Manage Animals:
                1. Add Animal
                2. Update Animal Details
                3. Remove Animal
                4. Exit""");
        System.out.println();
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

                admin_menu();

            }
        }
        catch (IncorrectOptionException | InputMismatchException e){
            System.out.println("Please Enter a valid option !");
            sc.nextLine();
            manage_animals();
        }
    }

    private static void remove_animal() { //method used to remove animal
        System.out.println("Remove Animals: ");
        for(int i = 0 ; i<Main.getAnimalList().size();i++){
            System.out.println(i+1 + ". "+Main.getAnimalList().get(i).getName());

        }
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        if(choice>0 && choice<Main.getAnimalList().size()){
            if(((Main.getAnimalList().get(choice-1).getClass().equals(Mammal.class)) && Main.getMammal_count()==2) || ((Main.getAnimalList().get(choice-1).getClass() == Amphibian.class ) && Main.getAmphibian_count()==2) || ((Main.getAnimalList().get(choice-1).getClass()== Reptile.class) && Main.getReptile_count()==2)){
                System.out.println("Animal can't be removed because " + Main.getAnimalList().get(choice-1).getClass()  + " category only have 2 animals ");
            }
            else{
                if(Main.getAnimalList().get(choice-1).getClass() == Mammal.class){
                    Main.setMammal_count(Main.getMammal_count()-1);
                }else if(Main.getAnimalList().get(choice-1).getClass() == Reptile.class){
                    Main.setReptile_count(Main.getReptile_count()-1);
                }else if(Main.getAnimalList().get(choice-1).getClass() == Amphibian.class){
                    Main.setAmphibian_count(Main.getAmphibian_count()-1);
                }
                Main.getAnimalList().remove(choice-1);
                System.out.println("Animal removed Successfully");
            }

        }
        else{
            System.out.println("Invalid input.");
        }
        admin_menu();

    }

    private static void update_animal_details() { // method used to update animal details
        System.out.println("Update Animals: ");
        for(int i = 0 ; i<Main.getAnimalList().size();i++){
            System.out.println(i+1 + ". "+Main.getAnimalList().get(i).getName());

        }
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        if(choice>Main.getAnimalList().size()){
            System.out.println("Invalid choice of animal!");
        }
        else{
            System.out.println("1. Change Animal Details ");
            System.out.println("2. Change Sound");
            System.out.println("3. Change Name");
            System.out.print("Enter your choice: ");
            int c  = sc.nextInt();

            if(c==1){
                System.out.print("Enter new Animal Details: ");
                sc.nextLine();
                Main.getAnimalList().get(choice-1).setAnimal_facts(sc.nextLine());
                System.out.println("Details updated");
            }
            else if(c==2){
                System.out.print("Enter new sound: ");

                Main.getAnimalList().get(choice-1).setSound(sc.next());
                System.out.println("Animal Sound updated");
            }
            else if(c==3){
                System.out.print("Enter new Name: ");
                Main.getAnimalList().get(choice-1).setName(sc.next());
                System.out.println("Animal Name updated.");
            }
            else{
                System.out.println("Invalid Input!");
            }}
        admin_menu();
    }

    private static void add_animals() { // method used to add animals
        System.out.println();
        System.out.println("Add Animal: ");
        System.out.println();
        System.out.print("Enter Animal Name: ");
        sc.nextLine();
        String animalName = sc.nextLine();
        System.out.print("Enter Animal Type: (Mammals, Amphibians, Reptiles) : ");
        String Animal_Type = sc.next();

        if(Animal_Type.equalsIgnoreCase("Mammals") || Animal_Type.equalsIgnoreCase("mammal")||Animal_Type.equalsIgnoreCase("Reptiles")||Animal_Type.equalsIgnoreCase("reptile")|| Animal_Type.equalsIgnoreCase("Amphibians") || Animal_Type.equalsIgnoreCase("amphibian")) {
            sc.nextLine();
            System.out.print("Enter Animal Sound : ");
            String Animal_Sound = sc.nextLine();
            if (Animal_Type.equalsIgnoreCase("Mammals") || Animal_Type.equalsIgnoreCase("mammal")) {
                Animal m1 = new Mammal(animalName,Animal_Sound);
                Main.getAnimalList().add(m1);

            } else if (Animal_Type.equalsIgnoreCase("Reptiles")|| Animal_Type.equalsIgnoreCase("reptile")) {
                Animal m1 = new Reptile(animalName,Animal_Sound);

                Main.getAnimalList().add(m1);
            } else if (Animal_Type.equalsIgnoreCase("Amphibians")|| Animal_Type.equalsIgnoreCase("amphibian")) {
                Animal m1 = new Amphibian(animalName,Animal_Sound);

                Main.getAnimalList().add(m1);
            }
            System.out.println("Animal added to Zoo.");
        }
        else{
            System.out.println("Animal of type : " + Animal_Type+ " can't be added!");
        }


    }


    private static void view_feedback() { //method used to view feedback

        System.out.println("Feedback: ");
        for (String s : Main.getFeedback()) {
            System.out.println(s);
        }
        admin_menu();
    }

    private static void view_visitor_stats() { //method used to view visitor statistics
        System.out.println();
        System.out.println("Visitor Statistics: ");
        System.out.println("- Total Visitors: " + (Main.getCountOfPremiumMembers() + Main.getCountOfBasicMembers()));
        System.out.println("- Total Revenue: " + Main.getRevenue());
        System.out.println("- Most Popular Attraction:  " + extract_most_popular());
        admin_menu();
    }

    private static String extract_most_popular() { //method used to extract most popular
        String popular_event = "";
        int maxi = -1;
        for(int i = 0; i< Main.getAttractions().size() ; i++){
            if(Main.getAttractions().get(i).getCountOfvisitors() > maxi){
                popular_event = Main.getAttractions().get(i).getEvent_name();
                maxi = Main.getAttractions().get(i).getCountOfvisitors();
            }
        }
        return popular_event;
    }

    private static void set_special_deals() { //method to set special deals
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
                Main.setDeal1(true);
                System.out.println("Deal 1 is turned on Successfully!");
            }else if(choice==2){
                Main.setDeal2(true);
                System.out.println("Deal 2 is turned on Successfully!");
            }else if(choice==3){
                Main.setDeal1(false);
                System.out.println("Deal 1 is turned off Successfully!");
            }else {
                Main.setDeal2(false);
                System.out.println("Deal 2 is turned off Successfully!");
            }

        }
        admin_menu();


    }



    public static void admin_login() { // method used for admin login
        System.out.println();
        System.out.println("Welcome Admin : ");
        System.out.println();
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

    public static boolean admin_login_details_check(String Username, String Password) {  // method used for checking admin login details
        return Username.equals(getAdmin_username()) && Password.equals(getAdmin_password());
    }
    Admin(String username){
        admin_login();
    }
    Admin(){

    }


}
