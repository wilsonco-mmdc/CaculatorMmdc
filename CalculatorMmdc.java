import javax.swing.*;
import java.awt.*;

public class CalculatorMmdc{

    public static void main(String[] args) {
        // Set window size
        JFrame frame = new JFrame("Grade Calculator");
        frame.setSize(800, 350);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Initialize panels and labels
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label1 = new JLabel("Milestone 1 (25 points):");
        JLabel label2 = new JLabel("Milestone 2 (40 points):");
        JLabel label3 = new JLabel("Terminal Assessment (35 points):");

        // Create text fields for input
        JTextField milestone1Field = new JTextField(5);
        JTextField milestone2Field = new JTextField(5);
        JTextField terminalField = new JTextField(5);

        // Add components to panel
        panel.add(label1);
        panel.add(milestone1Field);
        panel.add(label2);
        panel.add(milestone2Field);
        panel.add(label3);
        panel.add(terminalField);

        // Button to calculate
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(e -> {
            try {
                // Get input values
                int milestone1 = Integer.parseInt(milestone1Field.getText());
                int milestone2 = Integer.parseInt(milestone2Field.getText());
                int terminal = Integer.parseInt(terminalField.getText());

                // Validate input
                if (milestone1 < 0 || milestone1 > 25) {
                    throw new IllegalArgumentException("Milestone 1 score must be between 0 and 25.");
                }
                if (milestone2 < 0 || milestone2 > 40) {
                    throw new IllegalArgumentException("Milestone 2 score must be between 0 and 40.");
                }
                if (terminal < 0 || terminal > 35) {
                    throw new IllegalArgumentException("Terminal Assessment score must be between 0 and 35.");
                }

                // Calculate total score and percentage
                double totalScore = milestone1 + milestone2 + terminal;
                double percentage = (totalScore / 100) * 100;

                // Display result
                JOptionPane.showMessageDialog(frame, "Your total score: " + totalScore + "\nPercentage: " + percentage + "%");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid numeric values.");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage());
            }
        });

        // Add button to panel
        panel.add(calculateButton);

        // Add panel to frame and show it
        frame.add(panel);
        frame.setVisible(true);
    }
}