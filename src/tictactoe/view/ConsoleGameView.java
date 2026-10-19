package src.TicTacToe.view;

import java.util.Scanner;

import src.TicTacToe.domain.Board;
import src.TicTacToe.domain.Move;
import src.TicTacToe.domain.Player;

public class ConsoleGameView implements GameView {
    private Scanner scanner;

    public ConsoleGameView(Scanner scanner){
        this.scanner = scanner;
    }

    public Move getPlayerMove(Player player, Board board){

        printBoard(board);
        System.out.println(player.getName() + " with Symbol " + player.getSymbol() + ", please enter row and column number of your move:");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        return new Move(player, row, col);
    }

    public void printBoard(Board board){
        int size = board.getBoardSize();

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(board.getGridSymbol(i, j) + " ");
            }
            System.out.println();
        }
    }

    public void printMessage(String message){
        System.out.println(message);
    }
}
