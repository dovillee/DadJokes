import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Menu {
    public static void printOptions() {
        System.out.println("Dad Joke Menu:");
        System.out.println("1. Print all Dad jokes");
        System.out.println("2. Print a random Dad Joke");
        System.out.println("3. Print a chosen Dad Joke");
        System.out.println("4. Print the count of Jokes");
        System.out.println("5. Print a mix of question and punchline");
        System.out.println("6. Add a new Dad Joke");
        System.out.println("7. Exit");
    }
    private Random random;
    private Scanner scanner;
    private List<DadJoke> jokes;
    public Menu(Random random, Scanner scanner, List<DadJoke> jokes){
        this.random = random;
        this.scanner = scanner;
        this.jokes = jokes;
    }
    public void chooseOption() throws InvalidMenuOptionException {
        int choice;
        try {
            System.out.print("Select an option: ");
            String line = scanner.nextLine();
            choice = Integer.parseInt(line);
        } catch (Exception ex) {
            throw new InvalidMenuOptionException();
        }
        switch (choice) {
            case 1:
                printAllJokes();
                break;
            case 2:
                printRandomJoke();
                break;
            case 3:
                printChosenJoke();
                break;
            case 4:
                printCountOfJokes();
                break;
            case 5:
                printMixQuestionAndPunchline();
                break;
            case 6:
                addNewJoke();
                break;
            case 7:
                exitMenu();
            default:
                throw new InvalidMenuOptionException();
        }
    }
    private void printAllJokes() {
        int jokeNumber = 1;
        for (DadJoke joke : jokes) {
            System.out.println(jokeNumber + ". " + joke);
            System.out.println();
            jokeNumber++;
        }
    }
    private void printRandomJoke() {
        int randomIndex = random.nextInt(jokes.size());
        DadJoke randomJoke = jokes.get(randomIndex);
        System.out.println(randomJoke);
    }
    private void printChosenJoke() {
        int jokesCount = jokes.size();
        int choice;
        while(true){
            try {
                System.out.print("Enter the joke number to print (1-" + jokesCount + "), or \"-1\" to cancel: ");
                String line = scanner.nextLine();
                choice = Integer.parseInt(line);
            } catch (Exception e) {
                System.out.println("Invalid option");
                continue;
            }

            if (choice >= 1 && choice <= jokesCount) {
                System.out.println(jokes.get(jokesCount - 1));
            } else if(choice == -1) {
                break;
            } else {
                System.out.println("Invalid option");
                continue;
            }
        }
    }
    private void printCountOfJokes() {
        System.out.println("Current number of jokes: " + jokes.size());
    }
    private void printMixQuestionAndPunchline() {
        int jokesCount = jokes.size();
        int randomJoke1 = random.nextInt(jokesCount);
        int randomJoke2 = random.nextInt(jokesCount);
        System.out.println(jokes.get(randomJoke1).getQuestion() + " - " + jokes.get(randomJoke2).getPunchline());
    }
    private void addNewJoke() {
        System.out.print("Enter the joke question: ");
        String newQuestion = scanner.nextLine();
        System.out.print("Enter the punchline: ");
        String newPunchline = scanner.nextLine();
        jokes.add(new DadJoke(newQuestion, newPunchline));
    }
    private void exitMenu() {
        System.out.println("Goodbye!");
        System.exit(0);
    }
}