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
 * Version/date: 04-7-2026
 * 
 * Responsibilities of class:Represent maze layout, walls, traps, keys, exit
 * 
 */
/**
 */
public class Maze {
    private Tile[][] grid;
    private int startRow, startCol;
    private int exitRow, exitCol;

    // Constructor
    public Maze(int rows, int cols) {
        grid = new Tile[rows][cols];
        generateMaze();
    }

    private void generateMaze() {
        // Fill grid with walls and empty tiles, place exit, keys, and traps
        // (simplified for proposal)
        startRow = 0;
        startCol = 0;
        exitRow = grid.length - 1;
        exitCol = grid[0].length - 1;
    }

    public boolean isWalkable(int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && !grid[row][col].isWall();
    }

    public boolean hasKey(int row, int col) { return grid[row][col].hasKey(); }
    public void collectKey(int row, int col) { grid[row][col].setKey(false); }

    public boolean hasTrap(int row, int col) { return grid[row][col].hasTrap(); }
    public int triggerTrap(int row, int col) { return grid[row][col].triggerTrap(); }

    public int getStartRow() { return startRow; }
    public int getStartCol() { return startCol; }
    public int getExitRow() { return exitRow; }
    public int getExitCol() { return exitCol; }

    public int totalKeys() {
        int count = 0;
        for (Tile[] row : grid) {
            for (Tile t : row) {
                if (t.hasKey()) count++;
            }
        }
        return count;
    }
}