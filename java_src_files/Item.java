package com.example.tech.cs622_hw4_t8;

import java.util.Comparator;


public class Item {

    private String name = " ";
    private Integer quantity = 0;
    private Integer priority = 0;
    private String price = " ";
    private boolean purchasedFlag = false;

    public Item(){}

    public Item(String name, Integer quantity, Integer priority, String price, boolean purchasedFlag) {
        this.name = name;
        this.quantity = quantity;
        this.priority = priority;
        this.price = price;
        this.purchasedFlag = purchasedFlag;
    }

    public void setPriority(int p)
    {
        this.priority = p;
    }

    public Integer getPriority()
    {
        return priority;
    }

    public void setName(String n)
    {
        this.name = n;
    }

    public String getName()
    {
        return name;
    }

    public void setQuantity(int q)
    {
        this.quantity = q;
    }

    public Integer getQuantity()
    {
        return quantity;
    }

    public void setPurchasedFlag(boolean b)
    {
        this.purchasedFlag = b;
    }

    public boolean getPurchasedFlag()
    {
        return purchasedFlag;
    }

    public void setPrice(String s)
    {
        this.price = s;
    }

    public String getPrice()
    {
        return price;
    }

    public static Comparator<Item> ItemPriorityComparator = new Comparator<Item>()
    {
        public int compare(Item i1, Item i2)
        {
            int priorityNum1 = i1.getPriority();
            int priorityNum2 = i2.getPriority();

            //For ascending order (1,2,3)
            return priorityNum1 - priorityNum2;
        }
    };
}
