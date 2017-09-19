package edu.orangecoastcollege.a273.sbadajozcs.shippingcalculator;


public class ShipItem {
    private final double BASE_COST = 3.0;

    private int mOunces;
    private double mAddedCost;
    private double mTotalCost;

    public ShipItem(int ounces) {
        mOunces = ounces;
    }

    public ShipItem() {
        mOunces = 0;
        mAddedCost = 0.0;
        mTotalCost = 0.0;
    }

    private void calculateAddedCost() {
        if (mOunces > 16) {
            mAddedCost = (mOunces - 13) / 4 * .5;
        } else mAddedCost = 0.0;
    }

    private double calculateTotalCost() {
        return BASE_COST + mAddedCost;
    }

    public double getBASE_COST() {
        return BASE_COST;
    }

    public int getOunces() {
        return mOunces;
    }

    public double getAddedCost() {
        return mAddedCost;
    }

    public double getTotalCost() {
        return mTotalCost;
    }

    public void setOunces(int ounces) {
        mOunces = ounces;
        calculateAddedCost();
        calculateTotalCost();
    }
}
