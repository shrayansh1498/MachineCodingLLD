package src.tictactoe;

import java.util.Scanner;

import src.tictactoe.service.GameService;
import src.tictactoe.adapter.GameAdapter;
import src.tictactoe.controller.GameController;

public class Main {
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);

        GameService gameService = new GameService();
        GameAdapter adapter = new GameAdapter(scanner);
        GameController gameController = new GameController(gameService, adapter);
        
        System.out.println("Enter Player 1 name:");
        String player1 = scanner.nextLine();
        System.out.println("Enter Player 2 name:");
        String player2 = scanner.nextLine();
        System.out.println("Enter Board Size:");
        int size = scanner.nextInt();
        
        gameController.initializeGame(player1, player2, size);

        scanner.close();
    }
}
