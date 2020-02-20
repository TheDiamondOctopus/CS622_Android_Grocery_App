package com.example.tech.cs622_hw4_t8;

import java.util.ArrayList;
import java.util.List;

public class Store extends Item{

    private List<Item> availableItems = new ArrayList<Item>();
    private Item item1 = new Item();
    private Item item2 = new Item();
    private Item item3 = new Item();
    private Item item4 = new Item();
    private Item item5 = new Item();
    private Item item6 = new Item();
    private Item item7 = new Item();
    private Item item8 = new Item();
    private Item item9 = new Item();
    private Item item10 = new Item();

    public Store()
    {
        item1.setName("Batteries");
        item1.setPrice("11.79");
        availableItems.add(item1);

        item2.setName("Conditioner");
        item2.setPrice("5.99");
        availableItems.add(item2);

        item3.setName("Dish Soap");
        item3.setPrice("2.59");
        availableItems.add(item3);

        item4.setName("Dog Food");
        item4.setPrice("22.99");
        availableItems.add(item4);

        item5.setName("Paper Towels");
        item5.setPrice("16.49");
        availableItems.add(item5);

        item6.setName("Shampoo");
        item6.setPrice("6.99");
        availableItems.add(item6);

        item7.setName("Laundry Detergent");
        item7.setPrice("17.14");
        availableItems.add(item7);

        item8.setName("Toilet Paper");
        item8.setPrice("10.99");
        availableItems.add(item8);

        item9.setName("Toothpaste");
        item9.setPrice("0.99");
        availableItems.add(item9);

        item10.setName("Trash Bags");
        item10.setPrice("10.99");
        availableItems.add(item10);
    }

    public Item getItem(int i)
    {
        return availableItems.get(i);
    }

    public String getItemName(int i)
    {
        return getItem(i).getName();
    }

    public String getItemPrice(int i)
    {
        return getItem(i).getPrice();
    }

    public void displayStoreItems()
    {
        for(int i = 0; i < availableItems.size(); i++)
        {
            System.out.println("Name: " + availableItems.get(i).getName());
            System.out.println("Price: $" + availableItems.get(i).getPrice());
            System.out.println();
        }
    }
}

