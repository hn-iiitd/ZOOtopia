package iiitd.harsh22199;

public class BasicMembership extends Visitor implements Membership {


    private final double membership_Price = 20;
    BasicMembership(){
        Main.setRevenue(Main.getRevenue()+membership_Price);
        Main.setCountOfBasicMembers(Main.getCountOfBasicMembers()+1);
    }
    @Override
    public void setMembership() {
        setBasic_membership();
    }

    @Override
    public boolean isMember() {
        return isBasic_membership();
    }

    @Override
    public double membershipPrice() {
        return membership_Price;
    }

    @Override
    public int getNoOfSubscribers() {
        return Main.getCountOfBasicMembers();
    }

}
