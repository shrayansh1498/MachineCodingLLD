package src.TicTacToe.view;

import src.TicTacToe.domain.Board;
import src.TicTacToe.domain.Move;
import src.TicTacToe.domain.Player;

public interface GameView {
    void printBoard(Board board);
    void printMessage(String message);
    Move getPlayerMove(Player player, Board board);
}
