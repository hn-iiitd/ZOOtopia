package iiitd.harsh22199;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    //------attributes-------------------
    private static int mammal_count = 0;
    private static int reptile_count = 0;
    private static int  amphibian_count = 0;
    private static int ticket_count =1;

    private static int attraction_id_no = 1;
    private static int countOfPremiumMembers= 0 ;
    private static int countOfBasicMembers= 0 ;
    private static int visitor_count = 0;
    private static double revenue = 0;
    private static ArrayList<String> feedback = new ArrayList<>();
    private static ArrayList<Attraction> attractions = new ArrayList<>();
    private static ArrayList<Visitor> visitors_list = new ArrayList<>();
    private static HashMap<Integer, Attraction>  attraction_id_map = new HashMap<>();
    private static ArrayList<Animal> animalList = new ArrayList<>();
    private static HashMap<String,Discount> discountHashMap = new HashMap<>();
    private static HashMap<String ,String> visitor_info = new HashMap<>();
    private static boolean Deal1 = false;
    private static boolean Deal2 = false;
    static Scanner sc  = new Scanner(System.in);

    //---------setters and getters --------------------------------

    public static int getMammal_count() {
        return mammal_count;
    }

    public static void setMammal_count(int mammal_count) {
        Main.mammal_count = mammal_count;
    }

    public static int getReptile_count() {
        return reptile_count;
    }

    public static void setReptile_count(int reptile_count) {
        Main.reptile_count = reptile_count;
    }

    public static int getAmphibian_count() {
        return amphibian_count;
    }

    public static void setAmphibian_count(int amphibian_count) {
        Main.amphibian_count = amphibian_count;
    }

    public static int getTicket_count() {
        return ticket_count;
    }

    public static void setTicket_count(int ticket_count) {
        Main.ticket_count = ticket_count;
    }

    public static boolean isDeal1() {
        return Deal1;
    }

    public static void setDeal1(boolean deal1) {
        Deal1 = deal1;
    }

    public static int getAttraction_id_no() {
        return attraction_id_no;
    }

    public static void setAttraction_id_no(int attraction_id_no) {
        Main.attraction_id_no = attraction_id_no;
    }

    public static int getCountOfPremiumMembers() {
        return countOfPremiumMembers;
    }

    public static void setCountOfPremiumMembers(int countOfPremiumMembers) {
        Main.countOfPremiumMembers = countOfPremiumMembers;
    }

    public static int getCountOfBasicMembers() {
        return countOfBasicMembers;
    }

    public static void setCountOfBasicMembers(int countOfBasicMembers) {
        Main.countOfBasicMembers = countOfBasicMembers;
    }

    public static int getVisitor_count() {
        return visitor_count;
    }

    public static void setVisitor_count(int visitor_count) {
        Main.visitor_count = visitor_count;
    }

    public static double getRevenue() {
        return revenue;
    }

    public static void setRevenue(double revenue) {
        Main.revenue = revenue;
    }

    public static ArrayList<String> getFeedback() {
        return feedback;
    }

    public static void setFeedback(ArrayList<String> feedback) {
        Main.feedback = feedback;
    }

    public static ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    public static void setAttractions(ArrayList<Attraction> attractions) {
        Main.attractions = attractions;
    }

    public static ArrayList<Visitor> getVisitors_list() {
        return visitors_list;
    }

    public static void setVisitors_list(ArrayList<Visitor> visitors_list) {
        Main.visitors_list = visitors_list;
    }

    public static HashMap<Integer, Attraction> getAttraction_id_map() {
        return attraction_id_map;
    }

    public static void setAttraction_id_map(HashMap<Integer, Attraction> attraction_id_map) {
        Main.attraction_id_map = attraction_id_map;
    }

    public static ArrayList<Animal> getAnimalList() {
        return animalList;
    }

    public static void setAnimalList(ArrayList<Animal> animalList) {
        Main.animalList = animalList;
    }

    public static HashMap<String, Discount> getDiscountHashMap() {
        return discountHashMap;
    }

    public static void setDiscountHashMap(HashMap<String, Discount> discountHashMap) {
        Main.discountHashMap = discountHashMap;
    }

    public static HashMap<String, String> getVisitor_info() {
        return visitor_info;
    }

    public static void setVisitor_info(HashMap<String, String> visitor_info) {
        Main.visitor_info = visitor_info;
    }

    public static boolean isDeal2() {
        return Deal2;
    }

    public static void setDeal2(boolean deal2) {
        Deal2 = deal2;
    }



    public static void special_deals() {
        System.out.println("1.If a person buys more than 2 attractions, they get a special discount of 15% on the " +
                "total amount\n" +
                "2.If a person buys more than 3 attractions, they get a special discount of 30% on the " +
                "total amount");
        start();
    }
    public static void start() {
        System.out.println();
        System.out.println("1. Enter as Admin \n2. Enter as Visitor\n3. View Special Deals\n4. Exit");
        System.out.println();
        System.out.print("Enter your choice :  ");
        try{
            int selected_option = sc.nextInt();
            if(selected_option>4 || selected_option<1){
                throw new IncorrectOptionException("Please Enter a Valid Option");
            }
            else{
                if(selected_option == 1){
                    new Admin("admin","admin123");
                } else if (selected_option ==2) {
                    new Visitor(true);
                } else if(selected_option==3){
                    special_deals();
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
        System.out.println();
        System.out.println("Thanks for visiting ZOOtopia ! , Visit Again!");
        System.out.println();
    }

    public static void main(String[] args) {

        //by default special deals are turned on. You can turn it off using admin interface
        //adding default discount categories (can be modified or removed through admin interface) (can also add more discount categories through admin interface.)
        Discount d1 = new Discount("Minor",10,"MINOR10");
        Discount d2 = new Discount("Senior Citizen",20,"SENIOR20");
        discountHashMap.put("MINOR10",d1);
        discountHashMap.put("SENIOR20",d2);
        //added animals of two types each of reptile, amphibian and
        Animal Lion = new Mammal("Lion","Roar");Lion.setAnimal_facts("Lion is a Mammal");
        Animal Monkey = new Mammal("Monkey","Chatter");Monkey.setAnimal_facts("Monkey is a mammal");
        Animal Turtle = new Reptile("Turtle","crackles");Turtle.setAnimal_facts("Turtle is a Reptile" );
        Animal Crocodile = new Reptile("Crocodile","hiss");Crocodile.setAnimal_facts("Crocodile is a Reptile");
        Animal frog = new Amphibian("Frog","bonk");frog.setAnimal_facts("Frog is an Amphibian");
        Animal caecilians = new Amphibian("Caecilians","sssssssss");caecilians.setAnimal_facts("Caecelian is an Amphibian");
        animalList.add(Lion);animalList.add(Monkey);
        animalList.add(Crocodile); animalList.add(Turtle);
        animalList.add(frog);animalList.add(caecilians);
        //Adding two sample attractions (Can also be added through admin interface).
        Attraction a1 = new Attraction("Botanical Garden","ZOOtopia offers an adventure ride that allows you to explore unexplored trails. Buy your " +
                "ticket now!");a1.setEvent_price(15);
        Attraction a2 = new Attraction("Dinosaur Show","World's best show");a2.setEvent_price(12);
        Main.attractions.add(a1);Main.attractions.add(a2);
        Main.getAttraction_id_map().put(a1.getAttraction_id(),a1);
        Main.getAttraction_id_map().put(a2.getAttraction_id(),a2);
        System.out.println("Welcome to ZOOtopia!");
        System.out.println();
        start();
             }
    }
