package com.designpattern.behaivoral.chainOfResponsibility;

public class StudentHandler extends AbstractHandler{
    @Override
    public void handle(String suspect) {
        if(suspect.equalsIgnoreCase("student")){
            System.out.println("Student Handler called.");
            return;
        }
        this.nextHandler.handle(suspect);
    }
}
