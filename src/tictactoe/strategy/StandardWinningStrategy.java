package src.tictactoe.strategy;

import src.tictactoe.domain.Board;
import src.tictactoe.domain.Move;
import src.tictactoe.domain.enums.Symbol;

public class StandardWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkWin(Move move, Board board){
        Symbol symbol = move.getPlayer().getSymbol();
        int row = move.getRow();
        int col = move.getCol();
        int boardSize = board.getBoardSize();

        
        boolean colFlag = true;

        for(int i=0;i<boardSize;i++){
            if(board.getGridSymbol(i, col)!=symbol){
                colFlag=false;
                break;
            }
        }
        if(colFlag) return true;
        
        boolean rowFlag = true;

        for(int i=0;i<boardSize;i++){
            if(board.getGridSymbol(row, i)!=symbol){
                rowFlag=false;
                break;
            }
        }
        if(rowFlag) return true;

        if(row==col){
            boolean diagFlag = true;
        
            for(int i=0;i<boardSize;i++){
                if(board.getGridSymbol(i, i)!=symbol){
                    diagFlag=false;
                    break;
                }
            }
            if(diagFlag) return true;
        }
        
        
        if(row + col == boardSize - 1){
            boolean antiDiagFlag = true;
            for(int i=0;i<boardSize;i++){
                if(board.getGridSymbol(i, boardSize-i-1)!=symbol){
                    antiDiagFlag=false;
                    break;
                }
            }
            return antiDiagFlag;
        }
            
        return false;
    }
    
}
