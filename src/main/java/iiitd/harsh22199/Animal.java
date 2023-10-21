package iiitd.harsh22199;

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
    }



}
