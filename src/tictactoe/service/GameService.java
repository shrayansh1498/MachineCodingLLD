package src.tictactoe.service;
import src.tictactoe.domain.Board;
import src.tictactoe.domain.Game;
import src.tictactoe.domain.Move;
import src.tictactoe.domain.Player;
import src.tictactoe.domain.enums.GameStatus;
import src.tictactoe.domain.enums.Symbol;

public class GameService {
    private Player currentPlayer;
    private int row;
    private int col;
    private int boardSize;
    private Board board;
    private Symbol grid[][];
    private boolean isValid;
    private boolean flag;
    public Game createGame(String player1name, String player2name, int boardSize){
        this.boardSize = boardSize;
        Player player1 = new Player(player1name, Symbol.X);
        Player player2 = new Player(player2name, Symbol.O);
        Game game = new Game(player1, player2, boardSize);
        return game;
    }

    // public void makeMove(Game game, Move move){
    public void makeMove(Game game, int row, int col){
        // currentPlayer = move.getPlayer();
        // row = move.getRow();
        // col = move.getCol();

        currentPlayer = game.getCurrentPlayer();
        this.board = game.getBoard();

        isValid = board.isValid(row, col);

        if(!isValid){
            throw new IllegalArgumentException("Cell is already occupied or out of bounds.");
        }

        board.placeSymbol(row, col, currentPlayer.getSymbol());

        if(checkWin(row, col, currentPlayer.getSymbol())){
            game.setGameStatus(GameStatus.WON);
            game.setWinner(currentPlayer.getSymbol());
        }
        else if(board.isFull()){
            game.setGameStatus(GameStatus.DRAW);
        }
        else game.switchTurn();

    }

    public boolean checkWin(int row, int col, Symbol symbol){
        grid = board.getGrid();
        flag = true;
        for(int i=0;i<boardSize;i++){
            if(grid[i][col]!=symbol){
                flag=false;
                break;
            }
        }
        if(flag) return true;

        for(int i=0;i<boardSize;i++){
            if(grid[row][i]!=symbol){
                flag=false;
                break;
            }
        }
        if(flag) return true;

        if(row==col){
            for(int i=0;i<boardSize;i++){
                if(grid[i][i]!=symbol){
                    flag=false;
                    break;
                }
            }
            if(flag) return true;

            for(int i=0;i<boardSize;i++){
                if(grid[row][boardSize-i-1]!=symbol){
                    flag=false;
                    break;
                }
            }
        }
        return flag;

    }

}
