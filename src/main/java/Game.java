public class Game {
    private static boolean gameContinue = false;

    Board board = new Board();

    public static void main(String[] args) {
        Game game = new Game();

        Player player1 = new Player(Mark.O);
        Player player2 = new Player(Mark.X);
        printWelcomeMessage();
        do {
            game.displayBoard();
            game.askUserForNewCoordinates();

        } while (isGameContinue());
    }

    private void askUserForNewCoordinates() {
        System.out.println("Please enter column");

        System.out.println("Please enter row");
    }

    private void displayBoard() {
        System.out.println(board);
    }

    private static void printWelcomeMessage() {
        System.out.println("New Game Started");
    }

    public static boolean isGameContinue() {
        return gameContinue;
    }
}
