package com.designpattern.behaivoral.chainOfResponsibility;

public abstract class AbstractHandler implements Handler{
    protected Handler nextHandler;

    @Override
    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }
}
