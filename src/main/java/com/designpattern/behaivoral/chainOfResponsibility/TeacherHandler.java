package com.designpattern.behaivoral.chainOfResponsibility;

public class TeacherHandler extends AbstractHandler{

    @Override
    public void handle(String suspect) {
        if(suspect.equalsIgnoreCase("teacher")){
            System.out.println("Teacher Handler called.");
            return;
        }
        this.nextHandler.handle(suspect);
    }
}
