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
 * Responsibilities of class:Represents each space in the maze (wall, key, trap)
 * 
 */
/**
 */
public class UserInterface {
    private GameEngine engine;

    public UserInterface(GameEngine engine) {
        this.engine = engine;
    }

    public void displayMaze() {
        Maze maze = engine.getMaze();
        Player player = engine.getPlayer();
        // Print maze grid to console or render in GUI
        // (Proposal can just include a placeholder)
    }

    public void showScore() {
        System.out.println("Score: " + engine.getScoreTracker().getScore());
        System.out.println("Health: " + engine.getPlayer().getHealth());
        System.out.println("Keys: " + engine.getPlayer().getKeysCollected());
    }

    public void handleInput(String direction) {
        engine.movePlayer(direction);
    }
}
