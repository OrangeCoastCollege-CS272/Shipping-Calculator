package edu.orangecoastcollege.a273.sbadajozcs.shippingcalculator;


public class ShipItem {
    private final double BASE_COST = 3.0;

    private int mOunces;

    public ShipItem(int ounces) {
        mOunces = ounces;
    }
    public ShipItem(){}

    public double calculateAdddedCost() {
        if(mOunces > 16) {
            return .5 * (int)(mOunces - 16 +.5);
        }
        else return 0.0;
    }

    public double calculateTotalCost() {
        return BASE_COST + calculateAdddedCost();
    }

    public double getBASE_COST() {
        return BASE_COST;
    }

    public int getOunces() {
        return mOunces;
    }

    public void setOunces(int ounces) {
        mOunces = ounces;
    }
}