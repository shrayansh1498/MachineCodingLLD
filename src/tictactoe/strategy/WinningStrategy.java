package src.TicTacToe.strategy;

import src.TicTacToe.domain.Board;
import src.TicTacToe.domain.Move;

public interface WinningStrategy {
    boolean checkWin(Move move, Board board);
}
