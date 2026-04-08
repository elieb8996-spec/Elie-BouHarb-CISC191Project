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
 * 
 * <<add more references here>>
 *  
 * Version/date: 04-07-2026
 * 
 * Responsibilities of class:Generate maze, track player movement, update game state
 * 
 */
/**
 */
public class GameEngine {
    private Maze maze;
    private Player player;
    private ScoreTracker scoreTracker;
    private boolean gameOver;

    // Constructor
    public GameEngine(int rows, int cols) {
        this.maze = new Maze(rows, cols);
        this.player = new Player(maze.getStartRow(), maze.getStartCol());
        this.scoreTracker = new ScoreTracker();
        this.gameOver = false;
    }

    // Methods
    public void movePlayer(String direction) {
        if (!gameOver) {
            player.move(direction, maze);
            scoreTracker.updateScore(player);
            checkGameState();
        }
    }

    private void checkGameState() {
        if (player.hasReachedExit(maze)) {
            gameOver = true;
            System.out.println("You Win!");
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public Maze getMaze() {
        return maze;
    }

    public Player getPlayer() {
        return player;
    }

    public ScoreTracker getScoreTracker() {
        return scoreTracker;
    }
}
