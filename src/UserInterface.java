/**
 * Lead Author(s):
 * @author Elie BouHarb
 * @author 
 * <<add additional lead authors here, with a full first and last name>>
 * 
 * Other contributors:
 * <<add additional contributors (mentors, tutors, friends) here, with contact information>>
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * Oracle. “Class Scanner.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html
 *  
 * Version/date: 04-21-2026
 * 
 * Responsibilities of class:Provides console-based interaction using Scanner for input.
 * 
 */
/**
 */
 // Relationships:
 //UserInterface HAS-A GameEngine.
import java.util.Scanner;

/**
 * UserInterface provides a console-based version of the game.
 * It is used for testing and debugging the Maze logic.
 * 
 * UserInterface HAS-A Maze and Player.
 */
public class UserInterface {

    public static void main(String[] args) {

        // ===== SETUP =====
        Maze maze = new Maze(10, 10);
        maze.generateMaze();

        Player player = new Player(
                maze.getStartRow(),
                maze.getStartCol(),
                10
        );

        GameEngine engine = new GameEngine(maze, player);

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== MAZE GAME (Console Mode) ===");
        System.out.println("Use W A S D to move. Collect keys and reach exit.");

        boolean running = true;

        while (running) {

            printMaze(maze, player);

            System.out.print("Move (W/A/S/D): ");
            String input = scanner.nextLine().toUpperCase();

            int newRow = player.getRow();
            int newCol = player.getCol();

            // ===== CLEAN MOVEMENT (NO continue) =====
            if (input.equals("W")) newRow--;
            else if (input.equals("S")) newRow++;
            else if (input.equals("A")) newCol--;
            else if (input.equals("D")) newCol++;
            else {
                System.out.println("Invalid input!");
            }

            // Move through engine ONLY
            engine.movePlayer(newRow, newCol);

            // ===== WIN / LOSE (NO instanceof) =====
            if (engine.checkWin()) {
                printMaze(maze, player);
                System.out.println("🎉 YOU WIN!");
                engine.endGame();
                running = false;
            }
            else if (engine.checkLose()) {
                printMaze(maze, player);
                System.out.println("💀 GAME OVER");
                engine.endGame();
                running = false;
            }
        }

        scanner.close();
    }

    // =========================
    // PRINT MAZE
    // =========================
    private static void printMaze(Maze maze, Player player) {

        for (int r = 0; r < maze.getRows(); r++) {
            for (int c = 0; c < maze.getCols(); c++) {

                if (r == player.getRow() && c == player.getCol()) {
                    System.out.print("P ");
                } else {
                    System.out.print(maze.getTile(r, c).getSymbol() + " ");
                }
            }
            System.out.println();
        }

        System.out.println("Health: " + player.getHealth() +
                           " | Keys: " + player.getKeysCollected());
    }
}