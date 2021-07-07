package com.designpattern.behaivoral.state;

import java.util.HashMap;

interface State{
    void transitionTo(State nextState);
    void displayState();
}
class Bulb{
    HashMap<State, State> hm = new HashMap<>();
    State current = null;
    Bulb(){
        OffState offState = new OffState(this);
        OnState onState = new OnState(this);
        hm.put(onState, offState);
        hm.put(offState, onState);
        current = offState;
    }

    void toggle(){
        this.current.transitionTo(hm.get(current));
    }

    void setState(State state){
        this.current = state;
    }

    void displayState(){
        this.current.displayState();
    }
}

class OffState implements State{
    Bulb bulb;

    public OffState(Bulb bulb) {
        this.bulb = bulb;
    }

    @Override
    public void transitionTo(State nextState) {
        this.bulb.setState(nextState);
    }

    @Override
    public void displayState() {
        System.out.println("Bulb is off.");
    }
}

class OnState implements State{
    Bulb bulb;

    public OnState(Bulb bulb) {
        this.bulb = bulb;
    }

    @Override
    public void transitionTo(State nextState) {
        this.bulb.setState(nextState);
    }

    @Override
    public void displayState() {
        System.out.println("Bulb is on.");
    }
}
public class StateClient {
    public static void main(String[] args) {
        Bulb b = new Bulb();
        b.displayState();
        b.toggle();
        b.displayState();
    }
}
