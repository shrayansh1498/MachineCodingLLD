package src.tictactoe.strategy;

import java.util.HashMap;
import java.util.Map;

import src.tictactoe.domain.Board;
import src.tictactoe.domain.Move;
import src.tictactoe.domain.enums.Symbol;

public class OrderOneWinningStrategy implements WinningStrategy {

    private Map<Symbol, int[]> rowCounts = new HashMap<>();
    private Map<Symbol, int[]> colCounts = new HashMap<>();
    private Map<Symbol, Integer> diagCounts = new HashMap<>();
    private Map<Symbol, Integer> antiDiagCounts = new HashMap<>();

    public OrderOneWinningStrategy(int boardSize){
        for(Symbol s : Symbol.values()){
            if(s != Symbol.Empty){
                rowCounts.put(s, new int[boardSize]);
                colCounts.put(s, new int[boardSize]);
                diagCounts.put(s, 0);
                antiDiagCounts.put(s, 0);
            }
        }
    }

    @Override 
    public boolean checkWin(Move move, Board board){
        int r = move.getRow();
        int c = move.getCol();
        Symbol symbol = move.getPlayer().getSymbol();
        int size = board.getBoardSize();

        int currentRowCount = ++rowCounts.get(symbol)[r];
        int currentColCount = ++colCounts.get(symbol)[c];
        int currentDiagCount = 0;
        if (r == c) {
            currentDiagCount = diagCounts.getOrDefault(symbol, 0) + 1;
            diagCounts.put(symbol, currentDiagCount);
        }

        int currentAntiDiagCount = 0;
        if (r + c == size - 1) {
            currentAntiDiagCount = antiDiagCounts.getOrDefault(symbol, 0) + 1;
            antiDiagCounts.put(symbol, currentAntiDiagCount);
        }
        return currentRowCount == size 
            || currentColCount == size 
            || currentDiagCount == size 
            || currentAntiDiagCount == size;
    }
}
