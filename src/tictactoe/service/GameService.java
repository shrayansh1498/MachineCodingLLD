package src.tictactoe.service;
import src.tictactoe.entities.Game;
import src.tictactoe.entities.Player;
import src.tictactoe.enums.Symbol;

public class GameService {
    public Game createGame(String player1name, String player2name, int boardSize){
        Player player1 = new Player(player1name, Symbol.X);
        Player player2 = new Player(player2name, Symbol.O);
        Game game = new Game(player1, player2, boardSize);
        return game;
    }
    

}
