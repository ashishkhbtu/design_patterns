package com.designpattern.behaivoral.strategy;
interface Strategy {
    void execute();
}

class BubbleSortStartegy implements Strategy {
    @Override
    public void execute() {
        System.out.println("Bubble Sort Strategy");
    }
}

class MergeSortStrategy implements Strategy {
    @Override
    public void execute() {
        System.out.println("Merge Sort Strategy");
    }
}

class Context{
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStarategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void performTask(){
        strategy.execute();
    }
}
public class StrategyClient {
    public static void main(String[] args) {
        Strategy strategy = new MergeSortStrategy();
        Context context = new Context(strategy);
        context.performTask();
        context.setStarategy(new BubbleSortStartegy());
        context.performTask();
    }
}
