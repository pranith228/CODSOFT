import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        // Create Scanner object to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter the number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Initialize variables for total marks and average percentage
        int totalMarks = 0;
        double averagePercentage;

        // Loop to take marks for each subject
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks for subject " + i + " (out of 100): ");
            int subjectMarks = scanner.nextInt();

            // Validate that marks are within the valid range (0-100)
            if (subjectMarks < 0 || subjectMarks > 100) {
                System.out.println("Invalid marks! Marks should be between 0 and 100.");
                return; // Exit the program if invalid marks are entered
            }

            // Add the marks to total
            totalMarks += subjectMarks;
        }

        // Calculate average percentage
        averagePercentage = (double) totalMarks / numSubjects;

        // Display total marks and average percentage
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");

        // Assign grades based on the average percentage
        char grade = calculateGrade(averagePercentage);

        // Display the corresponding grade
        System.out.println("Grade: " + grade);

        // Close the Scanner to prevent resource leak
        scanner.close();
    }

    // Function to calculate grade based on average percentage
    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
