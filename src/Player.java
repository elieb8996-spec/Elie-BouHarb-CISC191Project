/**
 * Lead Author(s):
 * @author Elie BouHarb
 *  
 * <<add additional lead authors here, with a full first and last name>>
 * 
 * Other contributors:
 * <<add additional contributors (mentors, tutors, friends) here, with contact information>>
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * 
 * None (pure logic class, no external libraries used)
 *  
 * Version/date: 04-07-2026
 * 
 * Responsibilities of class:Store player position, move in the maze, collect keys
 * 
 */
/**
 */
public class Player {

    private int row, col;
    private int health;
    private int keysCollected;

    public Player(int row, int col, int health) {
        this.row = row;
        this.col = col;
        this.health = health;
        this.keysCollected = 0;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }

    public int getHealth() { return health; }

    public int getKeysCollected() { return keysCollected; }

    public void moveTo(int r, int c) {
        row = r;
        col = c;
    }

    public void collectKey() {
        keysCollected++;
    }

    public void takeDamage(int dmg) {
        health -= dmg;
    }
    public boolean canExit(int totalKeys) {
        return keysCollected == totalKeys;
    }
}
