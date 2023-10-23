# ZooBuddies
Classes Made : <br>
1. Main.java - Main file of ZooBuddies  (can also be referred as Zoo.java) <br>
2. Admin.java - It is a Child Class of Main.java. Contains all the methods for Admin access.
3. Visitor.java - It is a Child Class of Main.java , It Contains all the methods for Visitor access.
4. Attraction.java - It is a Child Class of Admin.java. It Contains all the methods for Attraction's Admin View.
5. Animal.java - It is an Abstract class which is extended by Classes Namely Mammal.java, Amphibian.java, Reptile.java . It is made an abstract class because Animal is extended by 3 types which have common methods and also common attributes like feed and read.
6. Discount.java - It is a child class of Admin.java, contains all the features which have access from admin and used in managing Discounts
6. Membership.java - It is an Interface for two types of memberships which is implemented by BasicMembership.java and PremiumMembership.java
7. IncorrectOptionException.java - It is a Class extending Exception class which is made to raise exception, whenever a user enters an invalid option.
8. Ticket.java - It is an object class for distinguishing Tickets with unique ticket id.

Important Points Regarding ZooBuddies.
1. Added 6 animals , 2 of each type in main() function of Main.java.Admin Can add more using manage_animals().
2. Added 2 Discount Coupons, MINOR10 and SENIOR20 in main() function of Main.java file. Can add more using Set Discount option.
3. Admin can add new Discounts by just adding category and percentage. Made a method to generate a discountCode.
4. 2 Deals mentioned in the assignment are added but they are turned off by Default. Admin need to turn them on by going to //SetSpecialDeals\\\ option from Admin Menu.
5. Added 2 Attraction in main() of Main.java , Admin can add more using manage Attractions.
6. add_animals method don't ask the admin for animal details , but it can be added using modify animals.
7. Added apply DiscountCode in Buy Ticket, since it was mentioned in assignment text.
8. In add_animals , the admin is asked to input animal noise too.
9. The Program ensures that there should be atleast two animals of each type.
