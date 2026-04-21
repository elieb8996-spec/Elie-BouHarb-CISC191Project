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
import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {

        Maze maze = new Maze(10, 10);
        maze.generateMaze();

        Player player = new Player(
                maze.getStartRow(),
                maze.getStartCol(),
                10
        );

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== MAZE GAME (Console Mode) ===");
        System.out.println("Use W A S D to move. Collect keys and reach exit.");

        while (player.getHealth() > 0) {

            printMaze(maze, player);

            System.out.print("Move (W/A/S/D): ");
            String input = scanner.nextLine().toUpperCase();

            int newRow = player.getRow();
            int newCol = player.getCol();

            // ===== MOVEMENT =====
            switch (input) {
                case "W": newRow--; break;
                case "S": newRow++; break;
                case "A": newCol--; break;
                case "D": newCol++; break;
                default:
                    System.out.println("Invalid input!");
                    continue;
            }

            // ===== VALID MOVE =====
            if (!maze.isValidMove(newRow, newCol)) {
                System.out.println("You hit a wall!");
                continue;
            }

            // Move player
            player.moveTo(newRow, newCol);

            // ===== POLYMORPHIC TILE INTERACTION =====
            Tile tile = maze.getTile(newRow, newCol);
            tile.onEnter(player);

            // ===== WIN CONDITION =====
            if (tile.isExit() &&
                player.getKeysCollected() == maze.getTotalKeys()) {

                System.out.println("🎉 YOU WIN!");
                break;
            }

            // ===== LOSE CONDITION =====
            if (player.getHealth() <= 0) {
                System.out.println("💀 GAME OVER");
                break;
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