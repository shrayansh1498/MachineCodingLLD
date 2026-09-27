package src.tictactoe.entities;
import src.tictactoe.enums.Symbol;

public class Board {
    private final int size;
    private Symbol[][] grid;

    Board(int size){
        this.size = size;
        this.grid = new Symbol[size][size];
    }
}
