import java.util.*;
import java.util.List;


public class DadJokeGenerator {
    public static void main(String[] args) {
        List<DadJoke> jokes = new ArrayList<>();
        jokes.add(new DadJoke("Why do fathers take an extra pair of socks when they go golfing?", "In case they get a hole in one!"));
        jokes.add(new DadJoke("What do a tick and the Eiffel Tower have in common?", "They're both Paris sites."));
        jokes.add(new DadJoke("What do you call a fish wearing a bowtie?", "Sofishticated."));
        jokes.add(new DadJoke("How do you follow Will Smith in the snow?", "You follow the fresh prints."));
        jokes.add(new DadJoke("How does dry skin affect you at work?", "You don’t have any elbow grease to put into it."));
        jokes.add(new DadJoke("Have you heard about the chocolate record player?", "It sounds pretty sweet."));
        jokes.add(new DadJoke("What did the zero say to the eight?", "That belt looks good on you."));

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Menu menu = new Menu(random, scanner, jokes);

        while (true) {
            Menu.printOptions();

            try {
                menu.chooseOption();
            } catch (InvalidMenuOptionException ex) {
                System.out.println(ex.getMessage());
                continue;
            } catch (Exception ex) {
                System.err.println("Unknown error, we are working on that");
            }
        }
    }
}