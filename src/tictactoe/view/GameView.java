package src.tictactoe.view;

import src.tictactoe.domain.Board;
import src.tictactoe.domain.Move;
import src.tictactoe.domain.Player;

public interface GameView {
    void printBoard(Board board);
    void printMessage(String message);
    Move getPlayerMove(Player player, Board board);
}
