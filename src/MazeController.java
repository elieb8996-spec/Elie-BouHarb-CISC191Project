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
 * 
 * Oracle. “Class JFrame.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/javax/swing/JFrame.html
 *
 * Oracle. “Class JPanel.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/javax/swing/JPanel.html
 * Oracle. “Class KeyEvent.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/java/awt/event/KeyEvent.html
 * Oracle. “Class KeyAdapter.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/java/awt/event/KeyAdapter.html.
 *  
 * Version/date: 04-27-2026
 * 
 * Responsibilities of class:Handles player input, updates model and GUI
 * 
 */
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * MazeController HAS-A Maze, Player, and View.
 * Handles input and game flow using polymorphism.
 */
public class MazeController {

    private Maze maze;
    private Player player;
    private MazeGUI view;
    private MainMenu menu;

    public MazeController(Maze maze, Player player, MazeGUI view) {
        this.maze = maze;
        this.player = player;
        this.view = view;

        setupControls();
    }

    public void setMenu(MainMenu menu) {
        this.menu = menu;
    }

    private void setupControls() {

        view.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                int newRow = player.getRow();
                int newCol = player.getCol();

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W: newRow--; break;
                    case KeyEvent.VK_S: newRow++; break;
                    case KeyEvent.VK_A: newCol--; break;
                    case KeyEvent.VK_D: newCol++; break;
                    default: return;
                }

                // ===== VALID MOVE =====
                if (!maze.isValidMove(newRow, newCol)) return;

                // Move player
                player.moveTo(newRow, newCol);

                // ===== TILE INTERACTION =====
                Tile tile = maze.getTile(newRow, newCol);
                tile.onEnter(player);

                // ===== WIN CONDITION (NO instanceof) =====
                if (tile.isExit() && player.canExit(maze.getTotalKeys())) {
                    if (menu != null) {
                        menu.showGameOver("YOU WIN!");
                    }
                }

                // ===== LOSE CONDITION =====
                if (player.getHealth() <= 0) {
                    if (menu != null) {
                        menu.showGameOver("GAME OVER");
                    }
                }

                // Refresh
                view.repaint();
            }
        });

        view.setFocusable(true);
        view.requestFocusInWindow();
    }
}
