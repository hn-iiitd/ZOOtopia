package iiitd.harsh22199;

import java.util.InputMismatchException;

public class Attraction extends Admin { //Administrator roles for events
    //--------------------attributes-----------------------------
    private String attraction_details;
    private final int attraction_id;
    private String attraction_name;
    private double price;
    private int countOfvisitors = 0;
    private boolean attraction_status = true;

    //---------------attributes----------------------

    //----------Setters and Getters----------------

    public boolean isAttraction_status() {
        return this.attraction_status;
    }

    public void setAttraction_status(boolean attraction_status) {
        this.attraction_status = attraction_status;
    }

    public String getAttraction_details() {
        return attraction_details;
    }

    public void setAttraction_details(String attraction_details) {
        this.attraction_details = attraction_details;
    }

    public int getCountOfvisitors() {
        return this.countOfvisitors;
    }

    public void setCountOfvisitors(int countOfvisitors) {
        this.countOfvisitors = countOfvisitors;
    }

    public int getAttraction_id() {
        return attraction_id;
    }

    public String getAttraction_name() {
        return attraction_name;
    }

    public void setAttraction_name(String attraction_name) {
        this.attraction_name = attraction_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }




    public String getEvent_name() {
        return attraction_name;
    }

    public void setEvent_name(String attraction_name) {
        this.attraction_name = attraction_name;
    }


    public double getEvent_price() {
        return price;
    }

    public void setEvent_price(double price) {
        this.price = price;
    }

    public void manageEvent() {
        System.out.println();
    }
    //-----------Setters and Getters end---------------------

    public String toString() {
        return getEvent_name() ;
    }
    public Attraction(String attraction_name, String details) {
        super();
        this.attraction_name = attraction_name;
        this.attraction_details = details;
        this.attraction_id= Main.getAttraction_id_no();
        Main.setAttraction_id_no(getAttraction_id_no()+1);
    }

    static void manage_attraction(){ //Method for managing attractions for ADMIN
        System.out.println();
        System.out.println("Manage Attractions:");
        System.out.println();
        System.out.println("""
                1. Add Attraction
                2. View Attractions
                3. Modify Attraction
                4. Remove Attraction
                5. Exit""");
        System.out.println();
        System.out.print("Enter your choice: ");
        try {
            int selected_option = sc.nextInt();
            if(selected_option<1 || selected_option>5){
                throw new IncorrectOptionException("Invalid Option");
            }
            else{
                if(selected_option ==1){
                    add_attraction();
                    admin_menu();
                }
                else if(selected_option==2){
                    view_attraction();
                    admin_menu();
                }
                else if(selected_option==3){
                    modify_attraction();
                    admin_menu();
                }
                else if(selected_option==4){
                    remove_attraction();
                    admin_menu();
                }
                else{
                    admin_menu(); //check
                }

            }
        }
        catch (IncorrectOptionException | InputMismatchException e){
            System.out.println("Invalid Option Selected! ");
            sc.nextLine();
            manage_attraction();
        }
    }

    private static void remove_attraction() { //method for removing attractions
        System.out.println();
        System.out.println("Remove Attraction : ");
        System.out.println();

        view_attraction();

        System.out.print("Enter id of attraction to be removed.");
        try{
            int id_inp = sc.nextInt();
            if(!Main.getAttraction_id_map().containsKey(id_inp)){
                throw new IncorrectOptionException("Invalid id");
            }
            for(int i = 0; i< Main.getAttractions().size(); i++){
                if(Main.getAttractions().get(i).attraction_id==id_inp){
                    Main.getAttractions().remove(Main.getAttractions().get(i));
                    break;
                }
            }
            Main.getAttraction_id_map().remove(id_inp);
            System.out.println("Attraction removed Successfully!");
        }
        catch (InputMismatchException |IncorrectOptionException e){
            System.out.println("Invalid id");
        }
    }

