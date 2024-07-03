package org.java.introduction;
import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        tasks.add(new Task(description));
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsCompleted();
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void viewTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public void viewStatistics() {
        int totalTasks = tasks.size();
        long completedTasks = tasks.stream().filter(Task::isCompleted).count();
        double completionPercentage = (totalTasks > 0) ? (completedTasks * 100.0 / totalTasks) : 0;

        System.out.println("Total tasks: " + totalTasks);
        System.out.println("Completed tasks: " + completedTasks);
        System.out.println("Completion percentage: " + String.format("%.2f", completionPercentage) + "%");
    }

    public void sortTasksByCompletion() {
        tasks.sort((t1, t2) -> Boolean.compare(t1.isCompleted(), t2.isCompleted()));
    }
}
