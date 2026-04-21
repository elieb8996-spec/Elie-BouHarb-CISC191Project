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
 *  
 * Version/date: 04-07-2026
 * 
 * Responsibilities of class:Tracks score, time, and updates points
 * 
 */
/**
 */
public class ScoreTracker {
    private int score;
    private int time; // in seconds

    public ScoreTracker() {
        score = 0;
        time = 0;
    }

    public void updateScore(Player player) {
        score = player.getKeysCollected() * 10 + player.getHealth();
    }

    public void incrementTime() { time++; }

    public int getScore() { return score; }
    public int getTime() { return time; }
}