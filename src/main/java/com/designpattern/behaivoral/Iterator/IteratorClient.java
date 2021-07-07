package com.designpattern.behaivoral.Iterator;

import java.util.ArrayList;
import java.util.List;

interface Iterator{
    boolean hasNext();
    String getNext();
}

interface IterableCollection{
    Iterator createIterator();
}

class CustomIterableCollection implements IterableCollection{
    List<String> list = new ArrayList<>();
    Iterator iterator;

    CustomIterableCollection(){
        list.add("A");
        list.add("B");
        list.add("C");
    }

    @Override
    public Iterator createIterator() {
        iterator = new CustomIterator(this);
        return iterator;
    }

    public int getSize(){
        return list.size();
    }

    public String getAt(int index){
        return list.get(index);
    }

}

class CustomIterator implements Iterator {
    private CustomIterableCollection customIterableCollection;

    int size;
    int current = -1;

    public CustomIterator(CustomIterableCollection customIterableCollection) {
        this.customIterableCollection = customIterableCollection;
        this.size = customIterableCollection.getSize();
    }

    @Override
    public boolean hasNext() {
        return current +1 < size;
    }

    @Override
    public String getNext() {
        current++;
        return customIterableCollection.getAt(current);
    }
}
public class IteratorClient {
    public static void main(String[] args) {
        CustomIterableCollection customIterableCollection = new CustomIterableCollection();
        Iterator iterator = customIterableCollection.createIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.getNext());
        }
    }
}
