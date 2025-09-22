package Code;

import java.util.Scanner;

public class ConsoleCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("***** Java Console Calculator *******");

        while (running) {
            System.out.print("\nEnter First Number: ");
            double num1 = sc.nextDouble();

            System.out.print("Enter Second Number: ");
            double num2 = sc.nextDouble();

            System.out.println("Choose operation: ");
            System.out.println("1. Addition(+)");
            System.out.println("2. Subtraction(-)");
            System.out.println("3. Multiplication");
            System.out.println("4. Division(/)");
            System.out.println("Enter choice(1-4): ");
            int choice = sc.nextInt();

            double result = 0;
            boolean valid = true;

            switch (choice) {
                case 1:
                    result = num1 + num2;
                    break;
                case 2:
                    result = num1 - num2;
                    break;
                case 3:
                    result = num1 * num2;
                    break;
                case 4:
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Error: Division by Zero!");
                        valid = false;
                    }
                    break;
                default:
                    System.out.println("Invalid choice!");
                    valid = false;
            }
            if (valid) {
                System.out.println("Result=" + result);
            }
            System.out.print("\n Do you want to perform another calculation? (y/n): ");
            char again = sc.next().charAt(0);

            if (again == 'n' || again == 'N') {
                running = false;
            }
        }
        System.out.println("\n Calculator exited. Good Luck!");
        sc.close();
    }
}
