package iiitd.harsh22199;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Map;

public class Discount extends Admin { //Administrator access for Discounts
    private String Category;
    private double percentage;

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getDiscountCode() {
        return DiscountCode;
    }

    private String DiscountCode;
    Discount(String Category,double percentage, String DiscountCode){
        this.Category = Category;
        this.percentage = percentage;
        this.DiscountCode = DiscountCode;
    }
    static void set_discounts() {
        System.out.println("""
                Set Discounts:
                1. Add Discount
                2. Modify Discount
                3. Remove Discount
                4. Exit""");
        System.out.println();
        System.out.print("Enter your choice : ");
        try {
            int selected_option = sc.nextInt();
            if (selected_option < 1 || selected_option > 4) {
                throw new IncorrectOptionException("Invalid Option Selected");
            } else {
                if (selected_option==1){
                    add_discount();
                }
                 else if (selected_option==3){
                    remove_discount();

                } else if(selected_option==2){
                    modify_discount();
                }
                 else{
                     admin_menu();
                }
            }
        } catch (IncorrectOptionException | InputMismatchException e){
            System.out.println("Invalid Option Selected");
            sc.nextLine();
            admin_menu();
        }
    }

    private static void modify_discount() { //method for modifying discounts
        System.out.println();
        System.out.println("Modify Discount: ");

        for (Map.Entry<String,Discount>entry: Main.getDiscountHashMap().entrySet()){
            System.out.println(entry.getKey());
        }
        System.out.print("Enter Discount Code you want to modify: ");
        String code = sc.next();
        if(Main.getDiscountHashMap().containsKey(code)){
            System.out.println("Modify: ");
            System.out.println("1. Category: " + Main.getDiscountHashMap().get(code).getCategory());
            System.out.println("2. Percentage: " + Main.getDiscountHashMap().get(code).getPercentage());
            System.out.println("3. Discount Code: " + Main.getDiscountHashMap().get(code).getDiscountCode());
            System.out.print("Enter your choice: ");
            int choice  = sc.nextInt();
            if(choice==1){
                sc.nextLine();
                System.out.print("Enter new Category: ");
//                sc.nextLine();
                String newCat = sc.nextLine();
                Main.getDiscountHashMap().get(code).setCategory(newCat);
                System.out.println("Category Successfully changed to "+ newCat);

            }
            else if(choice==2){
                System.out.print("Enter new percentage: ");
                double newPer = sc.nextDouble();
                Main.getDiscountHashMap().get(code).setPercentage(newPer);
                System.out.println("Percentage Successfully changed to "+ newPer);
            }
            else{
                System.out.print("Enter new DiscountCode: ");
                String newDisc = sc.next();
                Discount d1 = Main.getDiscountHashMap().get(code);
                Main.getDiscountHashMap().remove(d1.getDiscountCode());
                d1.DiscountCode = newDisc;
                Main.getDiscountHashMap().put(newDisc,d1);
                System.out.println("Discount Code Successfully changed to "+ newDisc);

            }
            admin_menu();
        }
        else {
            System.out.println("Please Enter valid discount Code.");
            admin_menu();
        }
    }

    private static void remove_discount() { //method for removing discounts
        System.out.println();
        System.out.println("Remove Discount: ");
        for(Map.Entry<String,Discount>entry : Main.getDiscountHashMap().entrySet()){
            System.out.println(entry.getKey());
        }
        System.out.print("Enter Discount Code you want to remove: ");
        String disc_code = sc.next();
        Main.getDiscountHashMap().remove(disc_code);
        System.out.println("Discount Coupon removed successfully!");
        admin_menu();
    }



    private static void add_discount() { //method for adding discounts
        System.out.println();
        System.out.println("Add Discount: ");
        System.out.print("Enter Discount Category : ");
        sc.nextLine();
        String _Category = sc.nextLine();
            System.out.print("Enter Discount Percentage(e.g., 20 for 20%): ");
            try{
                int _percentage = sc.nextInt();
                if(_percentage>100 || _percentage<0){
                    throw new IncorrectOptionException("Please enter valid percentage.");
                }
                String _CouponCode = generate_coupon_code(_Category,_percentage);
                Discount d1 = new Discount(_Category,_percentage,_CouponCode);
                Main.getDiscountHashMap().put(d1.DiscountCode,d1);
                System.out.println("New Discount Coupon Added with Coupon Code - "+ d1.DiscountCode + " .");
                admin_menu();


            }
            catch (Exception e){
                System.out.println("Please Enter valid discount percentage");
                sc.nextLine();

                admin_menu();
            }
        }

    private static String generate_coupon_code(String category, int percentage) { //method for generating coupon codes
        category = category.strip();
        category = category.toUpperCase();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i<category.length();i++){
            if(category.charAt(i)==' ' ||sb.length()>6){
                break;
            }
            sb.append(category.charAt(i));
        }

        sb.append(percentage);
        return sb.toString();
    }



}



