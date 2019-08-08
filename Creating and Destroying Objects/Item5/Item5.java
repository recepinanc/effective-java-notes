package com.recepinanc.effectivejava.chapter2;

public class Item5
{

    public static void main(String[] args)
    {
        // You as a Coffee Drinker can chose what type of coffee, with or without a milk
        // You do not need to manage coffee machine yourself you just tell what you want
        // to the Barista and he/she cooks it for you the way you want using the instructions you gave.
        Barista barista = new Barista(new CoffeeOrder(false, "Espresso"));
        barista.makeCoffee();
    }

}

class Barista
{
    private final CoffeeOrder order;

    Barista(CoffeeOrder order)
    {
        this.order = order;
    }

    void makeCoffee()
    {
        order.startMachine();
    }
}

class CoffeeOrder
{

    private boolean wantMilk;
    private String coffeeType;

    CoffeeOrder(boolean wantMilk, String coffeeType)
    {
        this.wantMilk = wantMilk;
        this.coffeeType = coffeeType;
    }

    private void plugIn()
    {
        System.out.println("Coffee machine plugged in.");
    }

    private void prepareIngredients()
    {
        System.out.println("Adding coffee");
        if (wantMilk)
        {
            System.out.println("Adding milk");
        }
        System.out.println("Adding whatever you want to add...");
    }

    void startMachine()
    {
        System.out.println("Coffee started...");
        plugIn();
        prepareIngredients();
        System.out.println("Coffee Type: " + coffeeType);
        System.out.println("Coffee Ready!");
    }
}
