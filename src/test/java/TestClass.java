import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestClass {

    @Test
    public void testEmptyBoard() {
        Board board= new Board();
        for (int x = 1; x <= Board.MAX_COL; x++) {
            for (int y = 1; y <= Board.MAX_ROW; y++)
                assertEquals(board.getField(x, y).getMark(),Mark.EMPTY);
        }
    }

    @Test
    public void testPlayers() {
        Player player1 = new Player(Mark.O);
        Player player2 = new Player(Mark.X);
        assertTrue(player1.getMark() == Mark.O);
        assertTrue(player2.getMark() == Mark.X);
    }

    @Test
    public void testPen() throws FieldAlreadyMarkedException {
        Board board = new Board();
        Player player1 = new Player(Mark.O);
        Pen pen1 = new Pen(player1);

        for (int x = 1; x <= Board.MAX_COL; x++) {
            for (int y = 1; y <= Board.MAX_ROW; y++)
                pen1.mark(board.getField(x, y));
        }

        for (int x = 1; x <= Board.MAX_COL; x++) {
            for (int y = 1; y <= Board.MAX_ROW; y++)
                assertEquals(board.getField(x, y).getMark(),Mark.O);
        }
    }

    @Test (expectedExceptions = FieldAlreadyMarkedException.class)
    public void testMarkAlreadyMarkedField() throws FieldAlreadyMarkedException {
        Board board = new Board();
        Player player1 = new Player(Mark.O);
        Pen pen1 = new Pen(player1);
        Player player2 = new Player(Mark.X);
        Pen pen2 = new Pen(player2);

        pen1.mark(board.getField(1,1));

        pen2.mark(board.getField(1,1));

    }
}
