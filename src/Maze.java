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
import java.util.Random;

public class Maze {
    private Tile[][] grid;
    private int rows;
    private int cols;
    private int totalKeys;

    public Maze(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new Tile[rows][cols];
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                grid[r][c] = new Tile();
    }

    // --- Existing methods ---

    public void generateMaze() {
        Random rand = new Random();
        totalKeys = 3;

        
            // 1. Fill with walls/paths (Your existing logic)
     // Place walls randomly
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (rand.nextDouble() < 0.1) grid[i][j].setWall(true);

        // Place keys
        for (int i = 0; i < totalKeys; i++) {
            int r, c;
            do {
                r = rand.nextInt(rows); c = rand.nextInt(cols);
            } while (grid[r][c].isWall() || grid[r][c].hasKey());
            grid[r][c].placeKey();
        }

        // Place traps
        for (int i = 0; i < 4; i++) {
            int r, c;
            do {
                r = rand.nextInt(rows); c = rand.nextInt(cols);
            } while (grid[r][c].isWall() || grid[r][c].hasKey());
            grid[r][c].placeTrap(1);
        }

        // Place exit
        int r, c;
        do {
            r = rand.nextInt(rows); c = rand.nextInt(cols);
        } while (grid[r][c].isWall() || grid[r][c].hasKey());
        grid[r][c].setExit(true);
        
            
            // 2. Scatter Keys
            int keysPlaced = 0;
            while (keysPlaced < totalKeys) {
                int r1 = (int) (Math.random() * rows);
                int c1 = (int) (Math.random() * cols);
                if (!grid[r1][c1].isWall() && !grid[r1][c1].hasKey() && !grid[r1][c1].isExit()) {
                    grid[r1][c1].placeKey();
                    keysPlaced++;
                }
            }

            // 3. Scatter Traps
            for (int i = 0; i < (rows * cols) / 10; i++) { // Place traps on ~10% of tiles
                int r1 = (int) (Math.random() * rows);
                int c1 = (int) (Math.random() * cols);
                if (!grid[r1][c1].isWall() && !grid[r1][c1].hasKey() && !grid[r1][c1].isExit()) {
                    grid[r1][c1].placeTrap(1); // Deals 1 damage
                }
            }
        }

    public Tile getTile(int row, int col) { return grid[row][col]; }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols && !grid[row][col].isWall();
    }

    public int getTotalKeys() { return totalKeys; }

    // --- NEW METHODS ---
    public int getRows() { return rows; }

    public int getCols() { return cols; }
}
