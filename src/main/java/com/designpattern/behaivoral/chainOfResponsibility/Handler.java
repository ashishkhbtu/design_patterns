package com.designpattern.behaivoral.chainOfResponsibility;

public interface Handler {
    void setNext(Handler handler);
    void handle(String suspect);
}
