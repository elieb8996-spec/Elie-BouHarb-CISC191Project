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
 * Version/date: 04-20-2026
 * 
 * Responsibilities of class:
 * 
 */
public class TrapTile extends Tile {

    private int damage;

    public TrapTile(int damage) {
        this.damage = damage;
    }

    @Override
    public void onEnter(Player player) {
        player.takeDamage(damage);
    }

    @Override
    public String getSymbol() {
        return "T";
    }
}
