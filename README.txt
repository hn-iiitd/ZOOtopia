# ZooBuddies


Assumptions Made - 
1. No visitor can buy a ticket or visit any attraction without purchasing a membership.
2. There can be only two deals (provided in the assignment) that can be turned on and off by admin using setDeals.
3. Deals are automatically applied at checkout if eligible.
4. Deals are turned off by Default. Admin need to turn them on by going to //SetSpecialDeals\\\ option from Admin Menu.
4. Visitors can also apply Discount codes while purchasing tickets.
5. if Visitor gives an invalid Discount Coupon the Payment proceeds further.
6. Admin needs to enter Animal Sound along with Animal Name and type when adding a new Animal.
7. Admin needs to enter Attraction ticket price also when adding a new attraction.
8. Admin can't remove animal if there are only 2 animals left of that category.(Ensuring atleast two animals of each type in the ZOO)
9. Added 6 animals , 2 of each type in main() function of Main.java.Admin Can add more using manage_animals().
10. Added 2 Discount Coupons, MINOR10 and SENIOR20 in main() function of Main.java file. Can add more using Set Discount option.
11. Admin can add new Discounts by just adding category and percentage. Made a method to generate a discountCode.
13. Added 2 Attraction in main() of Main.java , Admin can add more using manage Attractions.
14. add_animals method don't ask the admin for animal details , but it can be added using modify animals.
15. Added apply DiscountCode in Buy Ticket, since it was mentioned in assignment text.
16. The Program ensures that there should be atleast two animals of each type.
17. An attraction is open by default when added, can be turned off by schedule_event.
18. When a visitor is viewing attractions/Animals, and select one , it shows the message to buy tickets and go to visit animals / attractions to visit them.
19. If there are no Visitors, the visitor stats shows random Attraction as most popular.

HOME_FOLDER = ZooBuddies

mvn clean 
mvn compile 
mvn package

or just type

mvn clean install

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
