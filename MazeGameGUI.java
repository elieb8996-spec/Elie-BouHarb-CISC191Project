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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

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

        // 🔥 CRITICAL FIX
        menu.setApp(this);

        container.add(menu, "MENU");

        // =========================
        // INITIAL ENGINE (optional)
        // =========================
        engine = new GameEngine(10, 10);

        // =========================
        // FINALIZE WINDOW
        // =========================
        frame.add(container);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Show menu first
        layout.show(container, "MENU");
    }

    // =========================
    // START / RESTART GAME
    // =========================
    public void startGame() {

        // Reset engine (fresh game)
        engine = new GameEngine(10, 10);

        // Create new view
        gameView = new MazeGUI(
                engine.getMaze(),
                engine.getPlayer()
        );

        // Create controller
        controller = new MazeController(
                engine.getMaze(),
                engine.getPlayer(),
                gameView
        );

        // Allow controller to trigger GameOver
        controller.setMenu(menu);

        // =========================
        // REPLACE GAME SCREEN (prevents duplicates)
        // =========================
        container.add(gameView, "GAME");

        // Switch to game
        layout.show(container, "GAME");

        // REQUIRED for keyboard input
        gameView.requestFocusInWindow();
    }

    // =========================
    // MAIN METHOD
    // =========================
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MazeGameGUI());
    }
}