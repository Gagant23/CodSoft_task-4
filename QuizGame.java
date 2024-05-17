import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizGame {
    private static final int TIME_LIMIT = 10;
    private static boolean timeIsUp = false; 


    private static String[] questions = {
        "What is the capital of France?",
        "Who wrote 'Romeo and Juliet'?",
        "What is the chemical symbol for water?"
    };

    private static String[] options = {
        "A. Paris   B. London   C. Rome",
        "A. William Shakespeare   B. Charles Dickens   C. Jane Austen",
        "A. H2O   B. CO2   C. NaCl"
    };

    private static String[] correctAnswers = {"A", "A", "A"};

    private static Timer timer;
    private static Scanner scanner; 

    public static void main(String[] args) {
        scanner = new Scanner(System.in); 
        int score = 0;

        System.out.println("Welcome to the Quiz Game!");

        // Iterate through each question
        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQuestion " + (i + 1) + ":");
            System.out.println(questions[i]);
            System.out.println(options[i]);

            timer = new Timer();
            QTimerTask timerTask = new QTimerTask();
            timer.schedule(timerTask, TIME_LIMIT * 1000);

            System.out.print("Your answer: ");
            String userAnswer;

            if (!timeIsUp) {
                userAnswer = scanner.next().toUpperCase(); 
            } else {
                System.out.println("Time's up!");
                break; 
            }


            if (userAnswer.equals(correctAnswers[i])) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer is: " + correctAnswers[i]);
            }

            timer.cancel();
        }
        scanner.close();
        // Display final score
        System.out.println("Quiz completed! Your final score is: " + score + "/" + questions.length);
    }

    static class QTimerTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("Time's Up!");
            timeIsUp = true;
        }
    }
}
