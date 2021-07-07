package com.designpattern.behaivoral.template;
abstract class PizzaMaker{
    abstract void selectBase();
    abstract void selectIngredients();
    abstract void selectToppings();
    abstract void selectCheese();
    abstract void bakeAtTemp();

    void make(){
        selectBase();
        selectToppings();
        selectIngredients();
        selectCheese();
        bakeAtTemp();
    }
}

class ConcreteCornPizza extends PizzaMaker{

    @Override
    void selectBase() {
        System.out.println("Selecting Base....");
    }

    @Override
    void selectIngredients() {
        System.out.println("Selecting Ingredients....");
    }

    @Override
    void selectToppings() {
        System.out.println("Selecting Toppings....");
    }

    @Override
    void selectCheese() {
        System.out.println("Selecting Cheese....");
    }

    @Override
    void bakeAtTemp() {
        System.out.println("Baking....");
    }
}

public class TemplateClient {
    public static void main(String[] args) {
        PizzaMaker simplePizza = new ConcreteCornPizza();
        simplePizza.make();
    }
}
