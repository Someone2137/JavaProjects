package Quiz;

public interface QuizInterface {
    public void startQuiz();
    public void loadQuestion();
    public void processAnswer(String selectedAnswer);
    public void displayCorrectAnswer();
    public void result();
}
