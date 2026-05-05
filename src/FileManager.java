import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Lead Author(s):
 * @author Elie BouHarb
 * 
 * References:
 * Oracle. “Class FileWriter.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/java/io/FileWriter.html
 *
 * Oracle. “Class Scanner.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html
 *
 * Version/date: 04-30-2026
 *
 * Responsibilities of class:
 * Handles saving and loading scores from a text file.
 */
public class FileManager {

    private static final String FILE_NAME = "scores.txt";

    // =========================
    // SAVE SCORE
    // =========================
    public static void saveScore(int score) {
        try {
            FileWriter writer = new FileWriter(FILE_NAME, true);
            writer.write(score + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving score.");
        }
    }

    // =========================
    // LOAD SCORES
    // =========================
    public static ArrayList<Integer> loadScores() {

        ArrayList<Integer> scores = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(FILE_NAME));

            while (scanner.hasNextInt()) {
                scores.add(scanner.nextInt());
            }

            scanner.close();

        } catch (IOException e) {
            System.out.println("No previous scores found.");
        }

        return scores;
    }
}
