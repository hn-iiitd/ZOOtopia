package iiitd.harsh22199;

public class PremiumMembership extends Visitor implements Membership{ //class for Premium membership
    PremiumMembership(){

        Main.setCountOfPremiumMembers(Main.getCountOfPremiumMembers()+1);
        Main.setRevenue(Main.getRevenue() + membership_Price);

    }
    private final double membership_Price = 50;
    @Override
    public void setMembership() {
        setPremium_membership();
    }

    @Override
    public boolean isMember() {
        return isPremium_membership();
    }

    @Override
    public double membershipPrice() {
        return membership_Price;
    }

    @Override
    public int getNoOfSubscribers() {
        return Main.getCountOfPremiumMembers();
    }


}
