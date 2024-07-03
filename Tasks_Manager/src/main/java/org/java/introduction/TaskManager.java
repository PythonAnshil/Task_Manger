package org.java.introduction;

import java.util.Scanner;

public class TaskManager {
    private static final Scanner scanner = new Scanner(System.in);
    private static final TaskList taskList = new TaskList();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            showMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    markTaskAsCompleted();
                    break;
                case 4:
                    taskList.viewTasks();
                    break;
                case 5:
                    taskList.viewStatistics();
                    break;
                case 6:
                    taskList.sortTasksByCompletion();
                    System.out.println("Tasks sorted by completion status.");
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Exiting Task Manager. Goodbye!");
    }

    private static void showMenu() {
        System.out.println("\nTask Manager");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. Mark Task as Completed");
        System.out.println("4. View Tasks");
        System.out.println("5. View Statistics");
        System.out.println("6. Sort Tasks by Completion Status");
        System.out.println("7. Exit");
        System.out.print("Choose an option: ");
    }

    private static int getChoice() {
        return Integer.parseInt(scanner.nextLine());
    }

    private static void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        taskList.addTask(description);
        System.out.println("Task added.");
    }

    private static void removeTask() {
        System.out.print("Enter task number to remove: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        taskList.removeTask(index);
    }

    private static void markTaskAsCompleted() {
        System.out.print("Enter task number to mark as completed: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        taskList.markTaskAsCompleted(index);
    }
}
