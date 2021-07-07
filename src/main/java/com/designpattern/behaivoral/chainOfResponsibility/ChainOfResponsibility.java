package com.designpattern.behaivoral.chainOfResponsibility;

public class ChainOfResponsibility {
    public static void main(String[] args) {
        Handler staffHandler = getHandlers();
        staffHandler.handle("student");
        staffHandler.handle("teacher");
    }

    static Handler getHandlers(){
        StudentHandler studentHandler = new StudentHandler();
        TeacherHandler teacherHandler = new TeacherHandler();
        studentHandler.setNext(teacherHandler);
        return studentHandler;
    }
}
