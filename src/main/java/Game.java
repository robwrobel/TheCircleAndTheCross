import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> players = new ArrayList<>();
    {
        players.add(new Player(Mark.O));
        players.add(new Player(Mark.X));
    }



    ReadInput readInput = new ReadInput();


    public static void main(String[] args) {

        Game game = new Game();

        Scores scores = new Scores(game);

        printWelcomeMessage();

        game.setPlayersNames();

        for (int match_no = 1; match_no <= 3; match_no++) {
            new Match(game,scores).start();
            scores.display();
        }
    }

    private void setPlayersNames() {
        int i=1;
        for (Player p: players) {
            System.out.println("Please enter player "+ i + " name:");
            p.setName(readInput.getString());
            i++;
        }
    }

    private static void printWelcomeMessage() {
        System.out.println("New Game Started!");
    }

}
