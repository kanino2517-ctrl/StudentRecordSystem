import javax.swing.*;
import java.awt.*;

public class StudentGUI extends JFrame {

    JTextField idField, nameField, courseField;
    JTextArea output;

    public StudentGUI() {
        setTitle("Student Management System");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Student ID:"));
        idField = new JTextField(20);
        add(idField);

        add(new JLabel("Student Name:"));
        nameField = new JTextField(20);
        add(nameField);

        add(new JLabel("Course:"));
        courseField = new JTextField(20);
        add(courseField);

        JButton addButton = new JButton("Add Student");
        add(addButton);

        output = new JTextArea(6, 30);
        output.setEditable(false);
        add(new JScrollPane(output));

        addButton.addActionListener(e -> {
            String id = idField.getText();
            String name = nameField.getText();
            String course = courseField.getText();

            if (id.isEmpty() || name.isEmpty() || course.isEmpty()) {
                JOptionPane.showMessageDialog(
                    this, "Please fill in all fields."
                );
            } else {
                output.append(
                    "ID: " + id +
                    ", Name: " + name +
                    ", Course: " + course + "\n"
                );

                idField.setText("");
                nameField.setText("");
                courseField.setText("");
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentGUI::new);
    }
}