package com.designpattern.structural;

interface Dress{
    void assemble();
}

class BasicDress implements Dress{

    @Override
    public void assemble() {
        System.out.println("BasicDress");
    }
}

class DressDecorator implements Dress{
    Dress dress;

    public DressDecorator(Dress dress) {
        this.dress = dress;
    }


    @Override
    public void assemble() {
        dress.assemble();
    }
}

class FancyDress extends DressDecorator{
    public FancyDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("FancyDress");
    }
}

class SportDress extends DressDecorator{
    public SportDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("SportDress");
    }
}
public class DecoratorClient {

    public static void main(String[] args) {
        Dress sbd = new SportDress(new BasicDress());
        Dress sfbd = new SportDress(new FancyDress(new BasicDress()));
        sbd.assemble();
        sfbd.assemble();
    }
}
