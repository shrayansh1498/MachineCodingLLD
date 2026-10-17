package src.tictactoe;

import java.util.Scanner;

import src.tictactoe.service.GameService;
import src.tictactoe.strategy.OrderOneWinningStrategy;
import src.tictactoe.view.ConsoleGameView;
import src.tictactoe.controller.GameController;

public class Main {
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter Player 1 name:");
        String player1 = scanner.nextLine();
        System.out.println("Enter Player 2 name:");
        String player2 = scanner.nextLine();
        System.out.println("Enter Board Size:");
        int size = scanner.nextInt();

        //GameService uses Standard O(N) strategy by default
        // GameService gameService = new GameService();
        GameService gameService = new GameService(new OrderOneWinningStrategy(size));
        ConsoleGameView adapter = new ConsoleGameView(scanner);
        GameController gameController = new GameController(gameService, adapter);
        
        gameController.startGame(player1, player2, size);

        scanner.close();
    }
}
