public class Match {
    Game game;
    Board board = new Board();
    Tour tour ;

    public Match(Game game) {
        this.game = game;
    }

    public void start() {

        whoBegins();

        do {
            displayBoard();
            keepAskingPlayerForNewCoordinate();
            if (isWinner()) {
                break;
            }
            switchUser();
        } while (true);
   }

    private void whoBegins() {
        System.out.println("Please select who begins (1-Player1: " + game.player1.getName() + " , 2-Player2: "+game.player2.getName()+ ")");
        int input;
        do {
            input = game.readInput.getInt();
        } while (input!=1 && input!=2);
        if ( input == 1 ) {
            tour = new Tour(game.player1, game.pen1);
        } else {
            tour = new Tour(game.player2, game.pen2);
        }
    }

    private void displayBoard() {
        System.out.println(board);
    }

    private void keepAskingPlayerForNewCoordinate() {
        do {
            askUserForNewCoordinate();
        } while (isSetMarkFail());
    }

    public boolean isWinner() {
        return false;
    }

    private void askUserForNewCoordinate() {
        System.out.println("Now player: " + tour.currentPlayer.getName() + " move");
        System.out.println("Please enter column");
        tour.currentCoordinate.column = game.readInput.getInt();
        System.out.println("Please enter row");
        tour.currentCoordinate.row = game.readInput.getInt();
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

    private void switchUser() {
        if (tour.currentPlayer == game.player1) {
            tour.currentPlayer = game.player2;
            tour.currentPen = game.pen2;
        } else {
            tour.currentPlayer = game.player1;
            tour.currentPen = game.pen1;
        }
    }


}
