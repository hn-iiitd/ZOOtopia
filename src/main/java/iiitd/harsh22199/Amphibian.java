package iiitd.harsh22199;

public class Amphibian extends Animal { //class for amphibian type
    public Amphibian(String name ,String noise) {
        super(name,noise);
        Main.setAmphibian_count( Main.getAmphibian_count()+1);
        this.Name = name;
        this.sound = noise;
    }
    private String Name;
    private String sound;
    private String animal_facts;


    @Override
    public String getName() {
        return Name;
    }
    @Override
    public void setName(String name) {
        this.Name = name;
    }

    @Override
    public String getSound() {
        return this.sound;
    }

    @Override
    public void setSound(String sound) {
        this.sound = sound;
    }

    @Override
    public String getAnimal_facts() {
        return this.animal_facts;
    }

    @Override
    public void setAnimal_facts(String animal_facts) {
        this.animal_facts =animal_facts;
    }



    @Override
    public void feed() {
        System.out.println(this.sound);
    }
    @Override
    public void read(){
        System.out.println(this.animal_facts);
    }


}
