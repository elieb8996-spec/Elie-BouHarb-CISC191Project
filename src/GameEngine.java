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
 * Responsibilities of class:Generate maze, track player movement, update game state
 * 
 */
/**
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameEngine extends JFrame {
    private GameEngine engine;
    private JPanel mazePanel;
    private JLabel statusLabel;

    private final int CELL_SIZE = 40; // pixels per cell

    public GameEngine(int rows, int cols) {
        engine = new GameEngine(rows, cols);

        setTitle("Maze Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Maze drawing panel
        mazePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawMaze(g);
            }
        };
        mazePanel.setPreferredSize(new Dimension(cols * CELL_SIZE, rows * CELL_SIZE));
        add(mazePanel, BorderLayout.CENTER);

        // Status label
        statusLabel = new JLabel("Score: 0");
        add(statusLabel, BorderLayout.SOUTH);

        // Key listener for movement
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String dir = null;
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP: dir = "UP"; break;
                    case KeyEvent.VK_DOWN: dir = "DOWN"; break;
                    case KeyEvent.VK_LEFT: dir = "LEFT"; break;
                    case KeyEvent.VK_RIGHT: dir = "RIGHT"; break;
                }
                if (dir != null) {
                    engine.movePlayer(dir);
                    statusLabel.setText("Score: " + engine.getScoreTracker().getScore());
                    mazePanel.repaint();

                    if (engine.isGameOver()) {
                        JOptionPane.showMessageDialog(GameEngine.this, "You Win!");
                    }
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        // Focus for key events
        mazePanel.setFocusable(true);
        mazePanel.requestFocusInWindow();
    }

    private void drawMaze(Graphics g) {
        Maze maze = engine.getMaze();
        Player player = engine.getPlayer();

        for (int r = 0; r < maze.getRows(); r++) {
            for (int c = 0; c < maze.getCols(); c++) {
                if (maze.isWall(r, c)) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(c * CELL_SIZE, r * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                g.setColor(Color.GRAY);
                g.drawRect(c * CELL_SIZE, r * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }

        // Draw player
        g.setColor(Color.RED);
        g.fillOval(player.getCol() * CELL_SIZE + 5, player.getRow() * CELL_SIZE + 5,
                   CELL_SIZE - 10, CELL_SIZE - 10);

        // Draw exit
        g.setColor(Color.GREEN);
        int exitRow = maze.getExitRow();
        int exitCol = maze.getExitCol();
        g.fillRect(exitCol * CELL_SIZE + 10, exitRow * CELL_SIZE + 10, CELL_SIZE - 20, CELL_SIZE - 20);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameEngine(10, 10));
    }
}

    public ScoreTracker getScoreTracker() {
        return scoreTracker;
    }
}
