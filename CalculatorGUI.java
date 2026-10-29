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


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    JTextField display;
    double num1, num2, result;
    char operator;

    public Calculator() {
        setTitle("Java Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.matches("[0-9]")) {
            display.setText(display.getText() + command);
        } else if (command.equals("C")) {
            display.setText("");
            num1 = 0;
            num2 = 0;
            result = 0;
        } else if (command.matches("[+\\-*/]")) {
            if (display.getText().isEmpty()) return;

            num1 = Double.parseDouble(display.getText());
            operator = command.charAt(0);
            display.setText("");
        } else if (command.equals("=")) {
            if (display.getText().isEmpty()) return;

            num2 = Double.parseDouble(display.getText());

            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/':
                    if (num2 == 0) {
                        display.setText("Cannot divide by zero");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }

            display.setText(String.valueOf(result));
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}


```java
import javax.swing.JOptionPane;

public class Calculator {
    public static void main(String[] args) {

        double num1, num2, result;
        String operator;

        num1 = Double.parseDouble(
            JOptionPane.showInputDialog("Enter the first number:")
        );

        num2 = Double.parseDouble(
            JOptionPane.showInputDialog("Enter the second number:")
        );

        operator = JOptionPane.showInputDialog(
            "Choose an operator:\n+ Addition\n- Subtraction\n* Multiplication\n/ Division"
        );

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;

            case "-":
                result = num1 - num2;
                break;

            case "*":
                result = num1 * num2;
                break;

            case "/":
                if (num2 == 0) {
                    JOptionPane.showMessageDialog(
                        null, "Error: Cannot divide by zero!"
                    );
                    return;
                }

                result = num1 / num2;
                break;

            default:
                JOptionPane.showMessageDialog(
                    null, "Invalid operator!"
                );
                return;
        }

        JOptionPane.showMessageDialog(
            null,
            "First Number: " + num1 +
            "\nOperator: " + operator +
            "\nSecond Number: " + num2 +
            "\nResult: " + result,
            "Calculator Result",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
```