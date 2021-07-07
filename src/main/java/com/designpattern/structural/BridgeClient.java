package com.designpattern.structural;

interface Remote {
    void on();
    void off();
}

class OldRemote implements Remote{

    @Override
    public void on() {
        System.out.println("On with Old Remote.");
    }

    @Override
    public void off() {
        System.out.println("Off with Old Remote.");
    }
}

class NewRemote implements Remote{

    @Override
    public void on() {
        System.out.println("On with New Remote.");
    }

    @Override
    public void off() {
        System.out.println("Off with new Remote.");
    }
}

abstract class TV{
    Remote remote;
    TV(Remote r){
        remote = r;
    }

    abstract void on();
    abstract void off();
}

class Sony extends TV{

    Remote remote;

    Sony(Remote remote){
        super(remote);
        this.remote = remote;
    }

    @Override
    void on() {
        System.out.println("Sony Tv: ON");
        remote.on();
    }

    @Override
    void off() {
        System.out.println("Sony Tv: OFF");
        remote.off();
    }
}

class Phillips extends TV{

    Remote remote;

    Phillips(Remote remote){
        super(remote);
        this.remote = remote;
    }

    @Override
    void on() {
        System.out.println("Phillips Tv: ON");
        remote.on();
    }

    @Override
    void off() {
        System.out.println("Phillips Tv: OFF");
        remote.off();
    }
}

public class BridgeClient {
    public static void main(String[] args) {
        Remote oldRemote = new OldRemote();
        Remote newRemote = new NewRemote();
        Sony sonyOld = new Sony(oldRemote);
        sonyOld.on();
        sonyOld.off();
        Sony sonyNew = new Sony(newRemote);
        sonyNew.on();
        sonyNew.off();
    }
}
