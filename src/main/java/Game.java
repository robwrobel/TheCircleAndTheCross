public class Game {
    private static boolean gameContinue = false;


    Player player1 = new Player(Mark.O);
    Player player2 = new Player(Mark.X);
    Pen pen1 = new Pen(player1);
    Pen pen2 = new Pen(player2);

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
        System.out.println("Please enter player 1 name:");
        player1.setName(readInput.getString());
        System.out.println("Please enter player 2 name:");
        player2.setName(readInput.getString());
    }


    private static void printWelcomeMessage() {
        System.out.println("New Game Started");
    }

}
