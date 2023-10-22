package iiitd.harsh22199;

import java.util.InputMismatchException;

public class Attraction extends Admin implements Event{
    private String attraction_details;
    private final int attraction_id;
    private String attraction_name;
    private float price;
    private int countOfvisitors = 0;
    private boolean attraction_status = false;

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

    public Attraction(String attraction_name, String details, int attraction_id) {
        super();
        this.attraction_name = attraction_name;
        this.attraction_details = details;
        this.attraction_id=attraction_id;
    }

    @Override
    public String getEvent_name() {
        return attraction_name;
    }
    @Override
    public void setEvent_name(String attraction_name) {
        this.attraction_name = attraction_name;
    }

    @Override
    public float getEvent_price() {
        return price;
    }
 @Override
    public void setEvent_price(float price) {
        this.price = price;
    }

    @Override
    public void manageEvent() {
        System.out.println();
    }

    @Override
    public String toString() {
        return getEvent_name() ;
    }
    static void manage_attraction(){
        System.out.println("Manage Attractions:");
        System.out.println("""
                1. Add Attraction
                2. View Attractions
                3. Modify Attraction
                4. Remove Attraction
                5. Exit""");
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

    private static void remove_attraction() {
        System.out.print("Enter id of attraction to be removed.");
        try{
            int id_inp = sc.nextInt();
            boolean flag = false;
            for(int i = 0 ;i<Main.attractions.size();i++){
                if(Main.attractions.get(i).attraction_id==id_inp){

                    Main.attractions.remove(Main.attractions.get(i));
                    flag = true;
                    break;
                }
            }
            if(!flag){
                throw new IncorrectOptionException("Invalid id");
            }
            System.out.println("Attraction removed Successfully!");
        }
        catch (InputMismatchException |IncorrectOptionException e){
            System.out.println("Invalid id");
        }
    }

    private static void modify_attraction() {
        System.out.println("Modify Attractions: ");
        System.out.println();

    }

    private static void view_attraction() {
        System.out.println("View Attractions");
        if(Main.attractions.isEmpty()){
            System.out.println("No attractions added by the admin.");
        }
        else{
            System.out.println("id" + " " + "        Name        " + " " + "Price");
            for (Attraction attraction : Main.attractions) {
                System.out.println(attraction.attraction_id + " " + attraction.getEvent_name() + " " + attraction.getEvent_price());
            }
        }
    }

    private static void add_attraction() {
        System.out.println("Add attraction: ");
        sc.nextLine();
        System.out.print("Enter Attraction Name: ");
        String attraction_Name = sc.nextLine();
        System.out.print("Enter Attraction Details: ");
        String attraction_detail = sc.nextLine();
        Attraction a1 = new Attraction(attraction_Name,attraction_detail,attraction_count +1);
        Admin.attraction_count +=1;
        Main.attraction_id_map.put(attraction_count,a1);
        Main.attractions.add(a1);
        }
    protected static void schedule_event(){
        view_attraction();
        System.out.print("Enter id of attraction you want to schedule: ");
        int id_sch = sc.nextInt();
        if(Main.attraction_id_map.containsKey(id_sch)){
            String attraction_name = Main.attraction_id_map.get(id_sch).getEvent_name();
            System.out.println("Attraction Name: " + attraction_name);
            System.out.println("1. Add/Change ticket price");
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
                        float attraction_price = sc.nextFloat();
                        Main.attraction_id_map.get(id_sch).setEvent_price(attraction_price);
                    }
                    catch (InputMismatchException e){
                        System.out.println("Please give valid price for attraction !");
                        sc.nextLine();
                        schedule_event();
                    }
                }
                else if(choice==2){
                    Main.attraction_id_map.get(id_sch).setAttraction_status(true);
                    System.out.println("Attraction is open now");
                } else if (choice==3) {
                    Main.attraction_id_map.get(id_sch).setAttraction_status(false);
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

    }
    }



