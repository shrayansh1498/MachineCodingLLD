package src.tictactoe.entities;

import src.tictactoe.enums.Symbol;

public class Player {
    private final String name;
    private final Symbol symbol;

    public Player(String name, Symbol symbol){
        this.name = name;
        this.symbol = symbol;
    }

    public String getName(){
        return name;
    }
    public Symbol getsymbol(){
        return symbol;
    }
}   
