public class Board {
    public static final int MAX_COL = 3 ;
    public static final int MAX_ROW = 3;

    Field [][] board = new Field [MAX_COL][MAX_ROW];

    public Board() {
        initializeBoard();
    }

    private void initializeBoard() {
        for (int col = 0; col < Board.MAX_COL; col++) {
            for (int row = 0; row < Board.MAX_ROW; row++)
                board[col][row]=new Field();
        }
    }

    public Field getField(int col, int row) {
        return board[col][row];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Row\\Col");
        for (int col = 0; col< MAX_COL; col++) {
            sb.append(" ");
            sb.append(col+1);
        }
        sb.append("\n");
        for (int row=0; row<MAX_ROW ; row++) {
            sb.append(row + 1);
            sb.append("       ");
            for (int col = 0; col < MAX_COL; col++) {
                sb.append(board[col][row]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
