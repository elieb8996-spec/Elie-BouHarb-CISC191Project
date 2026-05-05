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
 * Version/date: 05-04-2026
 * 
 * Responsibilities of class:
 * 
 */
import java.awt.*;

public class TrapTile extends Tile {

    private int damage;

    public TrapTile(int damage) {
        super("/assets/trap.png");
        this.damage = damage;
    }

    @Override
    public void onEnter(Player player) {
        player.takeDamage(damage);
    }

    @Override
    public boolean isOccupied() {
        return true;
    }

    @Override
    protected void drawFallback(Graphics g, int x, int y, int size) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x, y, size, size);
    }

    @Override
    public String getSymbol() {
        return "T";
    }
}