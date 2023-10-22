package iiitd.harsh22199;

public class Amphibian extends Animal{
    public Amphibian(String name) {
        super();
    }
    private String Name;

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public void setName(String name) {
        this.Name = name;
    }
    private String sound;
    private String animal_facts;

    @Override
    public void feed() {
        System.out.println(this.sound);
    }
    @Override
    public void read(){
        System.out.println(this.animal_facts);
    }


}
