package iiitd.harsh22199;

public class Attraction {
    private String attraction_name;
    private String price;

    public Attraction(String attraction_name, String price) {
        this.attraction_name = attraction_name;
        this.price = price;
    }

    public String getAttraction_name() {
        return attraction_name;
    }

    public void setAttraction_name(String attraction_name) {
        this.attraction_name = attraction_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
