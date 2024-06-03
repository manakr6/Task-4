/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javafinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class GuessGame extends JFrame implements ActionListener {

    private JTextField guessField;
    private JButton guessButton;
    private JLabel resultLabel;
    private int number;
    private int K;
    private int remainingTrials;

    public GuessGame() {
        setTitle("Number Guessing Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null); // Center the window
        setLayout(new FlowLayout());

        // Generate the number
        number = 1 + (int) (100 * Math.random());
        K = 5;
        remainingTrials = K;

        JLabel titleLabel = new JLabel("A number is chosen between 1 to 100. Guess the number within 5 trials.");
        add(titleLabel);

        guessField = new JTextField(10);
        add(guessField);

        guessButton = new JButton("Guess");
        guessButton.addActionListener(this);
        add(guessButton);

        resultLabel = new JLabel();
        add(resultLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == guessButton) {
            int guess;
            try {
                guess = Integer.parseInt(guessField.getText());
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input. Please enter a valid number.");
                return;
            }

            remainingTrials--;

            if (number == guess) {
                resultLabel.setText("Congratulations! You guessed the number.");
                guessButton.setEnabled(false);
            } else if (remainingTrials > 0) {
                if (number > guess) {
                    resultLabel.setText("The number is greater than " + guess + ". Remaining trials: " + remainingTrials);
                } else {
                    resultLabel.setText("The number is less than " + guess + ". Remaining trials: " + remainingTrials);
                }
            } else {
                resultLabel.setText("You have exhausted all trials. The number was " + number);
                guessButton.setEnabled(false);
            }

            guessField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GuessGame();
            }
        });
    }
}
