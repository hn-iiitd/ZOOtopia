package iiitd.harsh22199;

import java.lang.reflect.Member;
import java.util.*;

public class Visitor extends Main{
    //-------------------------Attributes-------start----------------------------------------------------------


    private static HashMap<String,Ticket> ticketMap = new HashMap<>();
    private String visitorName;
    private int visitorAge;
    private String visitorPhone;
    private double visitorBalance;
    private String visitorEmail;
    private String visitorPassword;
    private boolean premium_membership = false;
    private int visitor_ticket_count = 0;

    private boolean basic_membership = false;
    private static ArrayList<Ticket> ticketList = new ArrayList<>();
//--------------------Attributes-----end-----------------------------------------------------
    static Scanner sc  = new Scanner(System.in);

    //--------Setters and Getters -------------------------

    public void setVisitorAge(int visitorAge) {
        this.visitorAge = visitorAge;
    }

    public void setPremium_membership(boolean premium_membership) {
        this.premium_membership = premium_membership;
    }

    public int getVisitor_ticket_count() {
        return visitor_ticket_count;
    }

    public void setVisitor_ticket_count(int visitor_ticket_count) {
        this.visitor_ticket_count = visitor_ticket_count;
    }

    public void setBasic_membership(boolean basic_membership) {
        this.basic_membership = basic_membership;
    }

    public static ArrayList<Ticket> getTicketList() {
        return ticketList;
    }

    public static void setTicketList(ArrayList<Ticket> ticketList) {
        Visitor.ticketList = ticketList;
    }

    private static HashMap<String, Ticket> getTicketMap() {
        return ticketMap;
    }

    public void setTicketMap(HashMap<String, Ticket> ticketMap) {
        Visitor.ticketMap = ticketMap;
    }

    public boolean isPremium_membership() {
        return premium_membership;
    }

    public void setPremium_membership() {
        this.premium_membership = true;
    }

    public boolean isBasic_membership() {
        return basic_membership;
    }

    public void setBasic_membership() {
        this.basic_membership = true;
    }

    //-------Setters and Getters end---------------------------------
    Visitor(){

    }
    Visitor(boolean flag){

        signup();
    }

    public Visitor(String visitorName, int visitorAge, String visitorPhone, double visitorBalance, String visitorEmail, String visitorPassword) {
        this.visitorName = visitorName;
        this.visitorAge = visitorAge;
        this.visitorPhone = visitorPhone;
        this.visitorBalance = visitorBalance;
        this.visitorEmail = visitorEmail;
        this.visitorPassword = visitorPassword;
    }

