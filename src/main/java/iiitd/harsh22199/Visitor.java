package iiitd.harsh22199;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Visitor {
    private String visitorName;
    private String visitorAge;
    private String visitorPhone;
    private String visitorBalance;
    private String visitorEmail;
    private String visitorPassword;

    static Scanner sc  = new Scanner(System.in);
    Visitor(){
        signup();
    }

    public Visitor(String visitorName, String visitorAge, String visitorPhone, String visitorBalance, String visitorEmail, String visitorPassword) {
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

    public String getVisitorBalance() {
        return this.visitorBalance;
    }

    public void setVisitorBalance(String visitorBalance) {
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
        System.out.print("Enter feedback (max 200 characters): ");
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
        System.out.println("Attractions: ");
        if(Main.attractions.isEmpty()){
            System.out.println("Sorry! No attractions available right now !");
        }
        else {
            for (int i = 0; i < Main.attractions.size(); i++) {
                System.out.println(i + ". " + Main.attractions.get(i).getAttraction_name());
            }
        }
    }


    private void register() {
        System.out.print("Enter Visitor Name : ");String Name = sc.next();
        System.out.print("Enter Visitor Age : ");String Age = sc.next();
        System.out.print("Enter Visitor Phone : ");String Phone = sc.next();
        System.out.print("Enter Visitor Balance : ");String Balance = sc.next();
        System.out.print("Enter Visitor Email : ");String Email = sc.next();
        System.out.print("Enter Visitor Password : ");String Password = sc.next();
        Visitor v1 = new Visitor(Name,Age,Phone,Balance,Email,Password);
        Main.visitors_list.add(v1);
        Main.visitor_info.put(v1.getVisitorEmail(),v1.getVisitorPassword());
        System.out.println("You have been Successfully Registered!");
        System.out.println("Please login with your credentials");
        signup();
    }
}