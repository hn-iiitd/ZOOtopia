package iiitd.harsh22199;

import java.util.ArrayList;
import java.util.InputMismatchException;

public abstract class Animal extends Admin{

    private String name;
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
        System.out.println("Add Animal: ");
        System.out.print("Enter Animal Name: ");
        sc.nextLine();
        String animalName = sc.nextLine();
        System.out.print("Enter Animal Type: ");
        String Animal_Type = sc.next();

        if(Animal_Type.equalsIgnoreCase("Mammals") || Animal_Type.equalsIgnoreCase("Reptiles")|| Animal_Type.equalsIgnoreCase("Amphibians")) {
            System.out.print("Enter " + animalName +"'s noise : ");
            String noise = sc.next();
            if (Animal_Type.equalsIgnoreCase("Mammals")) {
                Animal m1 = new Mammal(animalName);
                m1.sound = noise;
                Main.animalList.add(m1);

            } else if (Animal_Type.equalsIgnoreCase("Reptiles")) {
                Animal m1 = new Reptile(animalName);
                m1.sound = noise;
                Main.animalList.add(m1);
            } else if (Animal_Type.equalsIgnoreCase("Amphibians")) {
                Animal m1 = new Amphibian(animalName);
                m1.sound = noise;
                Main.animalList.add(m1);
            }
        }
        else{
            System.out.println("Animal of type"+ Animal_Type+ " can't be added!");
            add_animals();
        }
    }




}
