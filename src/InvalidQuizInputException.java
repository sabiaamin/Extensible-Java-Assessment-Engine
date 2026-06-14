///  This is our own custom exception class. (used in QuizService class -> getUserAnswer()
///  We use this when the input is of:
///         1) invalid type (like 'abc')
///         2) valid type but not in a valid range (like 5,100,-1).

public class InvalidQuizInputException extends Exception {

    public InvalidQuizInputException(String message) {
        super(message);
    }
}