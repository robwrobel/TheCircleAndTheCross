public class Game {
    private static boolean gameContinue = false;

    Board board = new Board();
    Player player1 = new Player(Mark.O);
    Player player2 = new Player(Mark.X);
    Pen pen1 = new Pen(player1);
    Pen pen2 = new Pen(player2);

    Tour tour = new Tour(player1,pen1);
    ReadInput readInput = new ReadInput();

    public static void main(String[] args) {
        Game game = new Game();

        printWelcomeMessage();
        do {
            game.displayBoard();
            game.keepAskingPlayerForNewCoordinate();
            if (game.isWinner()) {
                break;
            }
            game.switchUser();
        } while (true);
    }

    private void checkWinningConditions() {

    }

    private void switchUser() {
        if (tour.currentPlayer == player1) {
            tour.currentPlayer = player2;
            tour.currentPen = pen2;
        } else {
            tour.currentPlayer = player1;
            tour.currentPen = pen1;
        }
    }

    private void keepAskingPlayerForNewCoordinate() {
        do {
            askUserForNewCoordinate();
        } while (isSetMarkFail());
    }

    private void askUserForNewCoordinate() {
        System.out.println("Please enter column");
        tour.currentCoordinate.column = readInput.getInt();
        System.out.println("Please enter row");
        tour.currentCoordinate.row = readInput.getInt();
    }

    private void displayBoard() {
        System.out.println(board);
    }

    private static void printWelcomeMessage() {
        System.out.println("New Game Started");
    }

    public boolean isSetMarkFail() {
        int currentColumn = tour.currentCoordinate.column;
        int currentRow = tour.currentCoordinate.row;
        try {
            tour.currentPen.mark(board.getField(currentColumn,currentRow));
            return false;
        } catch (FieldAlreadyMarkedException e) {
            return true;
        }
    }

    public boolean isWinner() {
        return false;
    }
}
