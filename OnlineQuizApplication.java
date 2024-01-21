import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String questionText;
    private List<String> options;
    private int correctOption;

    public Question(String questionText, List<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz(List<Question> questions) {
        this.questions = questions;
        this.score = 0;
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.size(); i++) {
            Question currentQuestion = questions.get(i);

            System.out.println("Question " + (i + 1) + ": " + currentQuestion.getQuestionText());

            List<String> options = currentQuestion.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((j + 1) + ". " + options.get(j));
            }

            System.out.print("Enter your answer (1-" + options.size() + "): ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == currentQuestion.getCorrectOption()) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + currentQuestion.getCorrectOption() + "\n");
            }
        }

        System.out.println("Quiz completed. Your score: " + score + " out of " + questions.size());
    }
}

public class OnlineQuizApplication {
    public static void main(String[] args) {
        // Sample questions for the quiz
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?", List.of("Berlin", "Paris", "Rome", "Madrid"), 2));
        questions.add(new Question("Which planet is known as the Red Planet?", List.of("Earth", "Mars", "Jupiter", "Venus"), 2));
        questions.add(new Question("What is the largest mammal in the world?", List.of("Elephant", "Blue Whale", "Giraffe", "Hippopotamus"), 2));

        // Create a quiz with the sample questions
        Quiz quiz = new Quiz(questions);

        // Start the quiz
        quiz.startQuiz();
    }
}
