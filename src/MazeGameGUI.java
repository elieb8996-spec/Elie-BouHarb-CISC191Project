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

        // Create Maze
        Maze maze = new Maze(10, 10);
        maze.generateMaze();

        //  Create Player
        Player player = new Player(
                maze.getStartRow(),
                maze.getStartCol(),
                10
        );

        //  Create Engine 
        engine = new GameEngine(maze, player);

        //  Create View
        gameView = new MazeGUI(maze, player);

        //  Create Controller
        controller = new MazeController(engine, gameView);
        controller.setMenu(menu);

        // Replace GAME screen (prevents duplicates)
        container.add(gameView, "GAME");

        // Show game
        layout.show(container, "GAME");

        // Enable keyboard input
        gameView.requestFocusInWindow();
    }

    // =========================
    // MAIN METHOD
    // =========================
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MazeGameGUI());
    }
}
