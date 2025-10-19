package com.shiva;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

public class FixedColorfulCalculator extends JFrame implements ActionListener {
    private JTextField display;
    private StringBuilder input;

    public FixedColorfulCalculator() {
        setTitle("Calculator Application");
        setSize(420, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        input = new StringBuilder();

        // ===== HEADING =====
        JPanel headingPanel = new JPanel();
        headingPanel.setBackground(new Color(33, 150, 243));
        JLabel heading = new JLabel("Calculator Application", SwingConstants.CENTER);
        heading.setFont(new Font("Segoe UI", Font.BOLD, 26));
        heading.setForeground(Color.WHITE);
        headingPanel.add(heading);
        add(headingPanel, BorderLayout.NORTH);

        // ===== DISPLAY =====
        display = new JTextField();
        display.setFont(new Font("Segoe UI", Font.BOLD, 32));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setEditable(false);
        display.setBackground(new Color(245, 245, 245));
        display.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2));
        add(display, BorderLayout.CENTER);

        // ===== BUTTONS =====
        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 10, 10));
        buttonPanel.setBackground(new Color(240, 240, 240));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        String[] buttons = {
            "C", "←", "/", "*",
            "7", "8", "9", "-",
            "4", "5", "6", "+",
            "1", "2", "3", "=",
            "0", ".", "(", ")"
        };

        for (String text : buttons) {
            JButton btn = createButton(text);
            buttonPanel.add(btn);
        }

        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 22));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setOpaque(true);
        btn.setBorderPainted(false);

        if (text.matches("[0-9\\.]")) btn.setBackground(new Color(100, 181, 246));
        else if (text.equals("=")) btn.setBackground(new Color(76, 175, 80));
        else if (text.equals("C")) btn.setBackground(new Color(239, 83, 80));
        else if (text.equals("←")) btn.setBackground(new Color(255, 167, 38));
        else btn.setBackground(new Color(63, 81, 181));

        btn.addActionListener(this);
        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "C":
                input.setLength(0);
                display.setText("");
                break;
            case "←":
                if (input.length() > 0) {
                    input.setLength(input.length() - 1);
                    display.setText(input.toString());
                }
                break;
            case "=":
                evaluateExpression();
                break;
            default:
                input.append(command);
                display.setText(input.toString());
        }
    }

    // ===== Expression Evaluator =====
    private void evaluateExpression() {
        try {
            double result = evaluate(input.toString());
            display.setText(formatResult(result));
            input.setLength(0);
            input.append(formatResult(result));
        } catch (Exception ex) {
            display.setText("Error");
            input.setLength(0);
        }
    }

    private String formatResult(double value) {
        if (value == (long) value)
            return String.format("%d", (long) value);
        else
            return String.format("%.4f", value);
    }

    // ===== Core Math Evaluator =====
    private double evaluate(String expr) {
        char[] tokens = expr.toCharArray();
        Stack<Double> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ') continue;

            if ((tokens[i] >= '0' && tokens[i] <= '9') || tokens[i] == '.') {
                StringBuilder sbuf = new StringBuilder();
                while (i < tokens.length &&
                      ((tokens[i] >= '0' && tokens[i] <= '9') || tokens[i] == '.')) {
                    sbuf.append(tokens[i++]);
                }
                values.push(Double.parseDouble(sbuf.toString()));
                i--;
            } else if (tokens[i] == '(') {
                ops.push(tokens[i]);
            } else if (tokens[i] == ')') {
                while (ops.peek() != '(') {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.pop();
            } else if (tokens[i] == '+' || tokens[i] == '-' ||
                       tokens[i] == '*' || tokens[i] == '/') {
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.push(tokens[i]);
            }
        }

        while (!ops.empty()) {
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    private boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        return true;
    }

    private double applyOp(char op, double b, double a) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FixedColorfulCalculator());
    }
}
