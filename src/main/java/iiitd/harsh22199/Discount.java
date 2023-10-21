package iiitd.harsh22199;

import java.util.InputMismatchException;

public class Discount extends Admin {
    private boolean type_percentage = false;
    private String Category;
    private float percentage;
    private final String DiscountCode;
    Discount(String Category,float percentage, String DiscountCode, boolean dis){
        this.Category = Category;
        this.percentage = percentage;
        this.DiscountCode = DiscountCode;
        this.type_percentage = dis;
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
        System.out.println("1. Percentage");
        System.out.println("2. Flat Discount");
        String _type = sc.nextLine();
        if(_type.strip().contentEquals("1")){
            boolean _type_percentage = true;
            System.out.print("Enter Discount%: ");
            try{
                float _percentage = sc.nextFloat();
                if(_percentage>100 || _percentage<0){
                    throw new IncorrectOptionException("Please enter valid percentage.");
                }
                Discount d1 = new Discount(_Category,_percentage,_CouponCode,_type_percentage);
                discountHashMap.put(d1.DiscountCode,d1);


            }
            catch (Exception e){
                System.out.println("Please Enter valid dicount percentage");
                sc.nextLine();

                add_discount();
            }
        }
        else if(_type.strip().contentEquals("2")){
            boolean _type_percentage = false;
            System.out.print("Enter Discount%: ");
            try{
                float _amount = sc.nextFloat();
                if(_amount<0){
                    throw new IncorrectOptionException("Invalid amount");
                }
                Discount d1 = new Discount(_Category,_amount,_CouponCode,_type_percentage);
                discountHashMap.put(d1.DiscountCode,d1);
            }
            catch (Exception e){
                System.out.println("Please Enter valid discount amount");
                sc.nextLine();
                add_discount();
            }
        }
        else{
            System.out.println("Please enter valid option");
            add_discount();
        }

    }


}
