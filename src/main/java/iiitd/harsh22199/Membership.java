package iiitd.harsh22199;

public interface Membership  { //Membership interface which is implemented by Premium and Basic Memberships because they have common methods.


    public void setMembership();
    public boolean isMember();
    public double membershipPrice();

    public int getNoOfSubscribers();
}
