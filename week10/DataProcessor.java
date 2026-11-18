package week10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// This program reads a CSV file of student marks, uses a Map to process the data,
// and writes a summary report to a new text file.
public class DataProcessor {
    public static void main(String[] args) {

        // We will use a Map to store the processed data.
        // Key = Student Name, Value = Status (Pass/Fail)
        Map<String, String> results = new HashMap<>();

        String inputFile = "students.csv";
        String outputFile = "report.txt";

        double totalMarks = 0;
        int studentCount = 0;

        // ============================================================
        // STEP 1: READ AND PROCESS THE CSV
        // ============================================================
        try {
            File file = new File(inputFile);

            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    // Split the line by comma.
                    String[] parts = line.split(",");

                    // Ensure the line has exactly 3 parts to prevent errors.
                    if (parts.length == 3) {
                        String name = parts[1].trim();
                        int marks = Integer.parseInt(parts[2].trim());

                        totalMarks += marks;
                        studentCount++;

                        if (marks >= 50) {
                            results.put(name, "PASSED");
                        } else {
                            results.put(name, "FAILED");
                        }
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file not found.");
            return;
        } catch (NumberFormatException e) {
            System.out.println("Error: The file contains non-numeric marks.");
            return;
        }

        // ============================================================
        // STEP 2: WRITE THE REPORT TO A NEW FILE
        // ============================================================
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {

            writer.println("=== EXAMINATION REPORT ===");
            writer.println("Total Students Processed: " + studentCount);

            double average = studentCount == 0 ? 0 : totalMarks / studentCount;
            writer.println("Class Average: " + average);
            writer.println("--------------------------");

            for (Map.Entry<String, String> entry : results.entrySet()) {
                writer.println("Student: " + entry.getKey()
                        + " | Result: " + entry.getValue());
            }

            System.out.println("Data processing complete! Check " + outputFile
                    + " for results.");

        } catch (IOException e) {
            System.out.println("Error writing report file: " + e.getMessage());
        }
    }
}
 
