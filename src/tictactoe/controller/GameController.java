package src.tictactoe.controller;
import src.tictactoe.domain.Game;
import src.tictactoe.domain.Move;
import src.tictactoe.domain.Player;
import src.tictactoe.domain.enums.GameStatus;
import src.tictactoe.service.GameService;

public class GameController {
    private GameService gameService;
    // private String player1name;
    // private String player2name;
    // private int boardSize;
    private Game game;
    private Player currentPlayer;

    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    public void initializeGame(String player1name, String player2name, int boardSize){
        // this.player1name = player1name;
        // this.player2name = player2name;
        // this.boardSize = boardSize;
        this.game = gameService.createGame(player1name, player2name, boardSize);

        while(game.getGameStatus() == GameStatus.IN_PROGRESS){
            currentPlayer = game.getCurrentPlayer();
            Move move = new Move(currentPlayer, row, col);

            try{
                gameService.makeMove(game, move);
            }
            catch(Exception ex){
                System.out.println("Invalid move, please make a valid move");
            }
            
        }
    }    
}
