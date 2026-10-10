package src.tictactoe;

import src.tictactoe.service.GameService;
import src.tictactoe.domain.Game;
import src.tictactoe.domain.Player;

public class main {
    public static void main(String []args){
        GameService gameService = new GameService();
        Game game = gameService.createGame("Virat", "Rohit", 3);
        Player currentplayer;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                gameService.makeMove(game, i, j);
            }
        }

    }
}
