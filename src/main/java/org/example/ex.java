package org.example;

import java.util.Scanner;

public class ex {
    //    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the expression (e.g., 3+2): ");
//        String str = scanner.nextLine();
//
//        try {
//            if (str.length() < 3) {
//                throw new IllegalArgumentException("Input must be in the form a+b, a-b, a*b, or a/b.");
//            }
//
//            int a = Integer.parseInt(str.substring(0, 1));
//            String d = str.substring(1, 2);
//            int b = Integer.parseInt(str.substring(2));
//
//            switch (d) {
//                case "+":
//                    System.out.println("Result: " + (a + b));
//                    break;
//                case "-":
//                    System.out.println("Result: " + (a - b));
//                    break;
//                case "*":
//                    System.out.println("Result: " + (a * b));
//                    break;
//                case "/":
//                    if (b == 0) {
//                        System.out.println("Error: Division by zero is not allowed.");
//                    } else {
//                        System.out.println("Result: " + (a / b));
//                    }
//                    break;
//                default:
//                    System.out.println("Error: Unsupported operator.");
//                    break;
//            }
//        } catch (NumberFormatException e) {
//            System.out.println("Error: Invalid number format.");
//        } catch (IllegalArgumentException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String output = scanner.nextLine();

        StringBuilder key = new StringBuilder();
        boolean isValid = true;

        for (int i = 0; i < input.length(); i++) {
            char inputChar = input.charAt(i);
            char outputChar = output.charAt(i);

            if (inputChar <= outputChar) {
                key.append(outputChar);
            } else {
                key.append(inputChar);
            }
        }

        for (int i = 0; i < input.length(); i++) {
            char inputChar = input.charAt(i);
            char outputChar = output.charAt(i);
            char keyChar = key.charAt(i);

            if (keyChar != inputChar && keyChar != outputChar) {
                isValid = false;
                break;
            }
        }

        if (isValid) {
            System.out.println(key.toString());
        } else {
            System.out.println("-1");
        }
    }
}
