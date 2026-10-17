package src.tictactoe.controller;
import src.tictactoe.domain.Game;
import src.tictactoe.domain.Move;
import src.tictactoe.domain.Player;
import src.tictactoe.domain.enums.GameStatus;
import src.tictactoe.service.GameService;
import src.tictactoe.view.GameView;

public class GameController {
    private final GameService gameService;
    private final GameView gameView;

    public GameController(GameService gameService, GameView gameView){
        this.gameService = gameService;
        this.gameView = gameView;
    }

    public void startGame(String player1name, String player2name, int boardSize){
        Game game = gameService.createGame(player1name, player2name, boardSize);

        while(game.getGameStatus() == GameStatus.IN_PROGRESS){
            Player currentPlayer = game.getCurrentPlayer();
            Move move = gameView.getPlayerMove(currentPlayer, game.getBoard());

            try{
                gameService.makeMove(game, move);
            }
            catch(IllegalArgumentException ex){
                gameView.printMessage(ex.getMessage());
            }
        }

        String message;
        gameView.printBoard(game.getBoard());

        if(game.getGameStatus() == GameStatus.WON){
            message = "Game is won by Player " + game.getWinner().getName();
        }
        else  message = "Game is Draw";

        gameView.printMessage(message);
    }    
}
