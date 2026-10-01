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

    public boolean isValid(int row, int col){
        if(row<0 || row>=size || col<0 || col>=size)
            return false;
        else if (grid[row][col] != Symbol.Empty)
            return false;
        else return true;
            
    }
}
