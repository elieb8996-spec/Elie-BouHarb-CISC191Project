import java.util.Random;
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
 * Oracle. BufferedImage. Java Platform SE 8 Documentation
 * https://docs.oracle.com/javase/8/docs/api/java/awt/image/BufferedImage.html
 * Oracle. (n.d.). ImageIO (Java Platform SE Documentation).
 * Retrieved from https://docs.oracle.com/javase/8/docs/api/javax/imageio/ImageIO.html
 * Version/date: 05-04-2026
 * 
 * Responsibilities of class:
 * Represents maze layout, walls, traps, keys, exit
 *
 * Relationships:
 * Maze HAS-A 2D array of Tile objects.
 * Maze HAS-A starting position and total number of keys.
 */
	public class Maze {

	    // =========================
	    // HAS-A RELATIONSHIPS
	    // =========================
	    private Tile[][] grid;
	    private int totalKeys;
	    private int startRow, startCol;

	    public Maze(int rows, int cols) {
	        grid = new Tile[rows][cols];

	        // Fill with floor tiles
	        for (int r = 0; r < getRows(); r++) {
	            for (int c = 0; c < getCols(); c++) {
	                grid[r][c] = new FloorTile();
	            }
	        }
	    }

	    // =========================
	    // GENERATE MAZE
	    // =========================
	    public void generateMaze() {

	        Random rand = new Random();

	        totalKeys = 3;

	        // Start position
	        startRow = 0;
	        startCol = 0;

	        // ===== PLACE WALLS =====
	        for (int r = 0; r < getRows(); r++) {
	            for (int c = 0; c < getCols(); c++) {

	                if (rand.nextDouble() < 0.1) {
	                    grid[r][c] = new WallTile();
	                }
	            }
	        }

	        // Ensure start is always walkable
	        grid[startRow][startCol] = new FloorTile();

	        // ===== PLACE KEYS =====
	        for (int i = 0; i < totalKeys; i++) {
	            placeTileRandomly(new KeyTile());
	        }

	        // ===== PLACE TRAPS =====
	        for (int i = 0; i < 5; i++) {
	            placeTileRandomly(new TrapTile(1));
	        }

	        // ===== PLACE EXIT =====
	        placeTileRandomly(new ExitTile());
	    }

	    // =========================
	    // HELPER: SAFE PLACEMENT
	    // =========================
	    private void placeTileRandomly(Tile newTile) {

	        Random rand = new Random();
	        boolean placed = false;

	        while (!placed) {

	            int r = rand.nextInt(getRows());
	            int c = rand.nextInt(getCols());

	            Tile current = grid[r][c];

	            // POLYMORPHIC CHECKS (NO instanceof)
	            if (current.isWalkable() && !current.isOccupied()) {

	                grid[r][c] = newTile;
	                placed = true;
	            }
	        }
	    }

	    // =========================
	    // ACCESS METHODS
	    // =========================
	    public Tile getTile(int row, int col) {
	        return grid[row][col];
	    }

	    public boolean isValidMove(int row, int col) {

	        if (row < 0 || row >= getRows()) return false;
	        if (col < 0 || col >= getCols()) return false;

	        return grid[row][col].isWalkable();
	    }

	    // =========================
	    // DIMENSIONS (NO rows/cols fields)
	    // =========================
	    public int getRows() {
	        return grid.length;
	    }

	    public int getCols() {
	        return grid[0].length;
	    }

	    // =========================
	    // GETTERS
	    // =========================
	    public int getTotalKeys() {
	        return totalKeys;
	    }

	    public int getStartRow() {
	        return startRow;
	    }

	    public int getStartCol() {
	        return startCol;
	    }
	}

