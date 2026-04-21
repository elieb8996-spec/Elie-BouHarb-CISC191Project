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
 *  None (pure logic class, no external libraries used)
 *  
 * Version/date: 04-07-2026
 * 
 * Responsibilities of class:Represents collectible key
 * 
 */
/**
 */
public class Key {
    private boolean collected;

    public Key() {
        collected = false;
    }

    public boolean isCollected() { return collected; }
    public void collect() { collected = true; }
}
