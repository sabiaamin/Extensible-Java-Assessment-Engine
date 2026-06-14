///  This service class handles all user-related operations,
///  specifically loading and saving user data to plain .txt files.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File; // To check if a file exists
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException; // To handle file-related errors

public class UserService {

    // This is a private helper method to get the user's file name.
    // It just ensures we are consistent.
    private String getFilename(String userId) {
        return userId + ".txt";
    }

    //Registering a new user return true if successful registration
    public boolean registerUser(String userId, String password) {
        // Create a File object to see if this user's file already exists.
        File userFile = new File(getFilename(userId));

        // Use .exists() to check
        if (userFile.exists()) {
            System.out.println("Error: User ID '" + userId + "' already exists. Please try a different ID.");
            return false;
        }

        // If the user does NOT exist, create the file

        // We use a 'try-with-resources' block.
        try (
                FileWriter fw = new FileWriter(userFile);
                BufferedWriter bw = new BufferedWriter(fw)
        ) {
            // Write the password to the first line
            bw.write(password);
            bw.newLine(); // Move to the next line

            // Write "null" to the second line, since a new user
            // has no "last quiz result".
            bw.write("null");

            System.out.println("Registration successful for user: " + userId);
            return true;

        } catch (IOException e) {
            System.out.println("Error: Could not create user file. " + e.getMessage());
            return false;
        }
    }


    // * Attempts to log in a user.
    //A User object if login is successful, or 'null' if it fails.

    public User loginUser(String userId, String password) {
        // First, check if the user's file even exists.
        File userFile = new File(getFilename(userId));
        if (!userFile.exists()) {
            System.out.println("Error: User ID '" + userId + "' not found.");
            return null; // Return null to signal login failure
        }

        // If the file does exist, read it and check the password
        try (
                FileReader fr = new FileReader(userFile);
                BufferedReader br = new BufferedReader(fr)
        ) {
            // Read the first line, which should be the password.
            String savedPassword = br.readLine();
            // Read the second line, which has the last result.
            String lastResultString = br.readLine();

            // Check if the password is correct.
            // We use .equals() to compare String contents.
            // null depicts -> issue in file
            if (savedPassword != null && savedPassword.equals(password)) {
                // Password is correct! Now, build the User object.
                System.out.println("Login successful! Welcome, " + userId + ".");

                QuizResult lastResult = null; // Assume no last result

                // Check if the result string is valid (not "null" and not empty)
                // First condition(null)    -> issue in file
                // Second Condition("null") -> no quiz taken yet
                if (lastResultString != null && !lastResultString.equals("null")) {
                    // We need to parse the string "SUBJECT,SCORE"
                    String[] parts = lastResultString.split(",");
                    if (parts.length == 2) {
                        // This 'try' block is to catch an error if the
                        // subject name in the file is invalid (e.g "JAVAA")
                        try {
                            Subject subject = Subject.valueOf(parts[0]); //Converts "JAVA" string to Subject.JAVA enum
                                                                         //will only work if the string in parts[0] perfectly matches one of the enum names
                                                                         //else IllegalArgumentException thrown
                            String score = parts[1];
                            lastResult = new QuizResult(subject, score);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Warning: Could not read last quiz result. File may be corrupted.");
                        }
                    }
                }

                // Create and return the new User object with all their data.
                return new User(userId, password, lastResult);

            } else {
                // Password was incorrect.
                System.out.println("Error: Incorrect password.");
                return null; // Return null to signal login failure
            }

        } catch (IOException e) {
            // This 'catch' runs if the file cannot be read.
            System.out.println("Error: Could not read user file. " + e.getMessage());
            return null; // Return null to signal login failure
        }
    }


     // Saves the user's entire state back to their file.
     // This will OVERWRITE the old file.
     // parameter-> user The User object to save.
    public void saveUser(User user) {
        // We get the user's ID to find their file.
        File userFile = new File(getFilename(user.getUserId()));

        // We use a 'try-with-resources' block to write to the file.
        // Opening a FileWriter like this will OVERWRITE the file's contents.
        try (
                FileWriter fw = new FileWriter(userFile);
                BufferedWriter bw = new BufferedWriter(fw)
        ) {
            // Write the password to the first line
            bw.write(user.getPassword());
            bw.newLine();

            // Check if the user has a last result to save
            if (user.getLastResult() != null) {
                // If yes, call the .toFileString() method we created in the QuizResult class
                bw.write(user.getLastResult().toFileString());
            } else {
                // If no, just write "null"
                bw.write("null");
            }

            // We don't need to print anything; saving should be silent.

        } catch (IOException e) {
            // This is a more serious error (e.g., hard drive full).
            System.out.println("CRITICAL ERROR: Could not save user data! " + e.getMessage());
        }
    }
}