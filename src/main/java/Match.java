public class Match {
    Game game;
    Board board = new Board();
    Tour tour ;
    Arbiter arbiter = new Arbiter(board);
    Scores scores;

    public Match(Game game, Scores scores) {
        this.game = game;
        this.scores = scores;
    }

    public void start() {

        whoBegins();
        sizeOfBoard();
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

    private void sizeOfBoard() {
        System.out.println("Please enter number of columns");
        board.setMaxColumnNo(game.readInput.getInt());
        System.out.println("Please enter number of rows");
        board.setMaxRowNo(game.readInput.getInt());
        board.initialize();
    }

    private void whoBegins() {
        System.out.println("Please select who begins (1 - Player1: " + game.players.get(0).getName() + " , 2 - Player2: "+game.players.get(1).getName()+ ")");
        int input;
        do {
            input = game.readInput.getInt();
        } while (input != 1 && input != 2);
        if ( input == 1 ) {
            tour = new Tour(game.players.get(0), game.pens.get(0));
        } else {
            tour = new Tour(game.players.get(1), game.pens.get(1));
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
        return false;
    }

    public boolean isDraw() {
        return arbiter.isDraw();
    }

    private void askUserForNewId() {
        System.out.println("Now player: " + tour.currentPlayer.getName() + " move");
        System.out.println("Please enter id");
        tour.currentId = game.readInput.getInt();
    }

    public boolean isSetMarkFail() {
        int currentId=tour.currentId;
        try {
            tour.currentPen.mark(board.getField(currentId));
            return false;
        } catch (FieldAlreadyMarkedException e) {
            return true;
        }
    }

    private void switchUser() {
        if (tour.currentPlayer == game.players.get(0)) {
            tour.currentPlayer = game.players.get(1);
            tour.currentPen = game.pens.get(1);
        } else {
            tour.currentPlayer = game.players.get(0);
            tour.currentPen = game.pens.get(0);
        }
    }



}
