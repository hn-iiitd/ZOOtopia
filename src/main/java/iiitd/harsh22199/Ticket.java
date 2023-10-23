package iiitd.harsh22199;

public class Ticket {
    private int Ticket_id ;
    private double Ticket_price;

    public int getTicket_id() {
        return Ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        Ticket_id = ticket_id;
    }

    public double getTicket_price() {
        return Ticket_price;
    }

    public void setTicket_price(double ticket_price) {
        Ticket_price = ticket_price;
    }

    public Attraction getAttraction() {
        return attraction_t;
    }

    public void setA(Attraction a) {
        this.attraction_t = a;
    }

    private Attraction attraction_t;
    Ticket(Attraction aa){
        this.Ticket_id = Main.getTicket_count();
        Main.setTicket_count(Main.getTicket_count()+1);
        this.Ticket_price = aa.getEvent_price();
        this.attraction_t = aa;
    }

}
