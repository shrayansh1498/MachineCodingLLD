package src.tictactoe.controller;
import src.tictactoe.adapter.GameAdapter;
import src.tictactoe.domain.Game;
import src.tictactoe.domain.Move;
import src.tictactoe.domain.Player;
import src.tictactoe.domain.enums.GameStatus;
import src.tictactoe.service.GameService;

public class GameController {
    private GameService gameService;
    private GameAdapter adapter;
    private Game game;
    private Player currentPlayer;
    private Move move;
    private String message;

    public GameController(GameService gameService, GameAdapter adapter){
        this.gameService = gameService;
        this.adapter = adapter;
    }

    public void initializeGame(String player1name, String player2name, int boardSize){
        this.game = gameService.createGame(player1name, player2name, boardSize);

        while(game.getGameStatus() == GameStatus.IN_PROGRESS){
            currentPlayer = game.getCurrentPlayer();
            move = adapter.getPlayerMove(currentPlayer, game.getBoard());

            try{
                gameService.makeMove(game, move.getRow(), move.getCol());
            }
            catch(Exception ex){
                adapter.printMessage("Invalid move, please make a valid move");
            }
            
        }
        
        if(game.getGameStatus() == GameStatus.WON){
            message = "Game is won by Player " + currentPlayer;
        }
        else  message = "Game is Draw";

        adapter.printMessage(message);
    }    
}
