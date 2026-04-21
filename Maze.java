/**
 * Lead Author(s):
 * @author Elie BouHarb
 * 
 * Other contributors:
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * Oracle. “Class Random.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
 * 
 * Version/date: 04-20-2026
 * 
 * Responsibilities of class:
 * Represents maze layout, walls, traps, keys, exit
 */

import java.util.Random;

public class Maze {

    private Tile[][] grid;
    private int rows, cols;
    private int totalKeys;

    private int startRow, startCol;

    public Maze(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new Tile[rows][cols];

        // Default everything to FloorTile
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                grid[r][c] = new FloorTile();
    }

    public void generateMaze() {
        Random rand = new Random();

        totalKeys = 3;
        startRow = 0;
        startCol = 0;

        // ===== WALLS =====
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (rand.nextDouble() < 0.1) {
                    grid[r][c] = new WallTile();
                }
            }
        }

        grid[startRow][startCol] = new FloorTile();

        // ===== KEYS =====
        for (int i = 0; i < totalKeys; i++) {
            int r, c;
            do {
                r = rand.nextInt(rows);
                c = rand.nextInt(cols);
            } while (grid[r][c] instanceof WallTile);

            grid[r][c] = new KeyTile();
        }

        // ===== TRAPS =====
        for (int i = 0; i < 5; i++) {
            int r, c;
            do {
                r = rand.nextInt(rows);
                c = rand.nextInt(cols);
            } while (grid[r][c] instanceof WallTile);

            grid[r][c] = new TrapTile(1);
        }

        // ===== EXIT =====
        int r, c;
        do {
            r = rand.nextInt(rows);
            c = rand.nextInt(cols);
        } while (grid[r][c] instanceof WallTile);

        grid[r][c] = new ExitTile();
    }

    public Tile getTile(int r, int c) {
        return grid[r][c];
    }

    public boolean isValidMove(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols
                && !grid[r][c].isWall();
    }

    public int getRows() { return rows; }
    public int getCols() { return cols; }
    public int getTotalKeys() { return totalKeys; }

    public int getStartRow() { return startRow; }
    public int getStartCol() { return startCol; }

	public int getHealth() {
		
		return 3;
	}
}