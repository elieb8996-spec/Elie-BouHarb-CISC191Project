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
 * Responsibilities of class:Draws the maze, player, keys, traps, exit
 * 
 */
/**
 */
import javax.swing.*;
import java.awt.*;

public class MazeGUI extends JPanel {
    private Maze maze;
    private Player player;
    private final int TILE_SIZE = 50; // size of each tile in pixels

    public MazeGUI(Maze maze, Player player) {
        this.maze = maze;
        this.player = player;
        setPreferredSize(new Dimension(maze.getCols() * TILE_SIZE, maze.getRows() * TILE_SIZE));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int r = 0; r < maze.getRows(); r++) {
            for (int c = 0; c < maze.getCols(); c++) {
                Tile tile = maze.getTile(r, c);

                // Determine tile color
                if (player.getRow() == r && player.getCol() == c) {
                    g.setColor(Color.BLUE); // Player
                } else if (tile.isWall()) {
                    g.setColor(Color.DARK_GRAY); // Wall
                } else if (tile.isExit()) {
                    g.setColor(Color.GREEN); // Exit
                } else if (tile.hasKey()) {
                    g.setColor(Color.YELLOW); // Key
                } else if (tile.hasTrap()) {
                    g.setColor(Color.RED); // Trap
                } else {
                    g.setColor(Color.LIGHT_GRAY); // Empty space
                }

                g.fillRect(c * TILE_SIZE, r * TILE_SIZE, TILE_SIZE, TILE_SIZE);

                // Draw grid lines
                g.setColor(Color.BLACK);
                g.drawRect(c * TILE_SIZE, r * TILE_SIZE, TILE_SIZE, TILE_SIZE);

                // Optional: Draw key/trap icons
                if (tile.hasKey()) {
                    g.setColor(Color.ORANGE);
                    g.fillOval(c * TILE_SIZE + 15, r * TILE_SIZE + 15, 20, 20);
                }
                if (tile.hasTrap()) {
                    g.setColor(Color.MAGENTA);
                    g.fillRect(c * TILE_SIZE + 15, r * TILE_SIZE + 15, 20, 20);
                }
            }
        }

        // Draw player's health and keys collected
        g.setColor(Color.BLACK);
        g.drawString("Health: " + player.getHealth(), 10, maze.getRows() * TILE_SIZE + 15);
        g.drawString("Keys: " + player.getKeysCollected() + " / " + maze.getTotalKeys(), 100, maze.getRows() * TILE_SIZE + 15);
    }
}