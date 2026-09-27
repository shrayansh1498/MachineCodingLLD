package src.tictactoe.model;
import src.tictactoe.enums.Symbol;

public class Board {
    private final int size;
    private Symbol[][] grid;

    public Board(int size){
        this.size = size;
        this.grid = new Symbol[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                grid[i][j]=Symbol.Empty;
            }
        }
    }
}
