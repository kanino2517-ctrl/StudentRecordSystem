import javax.swing.*;
import java.awt.*;

public class CalculatorGUI extends JFrame {

    public CalculatorGUI() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    JLabel label1, label2;
    JTextField text1, text2;
    JButton btnAdd, btnSub, btnMul, btnDiv;

    Calculator() {
        setTitle("Java Calculator");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 5, 5));

        // 2 JLabels
        label1 = new JLabel("First Number:");
        label2 = new JLabel("Second Number:");

        // 2 JTextFields
        text1 = new JTextField();
        text2 = new JTextField();

        // 4 Buttons
        btnAdd = new JButton("+");
        btnSub = new JButton("-");
        btnMul = new JButton("*");
        btnDiv = new JButton("/");

        // Add action listeners
        btnAdd.addActionListener(this);
        btnSub.addActionListener(this);
        btnMul.addActionListener(this);
        btnDiv.addActionListener(this);

        // Add components
        add(label1);
        add(text1);
        add(label2);
        add(text2);
        add(btnAdd);
        add(btnSub);
        add(btnMul);
        add(btnDiv);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double a = Double.parseDouble(text1.getText());
            double b = Double.parseDouble(text2.getText());
            double result = 0;

            if (e.getSource() == btnAdd) {
                result = a + b;
            } else if (e.getSource() == btnSub) {
                result = a - b;
            } else if (e.getSource() == btnMul) {
                result = a * b;
            } else if (e.getSource() == btnDiv) {
                if (b == 0) {
                    JOptionPane.showMessageDialog(
                        this, "Cannot divide by zero!");
                    return;
                }
                result = a / b;
            }

            JOptionPane.showMessageDialog(
                this, "Result: " + result);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this, "Please enter valid numbers!");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
