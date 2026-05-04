/**
 * Lead Author(s):
 * @author Elie BouHarb
 * @author 
 * * Other contributors:
 * * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * Oracle. “Abstract Classes.” Java Platform SE Documentation.
 * https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html
 *
 * Oracle. “Inheritance.” Java Platform SE Documentation.
 * https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html
 * Oracle. (n.d.). Graphics (Java Platform SE Documentation).
 * Retrieved from https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics.html
 *  Version/date: 05-04-2026
 *  Responsibilities of class: 
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 * Tile is an abstract base class.
 * 
 * A Tile IS-A game cell in the maze.
 * Each Tile defines its own behavior and rendering.
 */
public abstract class Tile {

    protected BufferedImage image;

    // =========================
    // CONSTRUCTOR (LOAD IMAGE)
    // =========================
    public Tile(String imagePath) {
        try {
            image = ImageIO.read(getClass().getResource(imagePath));
        } catch (Exception e) {
            image = null; // fallback mode
        }
    }

    // =========================
    // POLYMORPHIC DRAW
    // =========================
    public void draw(Graphics g, int x, int y, int size) {
        if (image != null) {
            g.drawImage(image, x, y, size, size, null);
        } else {
            drawFallback(g, x, y, size);
        }
    }

    protected abstract void drawFallback(Graphics g, int x, int y, int size);

    // =========================
    // GAME LOGIC (POLYMORPHIC)
    // =========================
    public abstract void onEnter(Player player);

    public boolean isWalkable() { return true; }

    public boolean isExit() { return false; }

    public boolean isOccupied() { return false; }
}
