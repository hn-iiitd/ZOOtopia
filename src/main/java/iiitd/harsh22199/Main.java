package iiitd.harsh22199;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    protected static ArrayList<String> feedback = new ArrayList<>();
    protected static ArrayList<Attraction> attractions = new ArrayList<Attraction>();
    protected static ArrayList<Visitor> visitors_list = new ArrayList<Visitor>();

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
            start();
             }
    }
