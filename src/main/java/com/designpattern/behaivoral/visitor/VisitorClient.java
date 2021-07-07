package com.designpattern.behaivoral.visitor;
abstract class ChessComponent{
    String name;

    public ChessComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract void accept(Visitor v);
}

class Piece extends ChessComponent{
    String color;

    public Piece(String name, String color) {
        super(name);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    void accept(Visitor v) {
        v.visitPiece(this);
    }
}

class BoardBlock extends ChessComponent{
    String color;
    Piece piece;

    public BoardBlock(String name, String color, Piece piece) {
        super(name);
        this.color = color;
        this.piece = piece;
    }

    public String getColor() {
        return color;
    }

    public Piece getPiece() {
        return piece;
    }

    void accept(Visitor v){
        v.visitBoardBlock(this);
    }

    @Override
    public String toString() {
        return "BoardBlock{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", piece=" + piece +
                '}';
    }
}

interface Visitor{
    void visitPiece(Piece piece);
    void visitBoardBlock(BoardBlock boardBlock);
}

class ConcreteVisitor implements Visitor{

    @Override
    public void visitPiece(Piece piece) {
        System.out.println(piece);
    }

    @Override
    public void visitBoardBlock(BoardBlock boardBlock) {
        System.out.println(boardBlock);
    }
}
public class VisitorClient {
    public static void main(String[] args) {
        ChessComponent queen = new Piece("Queen", "White");
        ChessComponent block1 = new BoardBlock("B11", "Black", ((Piece) queen));

        Visitor visitor = new ConcreteVisitor();
        queen.accept(visitor);
        block1.accept(visitor);
    }
}
