package com.designpattern.behaivoral.memento;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

class Memento{
    String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class Originator{
    String article;

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public Memento save(){
        return new Memento(article);
    }

    public void restore(Memento memento){
        article = memento.getState();
    }
}

class CareTaker{
    List<Memento> mementos;
    int cursor = -1;

    public CareTaker() {
        this.mementos = new ArrayList<>();
    }

    public void addMemento(Memento memento){
        mementos.add(memento);
        cursor = mementos.size() -1;
    }

    public Memento getMemento(int index){
        return mementos.get(index);
    }

    public Memento undo(){
        System.out.println("Undoing State.");
        if(cursor <= 0 ){
            cursor = 0;
            return getMemento(cursor);
        }
        cursor--;
        return getMemento(cursor);
    }

    public Memento redo(){
        System.out.println("Redoing State.");
        if(cursor >= mementos.size()-1){
            cursor = mementos.size()-1;
            return getMemento(cursor);
        }
        cursor++;
        return getMemento(cursor);
    }
}

public class MementoClient {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        originator.setArticle("State-1");
        careTaker.addMemento(originator.save());
        originator.setArticle("State-2");
        careTaker.addMemento(originator.save());
        getOriginatorState(originator);
        originator.restore(careTaker.undo());
        getOriginatorState(originator);
    }

    public static void getOriginatorState(Originator originator){
        System.out.println(originator.getArticle());
    }
}
