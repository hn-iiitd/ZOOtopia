package iiitd.harsh22199;

public class Mammal extends Animal {
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    Mammal(String Name){
        this.Name = Name;
    }
}
