package iiitd.harsh22199;

import java.lang.reflect.Member;
import java.util.*;

public class Visitor {
    private String visitorName;
    private String visitorAge;
    private String visitorPhone;
    private double visitorBalance;
    private String visitorEmail;
    private String visitorPassword;
    private boolean premium_membership = false;
    private boolean basic_membership = false;

    static Scanner sc  = new Scanner(System.in);
    Visitor(){
        signup();
    }

    public Visitor(String visitorName, String visitorAge, String visitorPhone, double visitorBalance, String visitorEmail, String visitorPassword) {
        this.visitorName = visitorName;
        this.visitorAge = visitorAge;
        this.visitorPhone = visitorPhone;
        this.visitorBalance = visitorBalance;
        this.visitorEmail = visitorEmail;
        this.visitorPassword = visitorPassword;
    }

    public String getVisitorName() {
        return this.visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getVisitorAge() {
        return this.visitorAge;
    }

    public void setVisitorAge(String visitorAge) {
        this.visitorAge = visitorAge;
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

    private void signup() {
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
                signup();
            }
        }

    private void login() {
        System.out.print("Enter Visitor Email : ");
        String email = sc.next();
        System.out.print("Enter Visitor Password : ");
        String password = sc.next();
        if(visitor_login_validation(email,password)){
            System.out.println("Login Successful.");
            visitor_menu();
        }
        else{
            Main.start();
        }

    }

    private boolean visitor_login_validation(String email, String password) {
        if(Main.visitor_info.containsKey(email) && Main.visitor_info.get(email).contentEquals(password)){
            return true;
        }
        else{
            if(Main.visitor_info.containsKey(email)){
                System.out.println("Wrong Password ! Try again!");
            }
            else{
                System.out.println("User not registered with the provided E-Mail ID !");
                System.out.println("Please register and Log in Again!");
            }
        }
        return false;
    }

    private void visitor_menu() {
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
                    exploreZoo();
                } else if (selected_option == 2) {
                    buyMembership();
                }else if (selected_option == 3) {
                    buyTickets();
                }else if (selected_option == 4) {
                    viewDiscounts();
                }else if (selected_option == 5) {
                    viewSpecialDeals();
                }else if (selected_option == 6) {
                    visitAnimals();
                }else if (selected_option == 7) {
                    visitAttractions();
                }else if (selected_option == 8) {
                    leaveFeedback();
                }else {
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

    private void exit() {
        System.out.println("Logged out Successfully !");
        Main.start();
    }

    private void leaveFeedback() {
        System.out.println("Leave Feedback: ");
        System.out.println("Enter feedback (max 200 characters): ");

        String feedback = sc.nextLine();
        if(feedback.length() > 200){
            System.out.println("Feedback should not be of more than 200 words ! ");
        }
        else{
            Main.feedback.add(feedback);
            System.out.println("Thanks for your feedback");
        }
        visitor_menu();

    }

    private void visitAttractions() {
    }

    private void visitAnimals() {
    }

    private void viewSpecialDeals() {
    }

    private void viewDiscounts() {
    }

    private void buyTickets() {
    }

    private void buyMembership() {
        System.out.println("Buy Membership: ");
        int i = 1;
        for (Map.Entry<String,Integer>entry : Main.memberships.entrySet()){
            System.out.println(i+ ". " +entry.getKey() + " Membership ( Rs" + entry.getKey()+" )");
            i++;
        }
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

                if(Main.discountHashMap.containsKey(disc)){
                    double amount = membership_cost - membership_cost*(Main.discountHashMap.get(disc).getPercentage()/100);
                    System.out.println("Total Amount to be Paid is : " + "Rs. "+ amount);
                    amount = this.getVisitorBalance() - amount;
                    if(amount<0){
                        System.out.println("Insufficient Balance!");
                        visitor_menu();
                    }
                    else{
                        this.setVisitorBalance(amount);
                        if(choice==1){
                            this.basic_membership = true;
                        }
                        else{
                            this.premium_membership = true;
                        }
                        System.out.println(membership_name + " purchased successfully. Your balance is now Rs. " + amount );
                        visitor_menu();
                    }
                }
                else if(disc==null || disc.isEmpty()){
                    double amount = membership_cost;
                    System.out.println("Total Amount to be Paid is : " + "Rs. "+ amount);
                    amount = this.getVisitorBalance() - amount;
                    if(amount<0){
                        System.out.println("Insufficient Balance!");
                        visitor_menu();
                    }
                    else{
                        this.setVisitorBalance(amount);
                        if(choice==1){
                            this.basic_membership = true;
                        }
                        else{
                            this.premium_membership = true;
                        }
                        System.out.println(membership_name + " purchased successfully. Your balance is now Rs. " + amount );
                        visitor_menu();
                    }
                }
                else{
                    System.out.println("Invalid Discount coupon");
                    buyMembership();
                }
            }

        }
        catch (Exception e){
            System.out.println("Invalid option Selected. Please Try Again.");
            sc.nextLine();
            buyMembership();
        }

    }

    private void exploreZoo() {
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

    private void viewAnimals() {
    }

    private void viewAttractions() {
        System.out.println("Attractions in the Zoo: ");
        if(Main.attractions.isEmpty()){
            System.out.println("Sorry! No attractions available right now !");
        }
        else {
            for (int i = 0; i < Main.attractions.size(); i++) {
                System.out.println(i+1 + ". " + Main.attractions.get(i));
            }
            System.out.print("Enter your choice: ");
            try {
                int choice = sc.nextInt();
                if(choice>Main.attractions.size()+1 || choice<1){
                    throw new IncorrectOptionException("Invalid Option!");
                }
                System.out.println(Main.attractions.get(choice-1).getAttraction_details());
            }
            catch (IncorrectOptionException | InputMismatchException e){
                System.out.println("Invalid option selected.");
            }
            finally {
                viewAttractions();
            }
        }

    }


    private void register() {
        System.out.print("Enter Visitor Name : ");String Name = sc.next();
        System.out.print("Enter Visitor Age : ");String Age = sc.next();
        System.out.print("Enter Visitor Phone : ");String Phone = sc.next();
        System.out.print("Enter Visitor Balance : ");
        try {
            double Balance = sc.nextDouble();
            System.out.print("Enter Visitor Email : ");String Email = sc.next();
            System.out.print("Enter Visitor Password : ");String Password = sc.next();
            Visitor v1 = new Visitor(Name,Age,Phone,Balance,Email,Password);
            Main.visitors_list.add(v1);
            Main.visitor_info.put(v1.getVisitorEmail(),v1.getVisitorPassword());
            System.out.println("You have been Successfully Registered!");
            System.out.println("Please login with your credentials");
            signup();
        }
        catch (InputMismatchException e){
            System.out.println("Invalid Balance Entered! Try Again!");
            sc.nextLine();
            signup();
        }

    }
}