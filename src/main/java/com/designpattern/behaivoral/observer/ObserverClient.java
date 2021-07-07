package com.designpattern.behaivoral.observer;

import java.util.ArrayList;
import java.util.List;

interface Subject{
    void register(Observer observer);
    void unregister(Observer observer);
    void notifyObserver();
}

interface Observer{
    void notifyMe(int i);
}

class RadioStation implements Subject{
    List<Observer> observerList = new ArrayList<>();
    int goldenNo = 2;
    @Override
    public void register(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observerList.stream().forEach(o->o.notifyMe(goldenNo));
    }

    public void updateGolden(int number){
        this.goldenNo = number;
        notifyObserver();
    }
}

class Person implements Observer{
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void notifyMe(int i) {
        System.out.println("Person ["+name+"]: notified with "+i+".");
    }
}
public class ObserverClient {
    public static void main(String[] args) {
        Subject station = new RadioStation();
        Observer o1 = new Person("A");
        Observer o2 = new Person("B");
        Observer o3 = new Person("C");
        Observer o4 = new Person("D");
        station.notifyObserver();
        station.register(o1);
        station.register(o2);
        station.notifyObserver();
        station.register(o3);
        station.register(o4);
        ((RadioStation)station).updateGolden(1);
    }
}
