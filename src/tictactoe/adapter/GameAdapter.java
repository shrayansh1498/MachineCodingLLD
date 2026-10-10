package src.tictactoe.adapter;

import src.tictactoe.domain.Move;
import src.tictactoe.domain.Player;
import src.tictactoe.domain.enums.Symbol;

import java.util.Scanner;

import src.tictactoe.domain.Board;

public class GameAdapter {
    private int row;
    private int col;
    private Scanner scanner;

    public GameAdapter(Scanner scanner){
        this.scanner = scanner;
    }

    public Move getPlayerMove(Player player, Board board){

        printBoard(board);
        System.out.println(player.getName() + " with Symbol " + player.getSymbol() + ", please enter row and column number of your move:");
        row = scanner.nextInt();
        col = scanner.nextInt();

        return new Move(player, row, col);
    }

    private void printBoard(Board board){
        int size = board.getBoardSize();
        Symbol grid[][] = board.getGrid();

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printMessage(String message){
        System.out.println(message);
    }
}
