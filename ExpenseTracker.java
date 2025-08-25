import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    private double amount;
    private String category;
    private String description;

    public Expense(double amount, String category, String description) {
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public void display() {
        System.out.println("Amount: " + amount + " | Category: " + category + " | Description: " + description);
    }
}

public class ExpenseTracker {
    private static ArrayList<Expense> expenses = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Personal Expense Tracker ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Calculate Total Spending");
            System.out.println("4. View by Category");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: addExpense(); break;
                case 2: viewExpenses(); break;
                case 3: calculateTotal(); break;
                case 4: viewByCategory(); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    private static void addExpense() {
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine(); // consume newline
        System.out.print("Enter category (Food/Travel/Shopping/etc): ");
        String category = sc.nextLine();
        System.out.print("Enter description: ");
        String description = sc.nextLine();

        expenses.add(new Expense(amount, category, description));
        System.out.println("Expense added successfully!");
    }

    private static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }
        System.out.println("\n--- All Expenses ---");
        for (Expense e : expenses) {
            e.display();
        }
    }

    private static void calculateTotal() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        System.out.println("Total Spending: " + total);
    }

    private static void viewByCategory() {
        System.out.print("Enter category to filter: ");
        String category = sc.nextLine();

        boolean found = false;
        for (Expense e : expenses) {
            if (e.getCategory().equalsIgnoreCase(category)) {
                e.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No expenses found in this category.");
        }
    }
}
