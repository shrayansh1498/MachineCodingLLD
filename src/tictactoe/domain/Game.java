package src.tictactoe.domain;

import src.tictactoe.domain.Player;
import src.tictactoe.domain.enums.GameStatus;

public class Game {
    private Player player1;
    private Player player2;
    private Board board;
    private GameStatus gameStatus;
    private Player currentPlayer;

    public Game(Player player1, Player player2, int boardSize){
        this.player1=player1;
        this.player2=player2;
        this.board = new Board(boardSize);
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.currentPlayer = player1;
    }

    public GameStatus getGameStatus(){
        return gameStatus;
    }

    public void setCurrentPlayer(Player currentPlayer){
        this.currentPlayer = currentPlayer;
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    public Board getBoard(){
        return board;
    }

}
