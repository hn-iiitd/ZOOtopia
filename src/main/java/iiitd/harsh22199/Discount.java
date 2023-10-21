package iiitd.harsh22199;

import java.util.InputMismatchException;

public class Discount extends Admin {
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

    private final String DiscountCode;
    Discount(String Category,double percentage, String DiscountCode){
        this.Category = Category;
        this.percentage = percentage;
        this.DiscountCode = DiscountCode;
    }
    static void set_discounts() {
        System.out.println("""
                Set Discounts:
                1. Add Discount
                2. Remove Discount
                3. Exit""");
        System.out.print("Enter your choice : ");
        try {
            int selected_option = sc.nextInt();
            if (selected_option < 1 || selected_option > 3) {
                throw new IncorrectOptionException("Invalid Option Selected");
            } else {
                if (selected_option==1){
                    add_discount();
                }
                 else if (selected_option==3){
                    remove_discount();

                } else{
                    exit();
                }
            }
        } catch (IncorrectOptionException | InputMismatchException e){
            System.out.println("Invalid Option Selected");
            sc.nextLine();
            admin_menu();
        }
    }

    private static void remove_discount() {

    }



    private static void add_discount() {
        System.out.println("Add Discount: ");
        System.out.print("Enter Category ");
        String _Category = sc.nextLine();
        System.out.print("Enter CouponCode: ");
        String _CouponCode = sc.nextLine();
            System.out.print("Enter Discount%: ");
            try{
                float _percentage = sc.nextFloat();
                if(_percentage>100 || _percentage<0){
                    throw new IncorrectOptionException("Please enter valid percentage.");
                }
                Discount d1 = new Discount(_Category,_percentage,_CouponCode);
                discountHashMap.put(d1.DiscountCode,d1);


            }
            catch (Exception e){
                System.out.println("Please Enter valid discount percentage");
                sc.nextLine();

                add_discount();
            }
        }


    }



