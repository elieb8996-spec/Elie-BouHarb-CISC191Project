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
 * Version/date: 04-07-2026
 * 
 * Responsibilities of class:Initializes and manages core game objects (Maze, Player).
 * 
 */
/**
 */
public class GameEngine {

    private Maze maze;
    private Player player;
    private ScoreTracker scoreTracker;

    /**
     * Constructor
     */
    public GameEngine(int rows, int cols) {
        maze = new Maze(rows, cols);
        maze.generateMaze();

        player = new Player(
                maze.getStartRow(),
                maze.getStartCol(),
                10 // starting health
        );

        scoreTracker = new ScoreTracker(); // initialize
    }

    // =========================
    // GETTERS
    // =========================
    public Maze getMaze() {
        return maze;
    }

    public Player getPlayer() {
        return player;
    }

    public ScoreTracker getScoreTracker() {
        return scoreTracker;
    }

    // =========================
    // RESET GAME
    // =========================
    public void resetGame() {
        maze.generateMaze();

        player = new Player(
                maze.getStartRow(),
                maze.getStartCol(),
                10
        );
        scoreTracker = new ScoreTracker(); // reset scores

    }
    
}