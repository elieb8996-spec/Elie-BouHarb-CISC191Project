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
 * Oracle. (n.d.). Graphics (Java Platform SE Documentation).
 * Retrieved from https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics.html
 * Oracle. BufferedImage. Java Platform SE 8 Documentation
 * https://docs.oracle.com/javase/8/docs/api/java/awt/image/BufferedImage.html
 *Version/date: 04-20-2026
 *Responsibilities of class:
 *
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * ExitTile IS-A Tile
 * ExitTile HAS-A BufferedImage
 */
public class ExitTile extends Tile {

    private BufferedImage image;

    public ExitTile(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void onEnter(Player player) {
        // Win logic handled in controller
    }

    @Override
    public void draw(Graphics g, int x, int y, int size) {
        if (image != null)
            g.drawImage(image, x, y, size, size, null);
    }
}
