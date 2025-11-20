import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddPoemGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AddPoemGUI::createGUI);
    }

    private static void createGUI() {
        // Create main frame
        JFrame frame = new JFrame("Add Poem Task");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // Title
        JLabel title = new JLabel("Enter Your Poem Below", SwingConstants.CENTER);
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
        JButton submitBtn = new JButton("Submit Poem");
        JButton clearBtn = new JButton("Clear");
        panel.add(submitBtn);
        panel.add(clearBtn);
        frame.add(panel, BorderLayout.SOUTH);

        // Action: Submit button
        submitBtn.addActionListener(e -> {
            String poem = poemArea.getText().trim();
            if (poem.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a poem!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Poem submitted successfully:\n\n" + poem);
            }
        });

        // Action: Clear button
        clearBtn.addActionListener(e -> poemArea.setText(""));

        frame.setVisible(true);
    }
}