    private static void modify_attraction() { //method for modifying attractions
        System.out.println("Modify Attractions: ");
        view_attraction();
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        if(!Main.getAttraction_id_map().containsKey(choice)){
            System.out.println("Please enter valid attraction id.");
        }
        else{
            System.out.println("Modify : ");
            System.out.println("1.Change Attraction Price ");
            System.out.println("2.Change Attraction Details ");
            System.out.print("Enter your choice: ");
            int c = sc.nextInt();
            if(c==1){
                System.out.print("Enter new price: ");
                Main.getAttraction_id_map().get(choice).setEvent_price(sc.nextInt());
                System.out.println("Price changed Successfully!");
            }
            else if(c==2){
                sc.nextLine();
                System.out.print("Enter new Attraction Details: ");
                Main.getAttraction_id_map().get(choice).setAttraction_details(sc.nextLine());
                System.out.println("Details Changed Successfully!");
            }
            else{
                System.out.println("Invalid option Selected!");
            }
            System.out.println();
        }



    }

    private static void view_attraction() { //method for viewing attractions
        System.out.println("View Attractions");
        if(Main.getAttractions().isEmpty()){
            System.out.println("No attractions added by the admin.");
        }
        else{
            System.out.println("id" + " " + "        Name        " + " " + "Price");
            for (Attraction attraction : Main.getAttractions()) {
                System.out.println(attraction.attraction_id + " " + attraction.getEvent_name() + " " + attraction.getEvent_price());
            }
        }
    }

    private static void add_attraction() { //Method for adding attractions
        System.out.println();
        System.out.println("Add attraction: ");
        sc.nextLine();
        System.out.print("Enter Attraction Name: ");
        String attraction_Name = sc.nextLine();
        System.out.print("Enter Attraction Details: ");
        String attraction_detail = sc.nextLine();
        System.out.println();
        System.out.print("Enter Attraction Ticket Price: ");
        double price = sc.nextDouble();
        Attraction a1 = new Attraction(attraction_Name,attraction_detail);
        a1.setEvent_price(price);
        Main.getAttraction_id_map().put(a1.attraction_id,a1);
        Main.getAttractions().add(a1);

        System.out.println("Attraction added successfully.");
        System.out.println("Remember ! Attraction is open by default when added. To close it go to '3. Schedule Events'.");

        }
    protected static void schedule_event(){ //method used for scheduling event
        System.out.println();
        System.out.println("Schedule Events: ");
        view_attraction();
        System.out.println();
        System.out.print("Enter id of attraction you want to schedule: ");
        int id_sch = sc.nextInt();
        if(Main.getAttraction_id_map().containsKey(id_sch)){
            String attraction_name = Main.getAttraction_id_map().get(id_sch).getEvent_name();
            System.out.println("Attraction Name: " + attraction_name);
            System.out.println("1. Change ticket price");
            System.out.println("2. Open " + attraction_name);
            System.out.println("3. Close " + attraction_name);
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            try{
                int choice = sc.nextInt();
                if(choice<1 || choice>4){
                    throw new IncorrectOptionException("invalid option");
                }
                else if(choice==1){
                    System.out.print("Enter ticket price for " + attraction_name +":");
                    try {
                        double attraction_price = sc.nextDouble();
                        Main.getAttraction_id_map().get(id_sch).setEvent_price(attraction_price);
                    }
                    catch (InputMismatchException e){
                        System.out.println("Please give valid price for attraction !");
                        sc.nextLine();
                        schedule_event();
                    }
                }
                else if(choice==2){
                    Main.getAttraction_id_map().get(id_sch).setAttraction_status(true);
                    System.out.println("Attraction is open now");
                } else if (choice==3) {
                    Main.getAttraction_id_map().get(id_sch).setAttraction_status(false);
                    System.out.println("Attraction is closed now");
                } else {
                    exit();
                    }
            }
            catch (IncorrectOptionException | InputMismatchException e){
                System.out.println("Please select a valid option !");
                sc.nextLine();
                schedule_event();
            }

        }
        else{
            System.out.println("Attraction with provided id doesn't exist!");
            schedule_event();
        }

        admin_menu();

    }
    }



