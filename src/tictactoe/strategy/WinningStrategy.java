package src.tictactoe.strategy;

import src.tictactoe.domain.Board;
import src.tictactoe.domain.Move;

public interface WinningStrategy {
    boolean checkWin(Move move, Board board);
}
