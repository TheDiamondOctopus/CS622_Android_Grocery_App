package com.example.tech.cs622_hw4_t8;

public class CartData {
    private String itemName;
    private String itemPrice;
    private String itemQuantity;
    private String itemPriority;
    //private String costAmount;
    private boolean purchasedFlag;
    private int photo;

    public CartData() {
    }

    public CartData(String itemName, String itemPrice, String quantity, String priority, boolean purchasedFlag, int photo) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = quantity;
        this.itemPriority = priority;
        //this.costAmount = costAmount;
        this.purchasedFlag = purchasedFlag;
        this.photo = photo;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

    public String getItemPriority() {
        return itemPriority;
    }

/*    public String getCostAmount() {
        System.out.println("entered getCostAmount method in CartData");
        System.out.println(costAmount);
        return costAmount; }*/

    public boolean getPurchasedFlag() {
        return purchasedFlag;
    }

    public int getPhoto() { return photo; }
}
