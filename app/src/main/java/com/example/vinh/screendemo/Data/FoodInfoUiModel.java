package com.example.vinh.screendemo.Data;

/**
 * Created by Vinh on 9/23/2018.
 */

public class FoodInfoUiModel {
    private String foodID;
    private String foodName;
    private int rate;
    private int review;
    private String description;
    private double price;
    private String address;
    private String linkImage;

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public FoodInfoUiModel() {

    }

    public FoodInfoUiModel(String mfoodID, String mFoodName, int mRate, int mReview,
                           String mDescription, double mPrice, String mAddress,
                           String mLinkImage) {
        foodID = mfoodID;
        foodName = mFoodName;
        rate = mRate;
        review = mReview;
        description = mDescription;
        price = mPrice;
        address = mAddress;
        linkImage = mLinkImage;
    }
}
