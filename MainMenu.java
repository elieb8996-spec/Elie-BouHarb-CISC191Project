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
 * Oracle. “Class JPanel.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/javax/swing/JPanel.html
 *
 * Oracle. “Class JButton.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/javax/swing/JButton.html
 *
 * Oracle. “Class JOptionPane.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/javax/swing/JOptionPane.html
 *
 * Oracle. “Class GridBagLayout.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/java/awt/GridBagLayout.html
 *
 * Oracle. “Class GridBagConstraints.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/java/awt/GridBagConstraints.html
 *
 * Oracle. “Class Insets.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/java/awt/Insets.html
 *
 * Oracle. “Class Color.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html
 *
 * Oracle. “Class Font.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/java/awt/Font.html
 *
 * Oracle. “Interface ActionListener.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/java/awt/event/ActionListener.html
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



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class MainMenu extends JPanel {

    private CardLayout layout;
    private JPanel container;

    // Reference to main application
    private MazeGameGUI app;

    public MainMenu(CardLayout layout, JPanel container) {
        this.layout = layout;
        this.container = container;

        setBackground(new Color(60, 40, 30));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        // ===== START BUTTON =====
        JButton startBtn = createMenuButton("Start Game");
        startBtn.addActionListener(e -> startGame());

        // ===== INSTRUCTIONS BUTTON =====
        JButton instructBtn = createMenuButton("Instructions");
        instructBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "Controls:\nW = Up\nS = Down\nA = Left\nD = Right\n\n" +
                    "Collect all keys and reach the exit!");
        });

        // ===== EXIT BUTTON =====
        JButton exitBtn = createMenuButton("Exit Game");
        exitBtn.addActionListener(e -> System.exit(0));

        gbc.gridy = 0; add(startBtn, gbc);
        gbc.gridy = 1; add(instructBtn, gbc);
        gbc.gridy = 2; add(exitBtn, gbc);
    }

    // =========================
    // SET APP REFERENCE
    // =========================
    public void setApp(MazeGameGUI app) {
        this.app = app;
    }

    // =========================
    // START GAME (delegates to MazeGameGUI)
    // =========================
    public void startGame() {
        if (app != null) {
            app.startGame();
        }
    }

    // =========================
    // GAME OVER SCREEN
    // =========================
    public void showGameOver(String message) {

    	GameOverScreen endScreen =
    		    new GameOverScreen(layout, container, message, this, app);

        container.add(endScreen, "END");
        layout.show(container, "END");
        }


    // =========================
    // BUTTON STYLE
    // =========================
    private JButton createMenuButton(String text) {
        JButton btn = new JButton(text);
        btn.setPreferredSize(new Dimension(200, 50));
        btn.setFont(new Font("Serif", Font.BOLD, 18));
        btn.setBackground(new Color(139, 69, 19));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        return btn;
    }
}