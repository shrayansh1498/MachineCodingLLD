package src.TicTacToe.domain.enums;

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

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }

    /* 
        We can keep Symbol as a pure enum
        If we don't care about mapping to a primitive char, we can delete symbol, the constructor, and getSymbol() entirely:

        java
        package src.tictactoe.domain.enums;
        public enum Symbol {
            X,
            O,
            Empty
        }
    */
}