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
 * Oracle. “Class JPanel.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/javax/swing/JPanel.html
 *
 * Oracle. “Class JButton.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/javax/swing/JButton.html
 *
 * Oracle. “Class JLabel.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/javax/swing/JLabel.html
 *
 * Oracle. “Class CardLayout.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/java/awt/CardLayout.html
 *
 * Oracle. “Class GridBagLayout.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/java/awt/GridBagLayout.html
 *
 * Oracle. “Class GridBagConstraints.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/java/awt/GridBagConstraints.html
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
 * Version/date: 04-20-2026
 * 
 * Responsibilities of class:
 * Displays the win/lose screen and allows the user to restart or return to menu.
 */

import javax.swing.*;
import java.awt.*;

public class GameOverScreen extends JPanel {

    private MazeGameGUI app;

    public GameOverScreen(CardLayout layout,
            JPanel container,
            String message,
            MainMenu menu,
            MazeGameGUI app) {

        this.app = app;

        setLayout(new GridBagLayout());
        setBackground(new Color(30, 30, 30));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        // ===== MESSAGE =====
        JLabel label = new JLabel(message);
        label.setFont(new Font("Arial", Font.BOLD, 28));
        label.setForeground(message.contains("WIN") ? Color.GREEN : Color.RED);

        // ===== BUTTONS =====
        JButton restartBtn = new JButton("Restart");
        JButton menuBtn = new JButton("Main Menu");

        // Restart game using MazeGameGUI
        restartBtn.addActionListener(e -> {
            if (app != null) {
                app.startGame();
            }
        });

        // Return to menu
        menuBtn.addActionListener(e -> layout.show(container, "MENU"));

        // ===== ADD COMPONENTS =====
        gbc.gridy = 0; add(label, gbc);
        gbc.gridy = 1; add(restartBtn, gbc);
        gbc.gridy = 2; add(menuBtn, gbc);
    }
}