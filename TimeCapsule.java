import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

/**
 * Task 1: File Handling Utility
 * Modern Interactive Runtime Version: Fully optimized with try-with-resources 
 * and rule switch syntax to satisfy all modern Java compiler hints.
 */
public class TimeCapsule {
    public static void main(String[] args) {
        // [1] Defining the file path pointer object for our target text storage file
        Path capsulePath = Path.of("time_capsule.txt");

        // [2] Opening Scanner inside try-with-resources header block for automatic memory resource reclamation
        try (Scanner scanner = new Scanner(System.in)) {
            // [3] State controller flag variable to maintain the operational runtime loop execution
            boolean running = true;

            // [4] Rendering application welcome banner message directly to the console output screen
            System.out.println("⏳ Welcome to the Interactive Digital Time Capsule! ⏳");

            // [5] Continuous iterative loop block execution processing transactions until running shifts to false
            while (running) {
                // [6] Displaying the options navigation dashboard layout terminal interface menu
                System.out.println("\nChoose a File Operation:");
                System.out.println("1. 📝 WRITE (Create a new capsule / Overwrite old one)");
                System.out.println("2. ✍️  MODIFY (Append a new note to the capsule)");
                System.out.println("3. 📖 READ (Open and view the capsule content)");
                System.out.println("4. ❌ EXIT");
                System.out.print("Enter your choice (1-4): ");
                
                // [7] Reading the raw interactive entry string selection from user keyboard buffer
                String choice = scanner.nextLine();

                // [8] Isolating nested file systems interactions inside an internal protective try block
                try {
                    // [9] Route handling management optimized using modern arrow switch rule mechanics
                    switch (choice) {
                        // Operation 1: Handles complete fresh creation or overwriting initialization
                        case "1" -> {
                            System.out.print("Enter your initial capsule message: ");
                            String initialMessage = scanner.nextLine();
                            // Writing data string seamlessly directly down into the file block
                            Files.writeString(capsulePath, initialMessage);
                            System.out.println("🌱 File Created & Written successfully!");
                        }
                        // Operation 2: Handles conditional safe text appending modifications
                        case "2" -> {
                            // Validating destination directory existence map before executing updates
                            if (!Files.exists(capsulePath)) {
                                System.out.println("⚠️ No capsule found! Create one using option 1 first.");
                            } else {
                                System.out.print("Enter text to append to your capsule: ");
                                // Pre-formatting with newline delimiter characters before appending entry
                                String modification = "\n" + scanner.nextLine();
                                // Gluing payload onto trailing edge boundaries using standard APPEND configuration flags
                                Files.writeString(capsulePath, modification, StandardOpenOption.APPEND);
                                System.out.println("✍️  File Modified successfully!");
                            }
                        }
                        // Operation 3: Handles full sequential structural parsing and file streaming data reads
                        case "3" -> {
                            // Validation gate tracking physical file existence checks
                            if (!Files.exists(capsulePath)) {
                                System.out.println("⚠️ The capsule file does not exist yet!");
                            } else {
                                System.out.println("\n--- Opening the Time Capsule ---");
                                // Pulling down all written lines sequentially into a structured collection list container
                                List<String> lines = Files.readAllLines(capsulePath);
                                // Looping through and discharging tracked string items safely to active standard output
                                for (String line : lines) {
                                    System.out.println(line);
                                }
                                System.out.println("--------------------------------");
                            }
                        }
                        // Operation 4: Gracefully terminates execution loops safely
                        case "4" -> {
                            System.out.println("🚀 Exiting... Your time capsule is safely stored.");
                            // Transitioning conditional boolean flags to kill outer iterative execution loops
                            running = false;
                        }
                        // Default Fallback: Protecting runtime states from bad inputs
                        default -> System.out.println("❌ Invalid choice! Please enter a number between 1 and 4.");
                    }
                } catch (IOException e) {
                    // [10] Error reporting logic targeting internal read/write input stream exceptions
                    System.out.println("⚠️ A file error occurred: " + e.getMessage());
                }
            }
        } // Scanner session resources automatically closed and cleaned up cleanly here by JVM layer
    }
}