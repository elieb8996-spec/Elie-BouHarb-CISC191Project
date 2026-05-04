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
 *Oracle. “Class JPanel.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/javax/swing/JPanel.html
 *
 * Oracle. “Class Graphics.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics.html
 *
 * Oracle. “Class Color.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html
 *
 * Oracle. “Class Font.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/java/awt/Font.html
 *
 * Oracle. “Class Dimension.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/java/awt/Dimension.html
 *  
 * Version/date: 05-04-2026
 * 
 * Responsibilities of class:Draws the maze, player, keys, traps, exit
 * 
 */
/**
 */
import javax.swing.*;
import java.awt.*;

/**
 * Responsibilities of class:
 * Displays the maze and player using polymorphic Tile rendering.
 */
public class MazeGUI extends JPanel {

    private Maze maze;
    private Player player;

    private int tileSize = 64;

    public MazeGUI(Maze maze, Player player) {
        this.maze = maze;
        this.player = player;

        setPreferredSize(new Dimension(
                maze.getCols() * tileSize,
                maze.getRows() * tileSize
        ));

        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // ===== DRAW MAZE (POLYMORPHIC) =====
        for (int r = 0; r < maze.getRows(); r++) {
            for (int c = 0; c < maze.getCols(); c++) {

                Tile tile = maze.getTile(r, c);

                tile.draw(g, c * tileSize, r * tileSize, tileSize);
            }
        }

        // ===== DRAW PLAYER =====
        int px = player.getCol() * tileSize;
        int py = player.getRow() * tileSize;

        g.setColor(Color.BLUE);
        g.fillOval(px + 10, py + 10, tileSize - 20, tileSize - 20);

        // ===== HUD =====
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 16));

        g.drawString(
                "Health: " + player.getHealth() +
                "   Keys: " + player.getKeysCollected(),
                10, 20
        );
    }
}
