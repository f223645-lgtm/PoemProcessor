import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class AssignRootsGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AssignRootsGUI::createGUI);
    }

    private static void createGUI() {
        // Create main frame
        JFrame frame = new JFrame("Assign Roots Task");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // Title
        JLabel title = new JLabel("Assign Roots to Verse", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(title, BorderLayout.NORTH);

        // Text area for poem input
        JTextArea poemArea = new JTextArea(10, 40);
        poemArea.setLineWrap(true);
        poemArea.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(poemArea);
        frame.add(scroll, BorderLayout.CENTER);

        // Panel with buttons
        JPanel panel = new JPanel();
        JButton rootsBtn = new JButton("Assign Roots");
        JButton clearBtn = new JButton("Clear");
        panel.add(rootsBtn);
        panel.add(clearBtn);
        frame.add(panel, BorderLayout.SOUTH);

        // Action: Assign Roots button
        rootsBtn.addActionListener(e -> {
            String text = poemArea.getText().trim();
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a poem!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Simple root extraction (lowercase + remove punctuation)
            String[] words = text.split("\\s+");
            String[] roots = Arrays.stream(words)
                    .map(w -> w.toLowerCase().replaceAll("[^a-z]", ""))
                    .toArray(String[]::new);

            JOptionPane.showMessageDialog(frame, "Roots of each word:\n" + Arrays.toString(roots));
        });

        // Action: Clear button
        clearBtn.addActionListener(e -> poemArea.setText(""));

        frame.setVisible(true);
    }
}
