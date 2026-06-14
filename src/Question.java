/// This is an ABSTRACT class. It defines the contract for all types of questions(mcq's ,T/F) in our quiz.
/// This shows Inheritance and Polymorphism.

public abstract class Question {

    /// Common Fields
    protected String questionText;
    protected Subject subject;
    protected Difficulty difficulty;

    /// Constructor
    public Question(String questionText, Subject subject, Difficulty difficulty) {
        this.questionText = questionText;
        this.subject = subject;
        this.difficulty = difficulty;
    }

    ///Concrete Method
    public String getQuestionText() {
        return questionText;
    }

    public Difficulty getDifficulty(){
        return difficulty;
    }

    /// Abstract Methods

    public abstract void displayOptions();

    // Child class must provide this to check the user's answer.
    public abstract boolean isCorrect(int answer);

    // Child class must provide a way to get the correct answer's text for the final scorecard.
    public abstract String getCorrectAnswerText();

    // Child class must provide a list of options
    public abstract String[] getOptions();
}