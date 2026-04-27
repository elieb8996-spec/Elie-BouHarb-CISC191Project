/**
 * Lead Author(s):
 * @author Elie BouHarb
 * @author 
 * * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * Oracle. “Class SwingUtilities.” Java Platform SE 8 Documentation, Oracle, https://docs.oracle.com/javase/8/docs/api/javax/swing/SwingUtilities.html.
 * Oracle. “Class CardLayout.” Java Platform SE 8 Documentation, Oracle, https://docs.oracle.com/javase/8/docs/api/java/awt/CardLayout.html.
 * Oracle. “Class JFrame.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/javax/swing/JFrame.html
 * Oracle. “Class JPanel.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/javax/swing/JPanel.html
 * * Version/date: 04-13-2026
 * * Responsibilities of class: Runs game, initializes MVC components, and displays GUI. Main entry point. Manages the CardLayout 
 * to switch between the Main Menu and the Maze Game. Orchestrates the MVC components and manages screen transitions.
 */
import javax.swing.*;
import java.awt.*;

/**
 * MazeGameGUI runs the application and manages screen transitions.
 * MazeGameGUI HAS-A MainMenu, MazeGUI, GameEngine, and MazeController.
 */
public class MazeGameGUI {

    private JFrame frame;
    private CardLayout layout;
    private JPanel container;

    private GameEngine engine;
    private MazeGUI gameView;
    private MazeController controller;
    private MainMenu menu;

    public MazeGameGUI() {

        // =========================
        // WINDOW SETUP
        // =========================
        frame = new JFrame("Maze Escape Adventure");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        layout = new CardLayout();
        container = new JPanel(layout);

        // =========================
        // CREATE MENU
        // =========================
        menu = new MainMenu(layout, container);
        menu.setApp(this);

        container.add(menu, "MENU");

        // =========================
        // FINALIZE WINDOW
        // =========================
        frame.add(container);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        layout.show(container, "MENU");
    }

    // =========================
    // START / RESTART GAME
    // =========================
    public void startGame() {

        // 1. Create Maze
        Maze maze = new Maze(10, 10);
        maze.generateMaze();

        // 2. Create Player
        Player player = new Player(
                maze.getStartRow(),
                maze.getStartCol(),
                10
        );

        // 3. Create Engine (FIXED)
        engine = new GameEngine(maze, player);

        // 4. Create View
        gameView = new MazeGUI(maze, player);

        // 5. Create Controller
        controller = new MazeController(engine, gameView);
        controller.setMenu(menu);

        // 6. Replace GAME screen (prevents duplicates)
        container.add(gameView, "GAME");

        // 7. Show game
        layout.show(container, "GAME");

        // 8. Enable keyboard input
        gameView.requestFocusInWindow();
    }

    // =========================
    // MAIN METHOD
    // =========================
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MazeGameGUI());
    }
}
