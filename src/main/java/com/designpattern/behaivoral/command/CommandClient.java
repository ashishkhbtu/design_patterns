package com.designpattern.behaivoral.command;
interface Command{
    void execute();
    void undo();
}
abstract class Receiver{
    String name;

    public Receiver(String name) {
        this.name = name;
    }

    abstract void on();
    abstract void off();
}
class TurnOnCommand implements Command{
    Receiver receiver;

    public TurnOnCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.on();
    }

    @Override
    public void undo() {
        receiver.off();
    }
}

class Light extends Receiver{

    public Light(String name) {
        super(name);
    }

    @Override
    void on() {
        System.out.println(name+" :: on.");
    }

    @Override
    void off() {
        System.out.println(name+" :: off.");
    }
}

class Motor extends Receiver{

    public Motor(String name) {
        super(name);
    }

    @Override
    void on() {
        System.out.println(name+" :: on.");
    }

    @Override
    void off() {
        System.out.println(name+" :: off.");
    }
}

class Invoke {
    Command command;
    public Invoke(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand(){
        command.execute();
    }

    public void undoCommand(){
        command.undo();
    }
}
public class CommandClient {
    public static void main(String[] args) {
        Receiver light = new Light("Flash Light");
        Receiver motor = new Motor("Motor");
        Command lightCommand = new TurnOnCommand(light);
        Command motorCommand = new TurnOnCommand(motor);

        Invoke invoke = new Invoke(lightCommand);
        invoke.executeCommand();
        invoke.undoCommand();
        invoke.setCommand(motorCommand);
        invoke.executeCommand();
        invoke.undoCommand();
    }
}
