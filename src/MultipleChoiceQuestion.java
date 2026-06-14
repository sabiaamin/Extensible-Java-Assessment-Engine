import java.util.ArrayList;

/// This is a concrete class that implements the contract from Question.
/// It extends Question, inheriting its fields and methods.

public class MultipleChoiceQuestion extends Question {

    /// Specific Fields
    private String[] options; // stores text of each option
    private int correctAnswerIndex;    // 0, 1, 2, or 3

    /// Constructor
    // It calls the PARENT class's (Question's) constructor
    public MultipleChoiceQuestion(
            String questionText,
            String []options,
            int correctAnswerIndex,
            Subject subject,
            Difficulty difficulty) {

        //Setting parent class's fields
        super(questionText, subject, difficulty);

        // Setting own specific fields.
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    ///Implementation of Abstract Methods
    @Override
    public void displayOptions() {
        // Looping through the options to print them.
        for (String option : options) {
            System.out.println(option);
        }
    }
    @Override
    public boolean isCorrect(int answer) {
        // Adjusting the user's answer (1-4) to match our list index (0-3)
        return (answer - 1) == correctAnswerIndex;
    }

    @Override
    public String getCorrectAnswerText() {
        // Gets the text from the options list using the correct index.
        return options[correctAnswerIndex];
    }

    @Override
    public String[] getOptions() {
        return options;
    }
}