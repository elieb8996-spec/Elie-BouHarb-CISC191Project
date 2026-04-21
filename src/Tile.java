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
 *  Version/date: 04-20-2026
 *  Responsibilities of class: Defines the base behavior for all tile types using polymorphism.
 */
public abstract class Tile {

    public boolean isWall() {
        return false;
    }

    public boolean isExit() {
        return false;
    }

    public void onEnter(Player player) {
        // Default: do nothing
    }

    public String getSymbol() {
        return ".";
    }
}