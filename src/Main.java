/// User related Classes
//Subject.java (Enum)
//QuizResult.java
//User.java
//UserService.java

/// Quiz related Classes
//Difficulty.java (Enum)
//Question.java (The abstract parent class)
//MultipleChoiceQuestion.java (The first child class)
//QuestionBank.java
//InvalidQuizInputException.java (Our custom exception)
//QuizService.java

/// Main Logic
//Main.java

import java.util.Scanner;

/**
 * This is the main class for our Quiz Application.
 * It's responsible for:
 * 1. Displaying menus
 * 2. Getting user input for navigation
 * 3. Calling the correct "Service" class (UserService or QuizService)
 * to do the actual work.
 */

public class Main {

    // Class-Level (static) Fields
    // We create our services and scanner ONCE and make them 'static'.
    private static UserService userService = new UserService();
    private static QuestionBank questionBank = new QuestionBank();
    private static Scanner scanner = new Scanner(System.in);

    // This variable will hold the 'User' object of the person who is
    // currently logged in. If no one is logged in, it will be 'null'.
    private static User currentUser = null;

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("   Welcome to the Quiz App!");
        System.out.println("=====================================");

        // This is the main application loop. It will run forever
        // until the user chooses to exit.
        while (true) {
            // Check if a user is logged in
            if (currentUser == null) {
                // If no one is logged in, show the login/register menu
                showLoginMenu();
            } else {
                // If a user is logged in, show the main application menu
                showMainMenu();
            }
        }
    }

    /**
     * Displays the menu for when a user is NOT logged in.
     * Handles Login, Registration, and Exiting the app.
     */
    private static void showLoginMenu() {
        System.out.println("\n--- Login Menu ---");
        System.out.println("1. Login");
        System.out.println("2. Register New User");
        System.out.println("3. Exit Application");
        System.out.print("Please enter your choice (1-3): ");

        int choice = getMenuChoice(1, 3);

        switch (choice) {
            case 1:
                handleLogin();
                break;
            case 2:
                handleRegistration();
                break;
            case 3:
                System.out.println("\nThank you for using the Quiz App. Goodbye!");
                scanner.close(); // Close the scanner to free resources
                System.exit(0); // This command quits the entire program
                break;
        }
    }

    /**
     * Displays the main menu for a LOGGED IN user.
     * Handles Taking a Test, Viewing Results, and Logging Out.
     */
    private static void showMainMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("Welcome, " + currentUser.getUserId() + "!");
        System.out.println("1. Take a New Test");
        System.out.println("2. Check Last Test Performance");
        System.out.println("3. Logout");
        System.out.print("Please enter your choice (1-3): ");

        int choice = getMenuChoice(1, 3);

        switch (choice) {
            case 1:
                handleTakeTest();
                break;
            case 2:
                handleViewLastResult();
                break;
            case 3:
                handleLogout();
                break;
        }
    }

    // Private Helper Methods

    /**
     * Handles the logic for logging in a user.
     * It will set the 'currentUser' field if successful.
     */
    private static void handleLogin() {
        System.out.println("\n--- User Login ---");
        System.out.print("Enter your User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter your Password: ");
        String password = scanner.nextLine();

        // We call the UserService to do the hard work.
        // It will return a User object on success, or null on failure.
        currentUser = userService.loginUser(userId, password);

    }

    /**
     * Handles the logic for registering a new user.
     */
    private static void handleRegistration() {
        System.out.println("\n--- New User Registration ---");
        System.out.print("Enter your new User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter your new Password: ");
        String password = scanner.nextLine();

        // We call the UserService to do the hard work.
        // It will return 'true' or 'false'
        userService.registerUser(userId, password);
    }

    /**
     * Handles logging the current user out.
     */
    private static void handleLogout() {
        System.out.println("\nLogging out user: " + currentUser.getUserId());
        currentUser = null;
        // Setting this to null sends us back to the Login Menu.
    }

    /**
     * Handles showing the user's last quiz result.
     */
    private static void handleViewLastResult() {
        System.out.println("\n--- Last Test Performance ---");
        // Get the result from our logged-in User object
        QuizResult lastResult = currentUser.getLastResult();

        if (lastResult == null) {
            System.out.println("You have not taken any quizzes yet.");
        } else {
            // We just print the object. This works because
            // we overrode the .toString() method in QuizResult!
            System.out.println(lastResult);
        }

        System.out.print("\nPress Enter to go back to the Main-Menu: ");
        scanner.nextLine();
    }

    /**
     * Handles the menu for selecting and taking a quiz.
     */
    private static void handleTakeTest() {
        System.out.println("\n--- Take a New Test ---");
        System.out.println("Please select a subject:");
        System.out.println("1. Java");
        System.out.println("2. Data Structures");
        System.out.println("3. Networking");
        System.out.print("Please enter your choice (1-3): ");

        int choice = getMenuChoice(1, 3);
        Subject selectedSubject = null;

        switch (choice) {
            case 1:
                selectedSubject = Subject.JAVA;
                break;
            case 2:
                selectedSubject = Subject.DATA_STRUCTURES;
                break;
            case 3:
                selectedSubject = Subject.NETWORKING;
                break;
        }

        // Run the Quiz
        QuizService quizService = new QuizService();

        // runQuiz gives us a result back.
        QuizResult result = quizService.runQuiz(scanner, questionBank, selectedSubject);

        // Save the Result
        System.out.println("Saving your result...");
        // Update the 'currentUser' object in memory
        currentUser.setLastResult(result);


        // save its updated file on the hard drive.
        userService.saveUser(currentUser);

        System.out.println("Result saved!");

        System.out.print("\nPress Enter to go back to the Main-Menu: ");
        scanner.nextLine();
    }


    //returns a valid integer choice from the user.(1,2 or 3)
    private static int getMenuChoice(int min, int max) {
        while (true) {
            try {
                // Read the whole line
                String line = scanner.nextLine();
                // Convert it to an integer
                int choice = Integer.parseInt(line);

                // Check if it's in the valid range
                if (choice >= min && choice <= max) {
                    return choice; // Valid choice, return it
                } else {
                    // It's a number, but not a valid option
                    System.out.print("Invalid choice. Please enter a number between " + min + " and " + max + ": ");
                }
            } catch (NumberFormatException e) {
                // The input was not a number (e.g., "abc")
                System.out.print("That's not a number. Please enter a number between " + min + " and " + max + ": ");
            }
        }
    }
}