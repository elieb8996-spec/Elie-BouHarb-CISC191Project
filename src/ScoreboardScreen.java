import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
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
 * Oracle. “Class JPanel.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/javax/swing/JPanel.html
 *
 * Oracle. “Class ArrayList.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
 *
 * Oracle. “Class Collections.” Java Platform SE 8 Documentation.
 * https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html
 *
 * Version/date: 05-04-2026
 * 
 * Responsibilities of class:
 * Displays a scoreboard screen that loads scores from a text file,
 * sorts them in descending order, and shows the top results using a GUI.
 */
public class ScoreboardScreen extends JPanel {

    public ScoreboardScreen(CardLayout layout, JPanel container) {

        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        JLabel title = new JLabel("TOP SCORES", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setForeground(Color.WHITE);

        // Load scores
        ArrayList<Integer> scores = FileManager.loadScores();

        // Sort highest → lowest
        Collections.sort(scores, Collections.reverseOrder());

        JTextArea scoreArea = new JTextArea();
        scoreArea.setEditable(false);
        scoreArea.setBackground(Color.BLACK);
        scoreArea.setForeground(Color.GREEN);
        scoreArea.setFont(new Font("Monospaced", Font.BOLD, 18));

        StringBuilder sb = new StringBuilder();

        int limit = Math.min(10, scores.size());

        for (int i = 0; i < limit; i++) {
            sb.append((i + 1) + ". " + scores.get(i) + "\n");
        }

        if (scores.isEmpty()) {
            sb.append("No scores yet.");
        }

        scoreArea.setText(sb.toString());

        JButton backBtn = new JButton("Back to Menu");
        backBtn.addActionListener(e -> layout.show(container, "MENU"));

        add(title, BorderLayout.NORTH);
        add(new JScrollPane(scoreArea), BorderLayout.CENTER);
        add(backBtn, BorderLayout.SOUTH);
    }
}
