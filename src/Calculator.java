// import everything related to java.swing, java.awt and java.awt.event

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


// Implement actionPerformed method
public class Calculator implements ActionListener {

    // Declare everything that we need
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;

    // declare the font to use
    Font myFont = new Font("Serif", Font.BOLD, 27);

    // declare a few double values
    double num1 = 0, num2 = 0, result = 0;
    // holds the operator
    char operator;

    // Constructor
    Calculator() {

        // gives the window a title
        frame = new JFrame("Calculator");
        // allows us to close out of the program
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // sets the size of the window
        frame.setSize(420, 550);
        frame.setLayout(null);

        // instantiate textField variable
        textField = new JTextField();
        textField.setText("0");
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);


        addButton = new JButton("+");
        subButton = new JButton("-");
        divButton = new JButton("/");
        mulButton = new JButton("*");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("DELETE");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-/+)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = divButton;
        functionButtons[3] = mulButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        // use for loop to iterate through the array of function buttons
        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        // Delete and clear button not on the JPanel that has a grid layout, so bounds are set separately
        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        // JPanel holds all the different buttons
        // Finish instantiating the JPanel, declared at the top already
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        //panel.setBackground(Color.green);


        // Add buttons to the grid
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        // Add button to frame
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);

    }

    public static void main(String[] args) {

        // Instantiating a Calculator object
        Calculator calc = new Calculator();
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        for (int i = 0; i < 10; i++) {
            if (actionEvent.getSource() == numberButtons[i]) {
                // If textField = 0, replace with new input otherwise concatenate new input
                if (textField.getText().equals("0")) {
                    textField.setText(String.valueOf(i));
                }
                else {
                    textField.setText(textField.getText().concat((String.valueOf(i))));
                }
            }

        }


        // verifies whether the event source is the decimal button
        if (actionEvent.getSource() == decButton) {
            // explicit: if textField does not contain a decimal, then add a decimal
            // implicit: if textField contains a decimal, then don't add a decimal
            if (!textField.getText().contains(".")) {
                textField.setText(textField.getText().concat("."));

            }

        }

        if (actionEvent.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (actionEvent.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (actionEvent.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (actionEvent.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (actionEvent.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (actionEvent.getSource() == clrButton) {
            textField.setText("0");
        }
        if (actionEvent.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
        if (actionEvent.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));

        }
    }
}

