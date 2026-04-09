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
 * Responsibilities of class:Runs game and displays GUI
 * 
 */
/**
 */
import javax.swing.*;

public class MazeGameGUI {
    public static void main(String[] args) {
        Maze maze = new Maze(5, 5);
        maze.generateMaze();
        Player player = new Player(0, 0, 3);

        MazeGUI gui = new MazeGUI(maze, player);
        MazeController controller = new MazeController(maze, player, gui);

        JFrame frame = new JFrame("Maze Escape Adventure");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gui);
        frame.pack();
        frame.setVisible(true);
    }
}