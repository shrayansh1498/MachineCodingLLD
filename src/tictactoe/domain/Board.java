package src.tictactoe.domain;
import src.tictactoe.domain.enums.Symbol;

public class Board {
    private final int boardSize;
    private Symbol[][] grid;
    private int filledCells = 0;

    public Board(int boardSize){
        this.boardSize = boardSize;
        this.grid = new Symbol[boardSize][boardSize];
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                grid[i][j]=Symbol.Empty;
            }
        }
    }

    public boolean isValid(int row, int col){
        if(row<0 || row>=boardSize || col<0 || col>=boardSize)
            return false;
        else if (grid[row][col] != Symbol.Empty)
            return false;
        else return true;
            
    }

    public void placeSymbol(int row, int col, Symbol symbol){
        grid[row][col] = symbol;
        filledCells++;
    }

    public Symbol getGridSymbol(int row, int col){
        return grid[row][col];
    }

    public int getBoardSize(){
        return boardSize;
    }

    public boolean isFull(){
        return filledCells == boardSize*boardSize;
    }
}
