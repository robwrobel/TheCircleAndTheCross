import java.util.ArrayList;
import java.util.List;

public class Game {

    List<Player> players = new ArrayList();
    {
        players.add(new Player(Mark.O));
        players.add(new Player(Mark.X));
    }

    ReadInput readInput = new ReadInput();
    Scores scores = new Scores(players);


    public static void main(String[] args) {

        Game game = new Game();

        printWelcomeMessage();

        game.setPlayersNames();

        for (int matchNo = 1; matchNo <= 3; matchNo++) {
            new Match( game.scores, game.readInput, game.players).start();
            game.scores.display();
        }
    }

    private void setPlayersNames() {
        int i=1;
        for(Player p: players) {
            System.out.println("Please enter player "+ i + " name:");
            p.setName(readInput.getString());

        }
    }

    private static void printWelcomeMessage() {
        System.out.println("New Game Started!");
    }

}
