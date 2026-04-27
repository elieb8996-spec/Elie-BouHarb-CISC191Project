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
  Oracle. “Inheritance.” Java Platform SE Documentation.
 * https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html
 *
 * Oracle. “Method Overriding.” Java Platform SE Documentation.
 * https://docs.oracle.com/javase/tutorial/java/IandI/override.html
 *
 * Oracle. “Encapsulation.” Java Platform SE Documentation.
 * https://docs.oracle.com/javase/tutorial/java/javaOO/encapsulation.html
 * Oracle. (n.d.). Graphics (Java Platform SE Documentation).
 * Retrieved from https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics.html
 *Oracle. BufferedImage. Java Platform SE 8 Documentation 
 *https://docs.oracle.com/javase/8/docs/api/java/awt/image/BufferedImage.html
 * Version/date: 04-27-2026
 * 
 * Responsibilities of class:
 * 
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * KeyTile IS-A Tile
 * KeyTile HAS-A BufferedImage
 */
public class KeyTile extends Tile {

    private BufferedImage image;
    private boolean collected = false;

    public KeyTile(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void onEnter(Player player) {
        if (!collected) {
            player.collectKey();
            collected = true;
        }
    }

    @Override
    public void draw(Graphics g, int x, int y, int size) {
        if (!collected && image != null) {
            g.drawImage(image, x, y, size, size, null);
        }
    }
}
