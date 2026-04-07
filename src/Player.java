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
 * <<add more references here>>
 *  
 * Version/date: 04-07-2026
 * 
 * Responsibilities of class:Store player position, move in the maze, collect keys
 * 
 */
/**
 */
public class Player {
    private int row;
    private int col;
    private int health;
    private int keysCollected;

    // Constructor
    public Player(int startRow, int startCol) {
        this.row = startRow;
        this.col = startCol;
        this.health = 100;
        this.keysCollected = 0;
    }

    // Methods
    public void move(String direction, Maze maze) {
        // Basic movement logic with boundary checks
        switch (direction.toLowerCase()) {
            case "up":
                if (maze.isWalkable(row - 1, col)) row--;
                break;
            case "down":
                if (maze.isWalkable(row + 1, col)) row++;
                break;
            case "left":
                if (maze.isWalkable(row, col - 1)) col--;
                break;
            case "right":
                if (maze.isWalkable(row, col + 1)) col++;
                break;
        }
        interactWithTile(maze);
    }

    private void interactWithTile(Maze maze) {
        if (maze.hasKey(row, col)) {
            keysCollected++;
            maze.collectKey(row, col);
        }
        if (maze.hasTrap(row, col)) {
            health -= maze.triggerTrap(row, col);
        }
    }

    public boolean hasReachedExit(Maze maze) {
        return row == maze.getExitRow() && col == maze.getExitCol() && keysCollected >= maze.totalKeys();
    }

    // Getters
    public int getRow() { return row; }
    public int getCol() { return col; }
    public int getHealth() { return health; }
    public int getKeysCollected() { return keysCollected; }
}