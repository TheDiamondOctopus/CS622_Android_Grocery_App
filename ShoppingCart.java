package com.example.tech.cs622_hw4_t8;

import java.math.BigDecimal;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart extends Item{

    private List<Item> Cart = new ArrayList<Item>();
    private String cost = "0.00"; //changed to static on 4/10/18, was not static before

    public void setCost(Integer quantity, String price)
    {
        BigDecimal firstAmount = new BigDecimal(quantity);
        BigDecimal secondAmount = new BigDecimal(price);
        BigDecimal tempCost = new BigDecimal(cost);

        BigDecimal multiplyAmount = firstAmount.multiply(secondAmount);
        BigDecimal finalAmount = multiplyAmount.add(tempCost);

        this.cost = finalAmount.toPlainString();
        // System.out.println("cost set: " + price);
    }

    //Increases the total cost amount accordingly when you hit the incQuantity (plus sign) button
    public void incCost(String price)
    {
        BigDecimal priceOfItem = new BigDecimal(price);
        BigDecimal tempCost = new BigDecimal(cost);

        BigDecimal newCostAmount = priceOfItem.add(tempCost);

        this.cost = newCostAmount.toPlainString();
    }

    //Decreases the total cost amount accordingly when you hit the decQuantity (minus sign) button
    public void decCost()
    {

    }

    public String getCost()
    {
        //System.out.println("get cost");
        return cost;
    }

    public void addItemToList(Item i) {
        Cart.add(i);
    }

    public void createItem(String name, Integer quantity, Integer priority, String price)
    {
        //This will be the method called when the user hits
        //the button, "Add this Item," in the GUI.
        Item i = new Item();
        i.setName(name);
        i.setQuantity(quantity);
        i.setPriority(priority);
        i.setPrice(price);
        this.setCost(quantity, price);
        //i.setPurchasedFlag(true);
        addItemToList(i);
    }

    public List returnCart()
    {
        return Cart;
    }

    public String getName(int i)
    {
        return Cart.get(i).getName();
    }

    public Integer getPriority(int i)
    {
        return Cart.get(i).getPriority();
    }

    public boolean getPurchasedFlag(int i)
    {
        return Cart.get(i).getPurchasedFlag();
    }

    public String getPrice(int i)
    {
        return Cart.get(i).getPrice();
    }

    public Integer getCartSize()
    {
        return Cart.size();
    }

    public Integer getQuantity(int i)
    {
        return Cart.get(i).getQuantity();
    }

    public void setQuantity(int index, int newQuantity)
    {
        Cart.get(index).setQuantity(newQuantity);
    }

    public void setPriority(int index, int newQuantity)
    {
        Cart.get(index).setPriority(newQuantity);
    }


    public void incQuantity(ShoppingCart tempCart, String itemName)
    {
     /*   for(int i = 0; i < this.getCartSize(); i++){
            if(this.getName(i) == itemName)
            {
                if(super.getQuantity() < 50) {
                    super.setQuantity(super.getQuantity() + 1);
                }
                System.out.println(super.getName() + "***********");
                System.out.println(super.getQuantity() + "*****************");

            }
            }*/

            for(int i = 0; i < tempCart.getCartSize(); i++){
                if(tempCart.getName(i) == itemName)
                {
                    if(tempCart.getQuantity(i) < 50) {
                        tempCart.setQuantity(i,tempCart.getQuantity(i) + 1);
                        tempCart.incCost(tempCart.getPrice(i));
                    }
                    System.out.println(tempCart.getName(i) + "***********");
                    System.out.println(tempCart.getQuantity(i) + "*****************");
                    System.out.println(tempCart.getCost());

                }
            }
    }

    public void decQuantity(ShoppingCart tempCart, String itemName)
    {
        for (int i = 0; i < tempCart.getCartSize(); i++) {
            if (tempCart.getName(i) == itemName) {
                if(tempCart.getQuantity(i) > 0){
                    tempCart.setQuantity(i,tempCart.getQuantity(i) - 1);
                }
            }
            System.out.println(tempCart.getQuantity(i) + "------------------");
        }
    }

    public void incPriority(ShoppingCart tempCart, String itemName)
    {
        for(int i = 0; i < tempCart.getCartSize(); i++){
            if(tempCart.getName(i) == itemName)
            {
                if(tempCart.getPriority(i) < 3) {
                    tempCart.setPriority(i,tempCart.getPriority(i) + 1);
                }

                System.out.println(tempCart.getName(i) + "***********");
                System.out.println(tempCart.getPriority(i) + "*****************");
            }
        }
    }

    public void decPriority(ShoppingCart tempCart, String itemName)
    {
        for (int i = 0; i < tempCart.getCartSize(); i++) {
            if (tempCart.getName(i) == itemName) {
                if(tempCart.getPriority(i) > 0){
                    tempCart.setPriority(i, tempCart.getPriority(i) - 1);}
            }
        }
    }

    public void displayList()
    {
        for(int i = 0; i < Cart.size(); i++)
        {
            System.out.println("Name: " + Cart.get(i).getName());
            System.out.println("Priority: " + Cart.get(i).getPriority());
            System.out.println("Quantity: " + Cart.get(i).getQuantity());
            System.out.println("Purchased: " + Cart.get(i).getPurchasedFlag());
            System.out.println("Price: " + Cart.get(i).getPrice());
            System.out.println();
        }
    }

    public void checkoutCart(Budget userBudget)
    {
        Collections.sort(Cart,Item.ItemPriorityComparator);

        try
        {
            for (int i = 0; i < Cart.size(); i++) {
                Double tempI = Double.parseDouble(userBudget.getUserBudget());

                if (Cart.get(i).getPurchasedFlag() == false && tempI != 0.00)//DOES NOT WORK CORRECTLY
                {
                    if(userBudget.decUserBudget(Cart.get(i).getQuantity(), Cart.get(i).getPrice()))
                    {
                        Cart.get(i).setPurchasedFlag(true);
                    }
                }
            }
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println("--- Budget: " + userBudget.getUserBudget() + " ---");
        System.out.println();
        displayList();
    }
}
