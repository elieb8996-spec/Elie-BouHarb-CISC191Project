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
 *  Version/date: 04-27-2026
 *  Responsibilities of class: 
 */
import java.awt.Graphics;

/**
 * Tile IS-A base abstract class.
 */
public abstract class Tile {

    public abstract void onEnter(Player player);

    public abstract void draw(Graphics g, int x, int y, int size);

    public abstract String getSymbol();

    public boolean isWalkable() {
        return true;
    }
}
