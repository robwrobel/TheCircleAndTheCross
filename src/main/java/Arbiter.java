public class Arbiter {

    private final Board board;

    public Arbiter(Board board) {
        this.board = board;
    }

    public boolean isDraw() {
        for (int i=0 ; i < board.noOfElements ; i++) {
            if ( board.getField(i).getMark() == Mark.EMPTY ) {
                return false;
            }
        }
        return true;
    }
}
