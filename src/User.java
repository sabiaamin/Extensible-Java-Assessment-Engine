/// This class represents a user of our application.

public class User {

    /// Fields
    private String userId;        // The user's login ID
    private String password;      // The user's password
    private QuizResult lastResult;  // The result of their last quiz.

    /// Constructor
    public User(String userId, String password, QuizResult lastResult) {
        this.userId = userId;
        this.password = password;
        this.lastResult = lastResult;
    }

    /// Getters
    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public QuizResult getLastResult() {
        return lastResult;
    }

    /// Setter
    public void setLastResult(QuizResult lastResult) {
        this.lastResult = lastResult;
    }
}