import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> players = new ArrayList<Player>();
    {
        players.add(new Player(Mark.O));
        players.add(new Player(Mark.X));
    }
    List<Pen> pens = new ArrayList<>();
    {
        players.stream().forEach((Player player)->pens.add(new Pen(player)));
    }

    ReadInput readInput = new ReadInput();

    public static void main(String[] args) {

        Game game = new Game();

        printWelcomeMessage();

        game.setPlayersNames();

        for (int match_no = 1; match_no <= 3; match_no++) {
            new Match(game).start();
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
