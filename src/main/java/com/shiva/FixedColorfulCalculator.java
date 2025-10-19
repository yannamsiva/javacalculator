package com.shiva;

import java.util.Scanner;

public class ConsoleCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Console Calculator ===");

        while (true) {
            System.out.print("\nEnter expression (e.g., 2 + 5) or 'exit' to quit: ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting Calculator. Goodbye!");
                break;
            }

            try {
                double result = evaluate(input);
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println("Invalid expression! Please use +, -, *, / operators.");
            }
        }

        sc.close();
    }

    // Simple evaluate method supporting +, -, *, /
    public static double evaluate(String expr) throws Exception {
        expr = expr.replaceAll("\\s+", ""); // remove spaces

        if (expr.contains("+")) {
            String[] parts = expr.split("\\+");
            return Double.parseDouble(parts[0]) + Double.parseDouble(parts[1]);
        } else if (expr.contains("-")) {
            String[] parts = expr.split("\\-");
            return Double.parseDouble(parts[0]) - Double.parseDouble(parts[1]);
        } else if (expr.contains("*")) {
            String[] parts = expr.split("\\*");
            return Double.parseDouble(parts[0]) * Double.parseDouble(parts[1]);
        } else if (expr.contains("/")) {
            String[] parts = expr.split("\\/");
            return Double.parseDouble(parts[0]) / Double.parseDouble(parts[1]);
        } else {
            throw new Exception("Operator not found");
        }
    }
}
