import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Arbiter {

    private final Board board;

    private int noForWin;

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


    public boolean isWinner(int currentId) {
        return horizontalWinCondition(currentId)
                || verticalWinCondition(currentId);
    }

    private boolean horizontalWinCondition(int currentId) {
        List<Integer> rowIds= new ArrayList<>();
        rowIds = findRowIds(currentId);
        return checkForWin(rowIds,board.getField(currentId).getMark());

    }

    private boolean verticalWinCondition(int currentId) {
        List<Integer> colIds= new ArrayList<>();
        colIds = findColIds(currentId);
        return checkForWin(colIds,board.getField(currentId).getMark());

    }

    private List<Integer> findColIds(int currentId) {
        Integer colId = currentId % board.maxColNo;
        return IntStream.iterate(colId,(int i) -> i + board.maxColNo)
                .limit(board.maxRowNo)
                .mapToObj((int i) -> new Integer(i))
                .collect(Collectors.toList());
    }

    private boolean checkForWin(List<Integer> list , Mark mark) {
        int counter = 0;
        for (Integer i: list) {
            if (board.getField(i).getMark().equals(mark)) {
                counter++;
            } else {
                counter = 0;
            }
            if (counter == noForWin) {
                return true;
            }
        }
        return false;
    }

    private List<Integer> findRowIds(int currentId) {
        Integer rowId = currentId/board.maxColNo;
        return IntStream.iterate(rowId*board.maxColNo,(int i) -> ++i)
                .limit(board.maxColNo)
                .mapToObj((int i)->new Integer(i))
                .collect(Collectors.toList());
    }

    public void setNoForWin(int noForWin) {
        this.noForWin = noForWin;
    }
}
