/**
 * Lead Author(s):
 * @author Elie BouHarb
 * @author 
 * * Other contributors:
 * * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * * Version/date: 04-07-2026
 * * Responsibilities of class: Represents each space in the maze (wall, key, trap)
 */
public class Tile {
    private boolean hasKey;
    private boolean hasTrap;
    private boolean isExit;
    private boolean isWall;
    private int trapDamage; // Added to handle the 'int' from your error

    public Tile() {
        this.hasKey = false;
        this.hasTrap = false;
        this.isExit = false;
        this.isWall = false;
        this.trapDamage = 0;
    }

    // Key Logic
    public boolean hasKey() { return hasKey; }
    public void setKey(boolean key) { this.hasKey = key; }
    public void removeKey() { this.hasKey = false; }
    
    public void placeKey() {
        if (!isWall) {
            this.hasKey = true;
        }
    }

    // Trap Logic
    public boolean hasTrap() { return hasTrap; }
    public void setTrap(boolean trap) { this.hasTrap = trap; }
    
    /**
     * Fixes the "Undefined" error in Maze.java
     * @param damage The amount of damage or type of trap
     */
    public void placeTrap(int damage) {
        if (!isWall) {
            this.hasTrap = true;
            this.trapDamage = damage;
        }
    }

    public int getTrapDamage() {
        return trapDamage;
    }

    // Wall and Exit Logic
    public boolean isExit() { return isExit; }
    public void setExit(boolean exit) { this.isExit = exit; }

    public boolean isWall() { return isWall; }
    public void setWall(boolean wall) { 
        this.isWall = wall;
        // If it's a wall, it shouldn't logically contain items or traps
        if (wall) {
            this.hasKey = false;
            this.hasTrap = false;
        }
    }

    /**
     * Retrieves the trap data. 
     * returns an Integer representing damage if a trap exists, 
     * or null if there is no trap.
     */
    public Object getTrap() {
        if (this.hasTrap) {
            return (Integer) this.trapDamage; 
        }
        return null;
    }
}
