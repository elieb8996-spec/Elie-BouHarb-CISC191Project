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
 * Responsibilities of class:Represents each space in the maze (wall, key, trap)
 * 
 */
/**
 */
public class Tile {
    private boolean hasKey;
    private boolean hasTrap;
    private boolean isExit;
    private boolean isWall;

    public Tile() {
        this.hasKey = false;
        this.hasTrap = false;
        this.isExit = false;
        this.isWall = false;
    }

    public boolean hasKey() { return hasKey; }
    public void setKey(boolean key) { this.hasKey = key; }
    public void removeKey() { this.hasKey = false; }

    public boolean hasTrap() { return hasTrap; }
    public void setTrap(boolean trap) { this.hasTrap = trap; }

    public boolean isExit() { return isExit; }
    public void setExit(boolean exit) { this.isExit = exit; }

    public boolean isWall() { return isWall; }
    public void setWall(boolean wall) { this.isWall = wall; }
}