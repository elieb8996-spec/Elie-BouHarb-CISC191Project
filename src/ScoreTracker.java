import java.util.ArrayList;

/**
 * Lead Author(s):
 * @author Elie BouHarb
 *
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Oracle. “Class ArrayList.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
 *
 * Version/date: 04-30-2026
 *
 * Responsibilities of class:
 * Tracks score and time, and stores score history using an ArrayList.
 */
public class ScoreTracker {

    private int currentScore;
    private int time; // in seconds

    // ✅ LO5: Collection used
    private ArrayList<Integer> scoreHistory;

    public ScoreTracker() {
        currentScore = 0;
        time = 0;
        scoreHistory = new ArrayList<>();
    }

    // =========================
    // UPDATE SCORE
    // =========================
    public void updateScore(Player player) {
        currentScore = player.getKeysCollected() * 10 + player.getHealth();
    }

    // =========================
    // SAVE SCORE TO HISTORY
    // =========================
    public void saveScore() {
        scoreHistory.add(currentScore);
    }

    // =========================
    // TIME TRACKING
    // =========================
    public void incrementTime() {
        time++;
    }

    // =========================
    // GETTERS
    // =========================
    public int getScore() {
        return currentScore;
    }

    public int getTime() {
        return time;
    }

    public ArrayList<Integer> getScoreHistory() {
        return scoreHistory;
    }

    public int getHighestScore() {
        int max = 0;
        for (int s : scoreHistory) {
            if (s > max) {
                max = s;
            }
        }
        return max;
    }
}