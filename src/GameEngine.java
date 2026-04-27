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
 * Oracle. “Class JFrame.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/javax/swing/JFrame.html
 *
 * Oracle. “Class JPanel.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/javax/swing/JPanel.html
 * 
 * <<add more references here>>
 *  
 * Version/date: 04-27-2026
 * 
 * Responsibilities of class:Initializes and manages core game objects (Maze, Player).
 * 
 */
/**
 */
/**
 * GameEngine HAS-A Maze and Player.
 * Handles core game logic.
 */
public class GameEngine {

    private Maze maze;
    private Player player;

    public GameEngine(Maze maze, Player player) {
        this.maze = maze;
        this.player = player;
    }

    // =========================
    // MOVE PLAYER
    // =========================
    public void movePlayer(int newRow, int newCol) {

        if (!maze.isValidMove(newRow, newCol)) return;

        player.moveTo(newRow, newCol);

        Tile tile = maze.getTile(newRow, newCol);
        tile.onEnter(player);
    }

    // =========================
    // WIN CONDITION
    // =========================
    public boolean checkWin() {
        Tile tile = maze.getTile(player.getRow(), player.getCol());
        return tile.isExit() && player.canExit(maze.getTotalKeys());
    }

    // =========================
    // LOSE CONDITION
    // =========================
    public boolean checkLose() {
        return !player.isAlive();
    }

    // =========================
    // GETTERS
    // =========================
    public Player getPlayer() {
        return player;
    }

    public Maze getMaze() {
        return maze;
    }
}
