package src.tictactoe.service;
import src.tictactoe.enums.Symbol;
import src.tictactoe.model.Game;
import src.tictactoe.model.Player;
import src.tictactoe.model.Move;
import src.tictactoe.model.Board;

public class GameService {
    private Player currentPlayer;
    private int row;
    private int col;
    private Board board;
    private boolean isValid;
    public Game createGame(String player1name, String player2name, int boardSize){
        Player player1 = new Player(player1name, Symbol.X);
        Player player2 = new Player(player2name, Symbol.O);
        Game game = new Game(player1, player2, boardSize);
        return game;
    }

    public void makeMove(Game game, Move move){
        currentPlayer = move.getPlayer();
        row = move.getRow();
        col = move.getCol();

        board = game.getBoard();

        isValid = board.isValid(row, col);

        if(!isValid){
            throw new IllegalArgumentException("Cell is already occupied or out of bounds.");
        }

        board.placeSymbol(row, col, currentPlayer.getSymbol());

    }

}
