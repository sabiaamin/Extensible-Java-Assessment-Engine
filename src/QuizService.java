import java.util.ArrayList;
import java.util.Scanner;

/// This class contains all the core logic for running a quiz.

public class QuizService {


    // This is the main method that runs the entire quiz flow.
    //
    //   Parameters:-
    //     scanner -> The Scanner to use for user input.
    //     bank -> The QuestionBank to get questions from.
    //     subject ->  The Subject the user chose.
    //
    //   Returns:
    //     A QuizResult object with the final score.

    public QuizResult runQuiz(Scanner scanner, QuestionBank bank, Subject subject) {

        System.out.println("\nStarting your " + subject + " quiz...");
        System.out.println("You will be asked 6 questions (2 easy, 2 medium, 2 difficult).");

        // Get the 6 random questions from the bank
        ArrayList<Question> quizQuestions = bank.getQuizQuestions(subject);

        int score = 0; // stores current score
        int questionNumber = 1; // stores current question number

        // This array will hold the user's answers to show on the scorecard.
        //it will store answers in the form (1,2,3,4)
        int[] userAnswers = new int[quizQuestions.size()];

        // Loop through the questions
        for (Question q : quizQuestions) {

            System.out.println("\n-------------------------------------");
            System.out.println("Question " + questionNumber + "/" + quizQuestions.size());
            System.out.println("(Difficulty: " + q.getDifficulty() + ")");
            System.out.println(q.getQuestionText());
            System.out.println("---");

            q.displayOptions();
            System.out.println("---");

            // Get and validate user input
            int answer = getUserAnswer(scanner);
            userAnswers[questionNumber - 1] = answer; // Store user's answer (1,2,3 or 4)
            if (q.isCorrect(answer)) {
                System.out.println("Correct!");
                score++; // Increment score
            } else {
                System.out.println("Incorrect.");
            }

            questionNumber++; // Increment Question Number
        }

        // Show the scorecard
        System.out.println("\n=====================================");
        System.out.println("         Quiz Complete!");
        System.out.println("     Your Final Score: " + score + " / " + quizQuestions.size());
        System.out.println("=====================================");

        System.out.print("\nPress Enter to display detailed scorecard: ");
        scanner.nextLine();

        System.out.println("\n--- Detailed Scorecard ---");
        // Displays each question with its correct answer
        for (int i = 0; i < quizQuestions.size(); i++) {
            Question q = quizQuestions.get(i); // Get the question

            System.out.println("\nQ" + (i + 1) + ": " + q.getQuestionText());
            System.out.println("(Difficulty: " + q.getDifficulty() + ")");

            // Get the correct answer's text
            String correctAnswerText = q.getCorrectAnswerText();
            System.out.println("Correct Answer: " + correctAnswerText);

            // Get the text of the user's answer
            // Get the text at the index they chose (userAnswers[i] - 1).
            String userAnswerText = q.getOptions()[userAnswers[i] - 1];

            // Comparing and printing the result
            if (q.isCorrect(userAnswers[i])) {
                System.out.println("Your Answer: " + userAnswerText + " (Correct)");
            } else {
                System.out.println("Your Answer: " + userAnswerText + " (Incorrect)");
            }
        }
        System.out.println("\n=====================================");


        // Creating and returning the result object
        String finalScore = score + "/" + quizQuestions.size();
        return new QuizResult(subject, finalScore);
    }


    // This method will loop indefinitely until the user enters a valid integer (1, 2, 3, or 4).
    private int getUserAnswer(Scanner scanner) {

        while (true) {
            try {
                System.out.print("Enter your answer (1-4): ");

                String line = scanner.nextLine();

                // Check if the input String is one of the four allowed strings.

                if (line.equals("1")) {
                    return 1;
                } else if (line.equals("2")) {
                    return 2;
                } else if (line.equals("3")) {
                    return 3;
                } else if (line.equals("4")) {
                    return 4;
                } else {
                    // If the input is invalid. We throw our custom exception.
                    throw new InvalidQuizInputException("Invalid input. Please enter 1, 2, 3, or 4.");
                }

            } catch (InvalidQuizInputException e) {//custom exception
                System.out.println(e.getMessage());
            }
        }
    }
}