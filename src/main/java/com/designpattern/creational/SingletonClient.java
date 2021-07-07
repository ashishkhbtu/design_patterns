package com.designpattern.creational;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonClient {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getSingleton();
        Singleton singleton2 = null;
        System.out.println("Hash Code of singleton1: "+singleton1.hashCode());
//        System.out.println("Hash Code of singleton2: "+singleton2.hashCode());
        try {
            Constructor[] constructors = Singleton.class.getConstructors();
            for (Constructor c : constructors) {
                c.setAccessible(true);
                singleton2 = (Singleton) c.newInstance();
                break;
            }
            System.out.println("Hash Code of singleton2: "+singleton2.hashCode());
        }catch(Exception e){
            System.out.println(e);
        }
    }
}


class Singleton{
    private static Singleton singleton = new Singleton();
    private Singleton(){
    }
    // Bill Pugh Approach
    private static class SingletonHelper{
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getSingleton() {
//        if(singleton == null){
//            synchronized (Singleton.class) {
//                if(singleton == null)
//                    singleton = new Singleton();
//            }
//        }
//        return singleton;
        return SingletonHelper.INSTANCE;
    }
}
