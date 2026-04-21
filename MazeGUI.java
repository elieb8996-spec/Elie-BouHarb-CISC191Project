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
 * Version/date: 04-13-2026
 * 
 * Responsibilities of class:Draws the maze, player, keys, traps, exit
 * 
 */
/**
 */
import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * View: Displays the maze, tiles, and player using assets.
 */
public class MazeGUI extends JPanel {

    private Maze maze;
    private Player player;

    private int tileSize = 64;

    // Images (loaded from /assets/)
    private BufferedImage floorImg;
    private BufferedImage wallImg;
    private BufferedImage keyImg;
    private BufferedImage trapImg;
    private BufferedImage exitImg;
    private BufferedImage playerImg;

    public MazeGUI(Maze maze, Player player) {
        this.maze = maze;
        this.player = player;

        setPreferredSize(new Dimension(
                maze.getCols() * tileSize,
                maze.getRows() * tileSize
        ));

        setFocusable(true);
        requestFocusInWindow();

        loadImages();
    }

    // =========================
    // LOAD IMAGES FROM ASSETS
    // =========================
    private void loadImages() {
        try {
            floorImg = ImageIO.read(getClass().getResource("/assets/floor.png"));
            wallImg = ImageIO.read(getClass().getResource("/assets/wall.png"));
            keyImg = ImageIO.read(getClass().getResource("/assets/key.png"));
            trapImg = ImageIO.read(getClass().getResource("/assets/trap.png"));
            exitImg = ImageIO.read(getClass().getResource("/assets/door.png"));
            playerImg = ImageIO.read(getClass().getResource("/assets/player.png"));

            System.out.println("✅ Assets loaded successfully");
            System.out.println("Player image: " + playerImg);

        } catch (Exception e) {
            System.out.println("❌ Error loading assets (using fallback graphics)");
        }
    }

    // =========================
    // DRAW EVERYTHING
    // =========================
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // ===== DRAW MAZE =====
        for (int r = 0; r < maze.getRows(); r++) {
            for (int c = 0; c < maze.getCols(); c++) {

                Tile tile = maze.getTile(r, c);

                BufferedImage img = floorImg;

                if (tile instanceof WallTile) img = wallImg;
                else if (tile instanceof KeyTile) img = keyImg;
                else if (tile instanceof TrapTile) img = trapImg;
                else if (tile instanceof ExitTile) img = exitImg;

                int x = c * tileSize;
                int y = r * tileSize;

                if (img != null) {
                    g.drawImage(img, x, y, tileSize, tileSize, null);
                } else {
                    // ===== FALLBACK COLORS =====
                    if (tile instanceof WallTile) g.setColor(Color.DARK_GRAY);
                    else if (tile instanceof KeyTile) g.setColor(Color.YELLOW);
                    else if (tile instanceof TrapTile) g.setColor(Color.LIGHT_GRAY);
                    else if (tile instanceof ExitTile) g.setColor(new Color(139, 69, 19));
                    else g.setColor(Color.GRAY);

                    g.fillRect(x, y, tileSize, tileSize);
                }
            }
        }

        // ===== DRAW PLAYER (ALWAYS ON TOP) =====
        int px = player.getCol() * tileSize;
        int py = player.getRow() * tileSize;

        if (playerImg != null) {
            g.drawImage(playerImg, px, py, tileSize, tileSize, null);
        } else {
            // fallback player (blue circle)
            g.setColor(Color.BLUE);
            g.fillOval(px + 10, py + 10, tileSize - 20, tileSize - 20);
        }

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
