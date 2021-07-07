package com.designpattern.behaivoral.mediator;

import java.util.HashMap;
import java.util.Map;

interface Mediator{
    void notify(Component component, String message);
    void register(Component component);
}

class ConcreteMediator implements Mediator{
    String COMPONENT_A = "Component-A";
    String COMPONENT_B = "Component-B";
    Map<String, Component> components = new HashMap<>();
    @Override
    public void notify(Component component, String message) {
        if(COMPONENT_A.equalsIgnoreCase(component.getName())){
            reactOnA(message);
        }else if(COMPONENT_B.equalsIgnoreCase(component.getName())){
            reactOnB(message);
        }
    }

    @Override
    public void register(Component component) {
        components.put(component.getName(), component);
    }

    public void reactOnA(String message){
        components.get(COMPONENT_B).receive(message);
    }

    public void reactOnB(String message){
        components.get(COMPONENT_A).receive(message);
    }
}
abstract class Component{
    String name;
    Mediator mediator;

    public Component(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    abstract void send();
    abstract void receive(String message);
}

class ComponentA extends Component{

    static String name = "Component-A";

    public ComponentA(Mediator mediator) {
        super(name, mediator);
    }

    @Override
    void send() {
        System.out.println("A is sending Message:");
        String message = "Message-By-A-To-B";
        mediator.notify(this, message);
    }

    @Override
    void receive(String message) {
        System.out.println("A received Message:"+ message);
    }

}

class ComponentB extends Component{

    static String name = "Component-B";

    public ComponentB(Mediator mediator) {
        super(name, mediator);
    }

    @Override
    void send() {
        System.out.println("B is sending Message:");
        String message = "Message-By-B-To-A";
        mediator.notify(this, message);
    }

    @Override
    void receive(String message) {
        System.out.println("B received Message:"+ message);
    }

}

public class MediatorClient {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        Component componentA = new ComponentA(mediator);
        Component componentB = new ComponentB(mediator);
        mediator.register(componentA);
        mediator.register(componentB);
        componentA.send();
        componentB.send();
    }
}
