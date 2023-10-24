package iiitd.harsh22199;


public abstract class Animal{ //abstract class for animal which have common methods for its subclasses
    public Animal(String name, String noise){ //constructor
        this.Name = name;
        this.sound = noise;
    }
    private String Name;
    private String sound;
    private String animal_facts;
    abstract void feed();

    abstract void read();

    abstract String getName();


    abstract void setName(String name) ;



    abstract String getSound() ;



    abstract void setSound(String sound) ;


    abstract String getAnimal_facts() ;


    abstract void setAnimal_facts(String animal_facts);







}
