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
 * Version/date: 04-20-2026
 * 
 * Responsibilities of class:
 * Represents maze layout, walls, traps, keys, exit
 */

import java.util.Random;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * Maze HAS-A 2D array of Tile objects.
 * Maze is responsible for generating the game world.
 */
public class Maze {

    private Tile[][] grid;
    private int rows, cols;
    private int totalKeys;

    private int startRow, startCol;

    // Tile images (shared across all tiles)
    private BufferedImage floorImg;
    private BufferedImage wallImg;
    private BufferedImage keyImg;
    private BufferedImage trapImg;
    private BufferedImage exitImg;

    public Maze(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        grid = new Tile[rows][cols];

        loadAssets();
        initializeFloor();
    }

    // =========================
    // LOAD IMAGES FROM /assets
    // =========================
    private void loadAssets() {
        try {
            floorImg = ImageIO.read(getClass().getResource("/assets/floor.png"));
            wallImg = ImageIO.read(getClass().getResource("/assets/wall.png"));
            keyImg = ImageIO.read(getClass().getResource("/assets/key.png"));
            trapImg = ImageIO.read(getClass().getResource("/assets/trap.png"));
            exitImg = ImageIO.read(getClass().getResource("/assets/door.png"));
        } catch (Exception e) {
            System.out.println("⚠ Failed to load assets in Maze");
        }
    }

    // =========================
    // INITIALIZE FLOOR
    // =========================
    private void initializeFloor() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = new FloorTile(floorImg);
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

        // ===== WALLS =====
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (rand.nextDouble() < 0.15 && !(r == startRow && c == startCol)) {
                    grid[r][c] = new WallTile(wallImg);
                }
            }
        }

        // ===== KEYS =====
        int keysPlaced = 0;
        while (keysPlaced < totalKeys) {

            int r = rand.nextInt(rows);
            int c = rand.nextInt(cols);

            if (grid[r][c].isWalkable() && !(r == startRow && c == startCol)) {
                grid[r][c] = new KeyTile(keyImg);
                keysPlaced++;
            }
        }

        // ===== TRAPS =====
        for (int i = 0; i < (rows * cols) / 10; i++) {

            int r = rand.nextInt(rows);
            int c = rand.nextInt(cols);

            if (grid[r][c].isWalkable() && !(r == startRow && c == startCol)) {
                grid[r][c] = new TrapTile(trapImg, 1);
            }
        }

        // ===== EXIT =====
        while (true) {
            int r = rand.nextInt(rows);
            int c = rand.nextInt(cols);

            if (grid[r][c].isWalkable() && !(r == startRow && c == startCol)) {
                grid[r][c] = new ExitTile(exitImg);
                break;
            }
        }
    }

    // =========================
    // GET TILE
    // =========================
    public Tile getTile(int row, int col) {
        return grid[row][col];
    }

    // =========================
    // VALID MOVE (NO instanceof)
    // =========================
    public boolean isValidMove(int newrow, int newcol) {
        return newrow >= 0 && newrow < rows &&
               newcol >= 0 && newcol < cols &&
               grid[newrow][newcol].isWalkable();
    }

    // =========================
    // GETTERS
    // =========================
    public int getRows() { return rows; }
    public int getCols() { return cols; }
    public int getTotalKeys() { return totalKeys; }

    public int getStartRow() { return startRow; }
    public int getStartCol() { return startCol; }
}
