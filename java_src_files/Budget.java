package com.example.tech.cs622_hw4_t8;

import java.math.BigDecimal;

public class Budget {

    static private String userBudget = "0.00"; //changed to static on 4/10/18, was not static before

    public boolean setUserBudget(String userBudgetValue)
    {
        boolean b = true;

        if(validateUserBudget(userBudgetValue))
        {
            this.userBudget = userBudgetValue;
        }
        else
        {
            b = false;
            //System.out.println("\n---Invalid Input---\n");
            //System.out.println(userBudgetValue);
        }

        return b;
    }

    public String getUserBudget()
    {
        return userBudget;
    }

    public static boolean validateUserBudget(String budget)
    {
        return budget.matches("^(([1-9]\\d{0,2}(,\\d{3})*)|(([1-9]\\d*)?\\d))(\\.\\d\\d)");
        //Where i found this regular expression for currency.
        //https://stackoverflow.com/questions/17864213/java-regular-expression-to-match-dollar-amounts
    }

    public void displayUserBudget()
    {
        System.out.println("Budget: $" + getUserBudget());
    }

    public boolean decUserBudget(Integer quantity, String price)
    {
        //finalAmount = userBudget - (quantity * price);

        BigDecimal firstAmount = new BigDecimal(userBudget);
        BigDecimal secondAmount = new BigDecimal(price);
        BigDecimal thirdAmount = new BigDecimal(quantity);

        BigDecimal multiplyAmount = secondAmount.multiply(thirdAmount);
        BigDecimal finalAmount = firstAmount.subtract(multiplyAmount);

        boolean b = true;

        if(finalAmount.compareTo(BigDecimal.ZERO) > 0 || finalAmount.compareTo(BigDecimal.ZERO) == 0)
        {
            userBudget = finalAmount.toPlainString();
        }
        else
        {
            b = false;
        }

        return b;
    }
}

