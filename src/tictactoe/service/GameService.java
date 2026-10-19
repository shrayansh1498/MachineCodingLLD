package src.TicTacToe.service;
import src.TicTacToe.domain.Board;
import src.TicTacToe.domain.Game;
import src.TicTacToe.domain.Move;
import src.TicTacToe.domain.Player;
import src.TicTacToe.domain.enums.GameStatus;
import src.TicTacToe.domain.enums.Symbol;
import src.TicTacToe.strategy.StandardWinningStrategy;
import src.TicTacToe.strategy.WinningStrategy;

public class GameService {

    private final WinningStrategy winningStrategy;

    // Default constructor uses Standard O(N) strategy
    public GameService(){
        this.winningStrategy = new StandardWinningStrategy();
    }

    // Constructor to inject any strategy (e.g. OrderOneWinningStrategy)
    public GameService(WinningStrategy winningStrategy){
        this.winningStrategy = winningStrategy;
    }

    public Game createGame(String player1name, String player2name, int boardSize){
        Player player1 = new Player(player1name, Symbol.X);
        Player player2 = new Player(player2name, Symbol.O);
        Game game = new Game(player1, player2, boardSize);
        return game;
    }

    public void makeMove(Game game, Move move){
    // public void makeMove(Game game, int row, int col){
        Player currentPlayer = move.getPlayer();
        int row = move.getRow();
        int col = move.getCol();

        // if(currentPlayer != game.getCurrentPlayer()){
        //     throw new Exception("Incorrect player made the move");
        // }
        Board board = game.getBoard();

        boolean isValid = board.isValid(row, col);

        if(!isValid){
            throw new IllegalArgumentException("Cell is already occupied or out of bounds.");
        }

        board.placeSymbol(row, col, currentPlayer.getSymbol());

        if(winningStrategy.checkWin(move, board)){
            game.setGameStatus(GameStatus.WON);
            game.setWinner(currentPlayer);
        }
        else if(board.isFull()){
            game.setGameStatus(GameStatus.DRAW);
        }
        else game.switchTurn();

    }

}
