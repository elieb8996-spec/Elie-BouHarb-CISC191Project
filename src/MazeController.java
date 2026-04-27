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
 * MazeController HAS-A GameEngine and MazeGUI.
 * Handles keyboard input and updates the game.
 */
public class MazeController {

    private GameEngine engine;
    private MazeGUI view;
    private MainMenu menu;

    public MazeController(GameEngine engine, MazeGUI view) {
        this.engine = engine;
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

                int newRow = engine.getPlayer().getRow();
                int newCol = engine.getPlayer().getCol();

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W: newRow--; break;
                    case KeyEvent.VK_S: newRow++; break;
                    case KeyEvent.VK_A: newCol--; break;
                    case KeyEvent.VK_D: newCol++; break;
                    default: return;
                }

                // Move player THROUGH ENGINE
                engine.movePlayer(newRow, newCol);

                // ===== WIN CHECK =====
                if (engine.checkWin()) {
                    if (menu != null) {
                        menu.showGameOver("YOU WIN!");
                    }
                }

                // ===== LOSE CHECK =====
                if (engine.checkLose()) {
                    if (menu != null) {
                        menu.showGameOver("GAME OVER");
                    }
                }

                view.repaint();
            }
        });

        view.setFocusable(true);
        view.requestFocusInWindow();
    }
}
