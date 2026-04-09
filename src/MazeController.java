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
 * <<add more references here>>
 *  
 * Version/date: 04-07-2026
 * 
 * Responsibilities of class:Handles player input, updates model and GUI
 * 
 */
/**
 */
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MazeController {
    public MazeController(Maze maze, Player player, MazeGUI gui) {
        gui.setFocusable(true);
        gui.addKeyListener(new KeyAdapter() {
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

                if (maze.isValidMove(newRow, newCol)) {
                    player.moveTo(newRow, newCol);

                    Tile t = maze.getTile(newRow, newCol);
                    if (t.hasKey()) { player.collectKey(); t.removeKey(); }
                    if (t.hasTrap()) { player.takeDamage(1); }
                    if (t.isExit() && player.getKeysCollected() == maze.getTotalKeys()) {
                        JOptionPane.showMessageDialog(gui, "You escaped the maze!");
                        System.exit(0);
                    }
                    if (player.getHealth() <= 0) {
                        JOptionPane.showMessageDialog(gui, "You died! Game over.");
                        System.exit(0);
                    }

                    gui.repaint();
                }
                Tile t = maze.getTile(newRow, newCol);
                if (t.hasKey()) {
                    player.collectKey();
                    t.removeKey(); // collects the Key
                }
                if (t.hasTrap()) {
                    player.takeDamage(t.getTrap().getDamage());
                }
            }
        });
    }
}