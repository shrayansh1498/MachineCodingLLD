package src.tictactoe.entities;
import src.tictactoe.entities.Player;

public class Game {
    private Player player1;
    private Player player2;
    private Board board;

    public Game(Player player1, Player player2, int boardSize){
        this.player1=player1;
        this.player2=player2;
        this.board = new Board(boardSize);
    }
}
