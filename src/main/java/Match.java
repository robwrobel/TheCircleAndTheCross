import java.util.List;

public class Match {
    Board board = new Board();
    Tour tour ;
    Arbiter arbiter = new Arbiter(board);
    Scores scores;
    ReadInput readInput;
    List<Player> players;

    public Match(Scores scores, ReadInput readInput, List<Player> players) {
        this.scores = scores;
        this.readInput = readInput;
        this.players = players;

    }

    public void start() {

        whoBegins();
        sizeOfBoard();
        noForWin();
        do {
            displayBoard();
            keepAskingPlayerForNewId();
            if (isWinner()) {
                tour.isWinner = true;
                break;
            } else if (isDraw()) {
                tour.isDraw = true;
                break;
            }
            switchUser();
        } while (true);

        displayBoard();

        if (tour.isWinner) {
            System.out.println(tour.currentPlayer.getName() + " wins");
            scores.updateScoreForWinner(tour.currentPlayer);
        } else if (tour.isDraw) {
            System.out.println("We have a draw");
            scores.updateScoreForDraw();
        }
   }

    private void noForWin() {
        System.out.println("Please enter number of consecutive marks for win");
        arbiter.setNoForWin(readInput.getInt());
    }

    private void sizeOfBoard() {
        System.out.println("Please enter number of columns");
        board.setMaxColumnNo(readInput.getInt());
        System.out.println("Please enter number of rows");
        board.setMaxRowNo(readInput.getInt());
        board.initialize();
    }

    private void whoBegins() {
        System.out.println("Please select who begins (1 - Player1: " + players.get(0).getName() + " , 2 - Player2: "+players.get(1).getName()+ ")");
        int input;
        do {
            input = readInput.getInt();
        } while (input != 1 && input != 2);
        if ( input == 1 ) {
            tour = new Tour(players.get(0));
        } else {
            tour = new Tour(players.get(1));
        }
    }

    private void displayBoard() {
        System.out.println(board);
    }

    private void keepAskingPlayerForNewId() {
        do {
            askUserForNewId();
        } while (isSetMarkFail());
    }

    public boolean isWinner() {

        return arbiter.isWinner(tour.currentId);
    }

    public boolean isDraw() {
        return arbiter.isDraw();
    }

    private void askUserForNewId() {
        System.out.println("Now player: " + tour.currentPlayer.getName() + " move");
        System.out.println("Please enter id");
        tour.currentId = readInput.getInt();
    }

    public boolean isSetMarkFail() {
        int currentId=tour.currentId;
        try {
            tour.currentPlayer.mark(board.getField(currentId));
            return false;
        } catch (FieldAlreadyMarkedException | FieldIndexOutOfBoundsException e) {
            return true;
        }
    }

    private void switchUser() {
        if (tour.currentPlayer == players.get(0)) {
            tour.currentPlayer = players.get(1);

        } else {
            tour.currentPlayer = players.get(0);
        }
    }

}
