package src.tictactoe.domain;

import src.tictactoe.domain.Player;
import src.tictactoe.domain.enums.GameStatus;
import src.tictactoe.domain.enums.Symbol;

import java.util.List;

public class Game {
    private List<Player> players;
    private Board board;
    private GameStatus gameStatus;
    private int currentPlayerIndex;
    private Symbol winner;

    public Game(Player player1, Player player2, int boardSize){
        //This is also valid
        //this.players = new ArrayList<>();
        // this.players.add(player1);
        // this.players.add(player2);
        this.players = List.of(player1, player2);

        this.board = new Board(boardSize);
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.currentPlayerIndex = 0;
    }

    public GameStatus getGameStatus(){
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus){
        this.gameStatus = gameStatus;
    }

    public void switchTurn(){
        currentPlayerIndex = 1-currentPlayerIndex;
    }

    public Player getCurrentPlayer(){
        return players.get(currentPlayerIndex);
    }

    public Board getBoard(){
        return board;
    }

    public void setWinner(Symbol winner){
        this.winner = winner;
    }

    public Symbol getWinner(){
        return winner;
    }

}
