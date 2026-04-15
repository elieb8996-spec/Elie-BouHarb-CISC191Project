/**
 * Lead Author(s):
 * @author Elie BouHarb
 * @author 
 * <<add additional lead authors here, with a full first and last name>>
 * Other contributors:
 * <<add additional contributors (mentors, tutors, friends) here, with contact information>>
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * <<add more references here>>
 *  
 * Version/date: 04-13-2026
 * 
 * Responsibilities of class:Displays the starting screen and handles initial navigation.
 * 
 */
/**
 */


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainMenu extends JPanel {
    
    // We pass these so the buttons can trigger the screen swap
    private CardLayout layout;
    private JPanel container;

    public MainMenu(CardLayout layout, JPanel container) {
        this.layout = layout;
        this.container = container;
        
        // Match the mock-up's brown aesthetic
        this.setBackground(new Color(60, 40, 30));
        this.setLayout(new GridBagLayout()); // Centers the buttons
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Spacing between buttons

        // --- Start Game Button ---
        JButton startBtn = createMenuButton("Start Game");
        startBtn.addActionListener(e -> {
            // Switches to the game card
            layout.show(container, "GAME");
            // Focus is required for KeyListeners to work
            container.getComponent(1).requestFocusInWindow();
        });
        
        // --- Instructions Button ---
        JButton instructBtn = createMenuButton("Instructions");
        instructBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Use WASD to move. Collect keys to exit!");
        });

        // --- Exit Button ---
        JButton exitBtn = createMenuButton("Exit Game");
        exitBtn.addActionListener(e -> System.exit(0));

        // Add buttons to the panel
        gbc.gridy = 0; add(startBtn, gbc);
        gbc.gridy = 1; add(instructBtn, gbc);
        gbc.gridy = 2; add(exitBtn, gbc);
    }

    /**
     * Helper to style buttons similarly to the mock-up
     */
    private JButton createMenuButton(String text) {
        JButton btn = new JButton(text);
        btn.setPreferredSize(new Dimension(200, 50));
        btn.setFont(new Font("Serif", Font.BOLD, 18));
        btn.setBackground(new Color(139, 69, 19)); // Wooden Brown
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        return btn;
    }

    /**
     * MAIN METHOD: Acts as the entry point for the entire application.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Maze Escape Adventure");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            CardLayout cardLayout = new CardLayout();
            JPanel mainContainer = new JPanel(cardLayout);

            // Game setup
            Maze maze = new Maze(10, 10);
            maze.generateMaze();
            Player player = new Player(0, 0, 3);

            MazeGUI gameView = new MazeGUI(maze, player);
            new MazeController(maze, player, gameView);

            // Menu
            MainMenu menuView = new MainMenu(cardLayout, mainContainer);

            mainContainer.add(menuView, "MENU");
            mainContainer.add(gameView, "GAME");

            frame.add(mainContainer);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            cardLayout.show(mainContainer, "MENU");
        });
    }
}