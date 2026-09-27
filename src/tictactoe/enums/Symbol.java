package src.tictactoe.enums;

public enum Symbol {
    X('X'),
    O('O'),
    Empty('_');

    private final char symbol;

    Symbol(char symbol){
        this.symbol=symbol;
    }

    public char getSymbol(){
        return symbol;
    }
}
