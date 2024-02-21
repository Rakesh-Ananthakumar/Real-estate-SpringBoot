package com.example.realestate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class SellModel {
    @Id
    private int propertyId;
    private String propertyType;
    private String propertyPlace;
    private int bhk;
    private double sellingAmount;
    private double depositAmount;
    private String sellerName;
    private String sellerNumber;

    public SellModel() {
    }

    public SellModel(int propertyId, String propertyType, String propertyPlace, int bhk, double sellingAmount,
            double depositAmount, String sellerName, String sellerNumber) {
        this.propertyId = propertyId;
        this.propertyType = propertyType;
        this.propertyPlace = propertyPlace;
        this.bhk = bhk;
        this.sellingAmount = sellingAmount;
        this.depositAmount = depositAmount;
        this.sellerName = sellerName;
        this.sellerNumber = sellerNumber;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getPropertyPlace() {
        return propertyPlace;
    }

    public void setPropertyPlace(String propertyPlace) {
        this.propertyPlace = propertyPlace;
    }

    public int getBhk() {
        return bhk;
    }

    public void setBhk(int bhk) {
        this.bhk = bhk;
    }

    public double getSellingAmount() {
        return sellingAmount;
    }

    public void setSellingAmount(double sellingAmount) {
        this.sellingAmount = sellingAmount;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerNumber() {
        return sellerNumber;
    }

    public void setSellerNumber(String sellerNumber) {
        this.sellerNumber = sellerNumber;
    }

    
}
