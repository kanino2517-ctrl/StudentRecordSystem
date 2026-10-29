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