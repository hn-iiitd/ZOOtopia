package iiitd.harsh22199;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Animal extends Admin{
    static Scanner sc= new Scanner(System.in);
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getAnimal_facts() {
        return animal_facts;
    }

    public void setAnimal_facts(String animal_facts) {
        this.animal_facts = animal_facts;
    }

    private String sound;
    private String animal_facts;

    public void feed() {
        System.out.println(this.sound);
    }
    public void read(){
        System.out.println(this.animal_facts);
    }
    static void manage_animals() {
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
                    Admin.admin_menu();
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
        System.out.println("Remove Animals: ");
        for(int i = 0 ; i<Main.animalList.size();i++){
            System.out.println(i+1 + ". "+Main.animalList.get(i).getName());

        }
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        if(choice>0 && choice<Main.animalList.size()){
            Main.animalList.remove(choice-1);
            System.out.println("Animal removed Successfully");
        }
        else{
            System.out.println("Invalid input.");
        }
        Admin.admin_menu();

    }

    private static void update_animal_details() {
        System.out.println("Update Animals: ");
        for(int i = 0 ; i<Main.animalList.size();i++){
            System.out.println(i+1 + ". "+Main.animalList.get(i).getName());

        }
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        if(choice>Main.animalList.size()){
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
            Main.animalList.get(choice-1).setAnimal_facts(sc.nextLine());
            System.out.println("Details updated");
        }
        else if(c==2){
            System.out.print("Enter new sound: ");

            Main.animalList.get(choice-1).setSound(sc.next());
            System.out.println("Animal Sound updated");
        }
        else if(c==3){
            System.out.print("Enter new Name: ");
            Main.animalList.get(choice-1).setName(sc.next());
            System.out.println("Animal Name updated.");
        }
        else{
            System.out.println("Invalid Input!");
        }}
        Admin.admin_menu();
    }

    private static void add_animals() {
        System.out.println("Add Animal: ");
        System.out.print("Enter Animal Name: ");
        sc.nextLine();
        String animalName = sc.nextLine();
        System.out.print("Enter Animal Type: (Mammals, Amphibians, Reptiles) : ");
        String Animal_Type = sc.next();

        if(Animal_Type.equalsIgnoreCase("Mammals") || Animal_Type.equalsIgnoreCase("mammal")||Animal_Type.equalsIgnoreCase("Reptiles")||Animal_Type.equalsIgnoreCase("reptile")|| Animal_Type.equalsIgnoreCase("Amphibians") || Animal_Type.equalsIgnoreCase("amphibian")) {
            if (Animal_Type.equalsIgnoreCase("Mammals") || Animal_Type.equalsIgnoreCase("mammal")) {
                Animal m1 = new Mammal(animalName);
                Main.animalList.add(m1);

            } else if (Animal_Type.equalsIgnoreCase("Reptiles")|| Animal_Type.equalsIgnoreCase("reptile")) {
                Animal m1 = new Reptile(animalName);
                Main.animalList.add(m1);
            } else if (Animal_Type.equalsIgnoreCase("Amphibians")|| Animal_Type.equalsIgnoreCase("amphibian")) {
                Animal m1 = new Amphibian(animalName);
                Main.animalList.add(m1);
            }
            System.out.println("Animal added to Zoo.");
            Admin.admin_menu();
        }
        else{
            System.out.println("Animal of type : " + Animal_Type+ " can't be added!");
            admin_menu();
        }
    }




}
