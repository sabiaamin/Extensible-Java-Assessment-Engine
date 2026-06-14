/// This class holds the data for a single completed quiz.

public class QuizResult {

    /// Fields
    private Subject subject;  // The subject of the quiz
    private String score;     // The final score

    /// Constructor
    public QuizResult(Subject subject, String score) {
        this.subject = subject;
        this.score = score;
    }

    /// Getters
    public Subject getSubject() {
        return subject;
    }

    public String getScore() {
        return score;
    }

     // We will use it to convert our QuizResult object INTO a String that we can save to our text file.
     // We'll use a CSV format.
    public String toFileString() {
        return subject.name() + "," + score; //eg -> "JAVA,4/6"
    }

    @Override
    public String toString() { //used in main method -> handleViewLastResult
        return "Subject: " + subject + ", Score: " + score;
    }
}