    //Setter Getters ---------------------------------------------------------------------------------------------
    public String getVisitorName() {
        return this.visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public int getVisitorAge() {
        return this.visitorAge;
    }


    public String getVisitorPhone() {
        return this.visitorPhone;
    }

    public void setVisitorPhone(String visitorPhone) {
        this.visitorPhone = visitorPhone;
    }

    public double getVisitorBalance() {
        return this.visitorBalance;
    }

    public void setVisitorBalance(double visitorBalance) {
        this.visitorBalance = visitorBalance;
    }

    public String getVisitorEmail() {
        return this.visitorEmail;
    }

    public void setVisitorEmail(String visitorEmail) {
        this.visitorEmail = visitorEmail;
    }

    public String getVisitorPassword() {
        return this.visitorPassword;
    }

    public void setVisitorPassword(String visitorPassword) {
        this.visitorPassword = visitorPassword;
    }

    //Setter Getters ---------------------------------------------------------------------------------------

    private void signup() { //method used for signupInterface
        System.out.println("Welcome Visitor : ");
        System.out.println("""
                1. Register
                2. Login""");
        System.out.print("Enter your choice : ");
        try {
            int selected_option = sc.nextInt();
            if (selected_option < 1 || selected_option > 2) {
                throw new IncorrectOptionException("Invalid Option!");
            } else {
                if (selected_option == 1) {
                    register();
                } else {
                    login();
                }
            }

        }
        catch(IncorrectOptionException | InputMismatchException e){
                System.out.println("Invalid Option!");
                sc.nextLine();
                Main.start();
            }
        }

    private void login() { //method used for logging in visitor
        System.out.print("Enter Visitor Email : ");
        String email = sc.next();
        System.out.print("Enter Visitor Password : ");
        String password = sc.next();
        if(visitor_login_validation(email,password)){
            for(int i = 0; i< Main.getVisitors_list().size(); i++){
                if(Main.getVisitors_list().get(i).getVisitorEmail().equals(email)){
                    Visitor v1 = Main.getVisitors_list().get(i);
                    System.out.println("Login Successful.");
                    v1.visitor_menu();
                    break;
                }
            }

        }
        else{
            Main.start();
        }

    }

    private boolean visitor_login_validation(String email, String password) { //method used for login validation
        if(Main.getVisitor_info().containsKey(email) && Main.getVisitor_info().get(email).contentEquals(password)){
            return true;
        }
        else{
            if(Main.getVisitor_info().containsKey(email)){
                System.out.println("Wrong Password ! Try again!");
            }
            else{
                System.out.println("User not registered with the provided E-Mail ID !");
                System.out.println("Please register and Log in Again!");
            }
        }
        return false;
    }

    private void visitor_menu() { //method used for displaying visitor menu
        System.out.println();
        System.out.println("""
                Visitor Menu:
                1. Explore the Zoo
                2. Buy Membership
                3. Buy Tickets
                4. View Discounts
                5. View Special Deals
                6. Visit Animals
                7. Visit Attractions
                8. Leave Feedback
                9. Log Out""");
        System.out.print("Enter your choice: ");
        try {
            int selected_option = sc.nextInt();
            if (selected_option < 1 || selected_option > 9) {
                throw new IncorrectOptionException("Invalid Option!");
            } else {
                if (selected_option == 1) {
                    System.out.println();
                    exploreZoo();
                } else if (selected_option == 2) {
                    System.out.println();
                    buyMembership();
                }else if (selected_option == 3) {
                    System.out.println();
                    buyTickets();
                }else if (selected_option == 4) {
                    System.out.println();
                    viewDiscounts();
                }else if (selected_option == 5) {
                    System.out.println();
                    viewSpecialDeals();
                }else if (selected_option == 6) {
                    System.out.println();
                    visitAnimals();
                }else if (selected_option == 7) {
                    System.out.println();
                    visitAttractions();
                }else if (selected_option == 8) {
                    System.out.println();
                    leaveFeedback();
                }else {
                    System.out.println();
                    exit();
                }
            }

        }
        catch(IncorrectOptionException | InputMismatchException e){
            System.out.println("Invalid Option!");
            sc.nextLine();
            visitor_menu();
        }

    }
    private void visitAnimals() {   //method used to visit animals in the ZOO
        System.out.println("Visit Animals: ");
        for(int i = 0; i< Main.getAnimalList().size(); i++){
            System.out.println(i+1 + ". "+ Main.getAnimalList().get(i).getName());
        }
        System.out.print("Enter you choice: ");
        int c = sc.nextInt();
        System.out.println(Main.getAnimalList().get(c-1).getName() );
        System.out.println("1. Feed Animal.");
        System.out.println("2. Read about Animal.");
        System.out.print("Enter your choice: ");
        int n = sc.nextInt();
        if(n==1){
            System.out.println("Noise from "+ Main.getAnimalList().get(c-1).getName() +  " : \n"+ Main.getAnimalList().get(c-1).getSound());
        }else if(n==2){
            System.out.println("Facts about " + Main.getAnimalList().get(c-1).getName()+" : \n"+ Main.getAnimalList().get(c-1).getAnimal_facts());
        }
        else{
            System.out.println("Wrong option selected.");
        }
        visitor_menu();
    }
    private void exit() { //method used to log out visitor
        System.out.println("Logged out Successfully !");
        Main.start();
    }

    private void leaveFeedback() { //method used for providing feedback
        System.out.println("Leave Feedback: ");
        sc.nextLine();

        System.out.println("Enter feedback (max 200 characters): ");

        String feedback = sc.nextLine();
        if(feedback.length() > 200){
            System.out.println("Feedback should not be of more than 200 words ! ");
        }
        else{
            Main.getFeedback().add(feedback);
            System.out.println("Thanks for your feedback");
        }
        visitor_menu();

    }

    private void visitAttractions() { //method to use visit Attractions
        System.out.println("Visit Attractions: ");
        if(Main.getAttractions().isEmpty()){
            System.out.println("Sorry! Currently no attractions are open!");
        }
        else{
            System.out.println("Select an Attraction to Visit: "); //only open attractions are listed here
            for(int i = 0; i< Main.getAttractions().size(); i++){
                if(Main.getAttractions().get(i).isAttraction_status()){
                    System.out.println(i+1 + ". " + Main.getAttractions().get(i).getEvent_name());
                }
            }
            System.out.println(Main.getAttractions().size()+1 + ". Exit ");
            System.out.println();
            System.out.print("Enter your choice: ");
            int n  = sc.nextInt();
            if(n<1 || n> Main.getAttractions().size() || !Main.getAttractions().get(n-1).isAttraction_status()){
                System.out.println("Invalid option Selected");
            }
            else if(!isBasic_membership() && !isPremium_membership()){
                System.out.println("You need to be a member to visit attractions!");
            }
            else if(isPremium_membership() || ticketMap.containsKey(Main.getAttractions().get(n-1).getEvent_name())){
                Main.setVisitor_count(Main.getVisitor_count()+1);
                Main.getAttractions().get(n-1).setCountOfvisitors(Main.getAttractions().get(n-1).getCountOfvisitors()+1);
                ticketMap.remove(Main.getAttractions().get(n-1).getEvent_name());
                setTicket_count(0);
                System.out.println("1 ticket Used!");
                System.out.println("Thank you for visiting "+ Main.getAttractions().get(n-1).getEvent_name() +". Hope you enjoyed the attraction");
            }
            else if(n==Main.getAttractions().size()+1){
                System.out.println("Exiting...");
            }
            else{
                System.out.println("Ticket not available: Basic Members need to buy separate tickets for the attractions.");

            }

        }
        visitor_menu();


    }



    private void viewSpecialDeals() { //method used to view Special deals for visitor
        int i = 1;
        System.out.println("Special Deals: ");
        if(Main.isDeal1()){
            System.out.println(i +". "+"Buy more than 2 tickets and get 15% off.");
            i++;
        }
        if(Main.isDeal2()){
            System.out.println(i+". "+"Buy more than 3 tickets and get 30% off.");
        }
        else if(!Main.isDeal2() && !Main.isDeal1()){
            System.out.println("No Deals are currently active");
        }
        visitor_menu();
    }

    private void viewDiscounts() { //method used to view Discounts for visitor
        System.out.println("View Discounts: ");
        for (Map.Entry<String,Discount>entry : Main.getDiscountHashMap().entrySet()){
            System.out.println(entry.getValue().getCategory() + " (" +entry.getValue().getPercentage()+"% Discount - " + entry.getKey() +" )");
        }
        visitor_menu();
    }

    private void buyTickets() { //method used to buy tickets for visitors
        System.out.println("Buy Tickets: ");
        System.out.println("Select an Attraction to buy a Ticket: ");
        for(int i = 0; i< Main.getAttractions().size(); i++){
            System.out.println(i+1 + ". " + Main.getAttractions().get(i).getEvent_name() + " (Rs. "+ Main.getAttractions().get(i).getEvent_price() +" )");
        }
        double disc_amount = 0;
        System.out.println();
        System.out.print("Enter your choice: ");
        int choice  = sc.nextInt();
        if(choice> Main.getAttractions().size() || choice<1){
            System.out.println("You have chose Invalid option");
        }
        else if(!isPremium_membership() && !isBasic_membership()){
            System.out.println("You need to be a member to buy a ticket!.");
        }
        else{
            if(visitor_ticket_count==2 && Main.isDeal1()){
                System.out.println("You are eligible for Deal1");
                double totalamount = 0;
                for(int i = ticketList.size()-1 ;i>=ticketList.size() -visitor_ticket_count;i--){
                    totalamount+=ticketList.get(i).getTicket_price();
                }
                disc_amount = (totalamount + Main.getAttractions().get(choice-1).getEvent_price()) *15/100;
            }
            if(visitor_ticket_count==3 && Main.isDeal2()){
                System.out.println("You are eligible for Deal2");
                double discounted = 0;
                for(int i = ticketList.size()-1;i>=ticketList.size() - visitor_ticket_count ; i--){
                    if(i<ticketList.size()-visitor_ticket_count){
                        discounted+=ticketList.get(i).getTicket_price();
                    }
                }
                discounted = discounted * 100/85;
                disc_amount = (disc_amount+ Main.getAttractions().get(choice-1).getEvent_price())*30/100;
            }
            if(visitor_ticket_count>3){
                System.out.println("You are eligible for Deal2");
                double discounted = 0;
                for(int i = ticketList.size()-1;i>=ticketList.size() - visitor_ticket_count ; i--){
                    if(i<ticketList.size()-visitor_ticket_count){
                        discounted+=ticketList.get(i).getTicket_price();
                    }
                }
                discounted = discounted * 100/70;
                disc_amount = (disc_amount+ Main.getAttractions().get(choice-1).getEvent_price())*30/100;
            }
            System.out.print("Enter Discount Coupon (if any, otherwise type * none *  : " );
            String discount_coupon = sc.next();
            if(Main.getDiscountHashMap().containsKey(discount_coupon)){
                if((discount_coupon.contains("SENIOR") &&getVisitorAge()>60) || (discount_coupon.contains("MINOR") && getVisitorAge()<18)){
                    disc_amount += Main.getAttractions().get(choice-1).getEvent_price()* Main.getDiscountHashMap().get(discount_coupon).getPercentage()/100;
                }
                else if(discount_coupon.equalsIgnoreCase("none") || discount_coupon.equalsIgnoreCase("null")){
                    System.out.println("No Discount Coupon Applied");
                    System.out.println();
                }
                else{
                    System.out.println("You are not valid for Discount!, Try Again Later");
                    System.out.println("Proceeding for further process");
                    System.out.println();
                }
            }


            if(getVisitorBalance()>=(Main.getAttractions().get(choice-1).getEvent_price() - disc_amount)){
                setVisitorBalance(getVisitorBalance()- Main.getAttractions().get(choice-1).getEvent_price() + disc_amount);
                Ticket t1 = new Ticket(Main.getAttractions().get(choice-1));
                ticketList.add(t1);
                if(!isPremium_membership()) {
                    visitor_ticket_count+=1;
                    Main.setRevenue(Main.getRevenue() + (t1.getAttraction().getEvent_price() - disc_amount));
                }
                ticketMap.put(t1.getAttraction().getEvent_name(),t1);
                System.out.println("The ticket for " + Main.getAttractions().get(choice-1).getEvent_name()+" was purchased successfully. Your balance is now Rs. " + getVisitorBalance());

            }
            else{
                System.out.println("Insufficient Balance");
            }
        }
        visitor_menu();
    }

    private void buyMembership() { //method used for buying membership for visitor
        System.out.println("Buy Membership: ");
        System.out.println("1. " +  "Basic Membership ( Rs" +"20 )");
        System.out.println("2. " +  "Premium Membership ( Rs" +"50 )");
        System.out.print("Enter your choice :");
        try{
            int choice = sc.nextInt();
            if(choice > 2 || choice<0){
                throw new IncorrectOptionException("Invalid option");
            }
            else{
                System.out.print("Apply Discount Code: ");
                String disc = sc.next();
                double membership_cost = 20;
                String membership_name = "Basic Membership";

                if(choice==2){
                    membership_name = "Premium Membership";
                    membership_cost = 50;
                }

                if(Main.getDiscountHashMap().containsKey(disc)){
                    if((disc.contains("SENIOR")&& getVisitorAge()>60) || ( disc.contains("MINOR") && getVisitorAge()<18)){
                        double amount = membership_cost - membership_cost*(Main.getDiscountHashMap().get(disc).getPercentage()/100);
                        System.out.println("Total Amount to be Paid is : " + "Rs. "+ amount);
                        double new_balance = this.getVisitorBalance() - amount;
                        if(new_balance<0){
                            System.out.println("Insufficient Balance!");
                            visitor_menu();
                        }
                        else{
                            this.setVisitorBalance(new_balance);
                            if(choice==1){
                                Membership b1 = new BasicMembership();
                                setBasic_membership();
                            }
                            else{
                                Membership b1 = new PremiumMembership();
                                setPremium_membership();
                            }
                            System.out.println(membership_name + " purchased successfully. Your balance is now Rs. " + new_balance );
                            visitor_menu();
                        }
                    }
                    else{
                        System.out.println("Sorry This Coupon is not valid for you ! Try with a different coupon.");
                        buyMembership();
                    }
                    }


                else if(disc.equalsIgnoreCase("null")|| disc.equalsIgnoreCase("none")) {
                    double amount = membership_cost;
                    System.out.println("Total Amount to be Paid is : " + "Rs. "+ amount);
                    double new_balance = this.getVisitorBalance() - amount;
                    if(new_balance<0){
                        System.out.println("Insufficient Balance!");

                        visitor_menu();
                    }
                    else{
                        this.setVisitorBalance(new_balance);


                        if(choice==1){
                            Membership b1 = new BasicMembership();
                            b1.setMembership();
                            setBasic_membership();
                        }
                        else{
                            Membership b1 = new PremiumMembership();
                            b1.setMembership();
                            setPremium_membership();
                        }
                        System.out.println(membership_name + " purchased successfully. Your balance is now Rs. " + new_balance );
                        visitor_menu();
                    }
                }
                else {
                    System.out.println();
                    System.out.println("Invalid Discount coupon");
                    buyMembership();
                }

            }

        }
        catch (Exception e){
            System.out.println("Invalid option Selected. Please Try Again.");
            sc.nextLine();
            visitor_menu();
        }

    }

    private void exploreZoo() { //method for explore zoo for visitor
        System.out.println("""
                Explore the Zoo:
                1. View Attractions
                2. View Animals
                3. Exit""");
        System.out.print("Enter your choice: ");
        try {
            int selected_option = sc.nextInt();
            if (selected_option < 1 || selected_option > 3) {
                throw new IncorrectOptionException("Invalid Option!");
            } else {
                if (selected_option == 1) {
                    viewAttractions();
                } else if (selected_option == 2) {
                     viewAnimals();
                }
                else {
                    visitor_menu();
                }
            }

        }
        catch(IncorrectOptionException | InputMismatchException e){
            System.out.println("Invalid Option!");
            sc.nextLine();
            visitor_menu();
        }

    }

    private void viewAnimals() { //method used to view animals for visitor
        System.out.println("View Animals");
        for (int i = 0; i< Main.getAnimalList().size(); i++){
            System.out.println(i+1 +". " + Main.getAnimalList().get(i).getName());

        }
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        if(choice<1 || choice> Main.getAnimalList().size()){
            System.out.println("Wrong option.");
        }
        else{
            System.out.println(Main.getAnimalList().get(choice-1).getAnimal_facts());
            System.out.println("Go to Visit Animals to visit all the Animals");

        }
        visitor_menu();
    }

    private void viewAttractions() { //methods to view attractions for visitors
        System.out.println("Attractions in the Zoo: ");
        if(Main.getAttractions().isEmpty()){
            System.out.println("Sorry! No attractions available right now !");
        }
        else {
            for (int i = 0; i < Main.getAttractions().size(); i++) {
                System.out.println(i+1 + ". " + Main.getAttractions().get(i));
            }
            System.out.print("Enter your choice: ");
            try {
                int choice = sc.nextInt();
                if(choice> Main.getAttractions().size()+1 || choice<1){
                    throw new IncorrectOptionException("Invalid Option!");
                }
                System.out.println(" ZOOtopia offers an adventure ride that allows you to explore unexplored trails. Buy your ticket now!");
                System.out.println();
                exploreZoo();
            }
            catch (IncorrectOptionException | InputMismatchException e){
                System.out.println("Invalid option selected.");
                exploreZoo();
            }

        }

    }


    private void register() { //method used for visitors to register
        sc.nextLine();
        System.out.print("Enter Visitor Name : ");String Name = sc.nextLine();

        try {
            System.out.print("Enter Visitor Age : ");int Age = sc.nextInt();
            System.out.print("Enter Visitor Phone : ");String Phone = sc.next();
            System.out.print("Enter Visitor Balance : ");
            double Balance = sc.nextDouble();
            System.out.print("Enter Visitor Email : ");String Email = sc.next();
            System.out.print("Enter Visitor Password : ");String Password = sc.next();
            Visitor v1 = new Visitor(Name,Age,Phone,Balance,Email,Password);
            Main.getVisitors_list().add(v1);
            Main.getVisitor_info().put(v1.getVisitorEmail(),v1.getVisitorPassword());
            System.out.println("You have been Successfully Registered!");
            System.out.println("Please login with your credentials");
            signup();
        }
        catch (InputMismatchException e){
            System.out.println("Invalid Balance / Age Entered! Try Again!");
            sc.nextLine();
            signup();
        }

    }
}