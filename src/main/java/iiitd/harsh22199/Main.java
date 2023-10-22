package iiitd.harsh22199;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    protected static int visitor_count = 0;
    protected static int revenue = 0;
    protected static ArrayList<String> feedback = new ArrayList<>();
    protected static ArrayList<Attraction> attractions = new ArrayList<>();
    protected static ArrayList<Visitor> visitors_list = new ArrayList<>();
    protected static HashMap<Integer, Attraction>  attraction_id_map = new HashMap<>();
    protected static ArrayList<Animal> animalList = new ArrayList<>();
    protected static HashMap<String,Discount> discountHashMap = new HashMap<>();
    protected static HashMap<String ,String> visitor_info = new HashMap<>();

    static Scanner sc  = new Scanner(System.in);

    public static void special_details() {

    }
    public static void start() {
        System.out.println("1. Enter as Admin \n2. Enter as Visitor\n3. View Special Details\n4. Exit");
        System.out.print("Enter your choice :  ");
        try{
            int selected_option = sc.nextInt();
            if(selected_option>4 || selected_option<1){
                throw new IncorrectOptionException("Please Enter a Valid Option");
            }
            else{
                if(selected_option == 1){
                    new Admin();
                } else if (selected_option ==2) {
                    new Visitor();
                } else if(selected_option==3){
                    special_details();
                }
                else{
                    exit();
                }
            }
        }
        catch(InputMismatchException | IncorrectOptionException e){
            System.out.println(" Please Enter a Valid Option ");
            sc.nextLine();
            start();
        }
    }

    private static void exit() {
        System.out.println("Thanks for visiting ZOOtopia ! , Visit Again!");
        return;
    }

    public static void main(String[] args) {
        //adding default discount categories (can be modified or removed through admin interface) (can also add more discount categories through admin interface.)
        Discount d1 = new Discount("Minor",10,"MINOR10");
        Discount d2 = new Discount("Senior Citizen",20,"SENIOR20");
        discountHashMap.put("MINOR10",d1);
        discountHashMap.put("SENIOR20",d2);
        //added animals of two types each of reptile, amphibian and
        Animal Lion = new Mammal("Lion");
        Lion.setAnimal_facts("Lion is a Mammal");Lion.setSound("Roar");
        Animal Monkey = new Mammal("Monkey");
        Monkey.setAnimal_facts("Monkey is a mammal");Monkey.setSound("chatter");
        Animal Turtle = new Reptile("Turtle");
        Turtle.setAnimal_facts("Turtle is a Reptile" );Turtle.setSound("crackles");
        Animal Crocodile = new Reptile("Crocodile");
        Crocodile.setSound("hiss"); Crocodile.setAnimal_facts("Crocodile is a Reptile");
        Animal frog = new Amphibian("Frog");
        frog.setSound("bonk"); frog.setAnimal_facts("Frog is an Amphibian");
        Animal caecilians = new Amphibian("Caecilians");
        caecilians.setSound("sssss");caecilians.setAnimal_facts("Caecelian is an Amphibian");
        start();
             }
    }
