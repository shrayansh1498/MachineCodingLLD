package src.TicTacToe.domain;

import java.util.List;

import src.TicTacToe.domain.enums.GameStatus;
import src.TicTacToe.domain.enums.Symbol;

public class Game {
    private List<Player> players;
    private Board board;
    private GameStatus gameStatus;
    private int currentPlayerIndex;
    private Player winner;

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

    public void setWinner(Player winner){
        this.winner = winner;
    }

    public Player getWinner(){
        return winner;
    }

}
