import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestClass {

    @Test
    public void testEmptyBoard() {
        Board board= new Board();
        for (int x = 0; x < Board.MAX_COL; x++) {
            for (int y = 0; y < Board.MAX_ROW; y++)
                assertEquals(Mark.EMPTY,board.getField(x, y).getMark());
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

        for (int x = 0; x < Board.MAX_COL; x++) {
            for (int y = 0; y < Board.MAX_ROW; y++)
                pen1.mark(board.getField(x, y));
        }

        for (int x = 0; x < Board.MAX_COL; x++) {
            for (int y = 0; y < Board.MAX_ROW; y++)
                assertEquals(Mark.O,board.getField(x, y).getMark());
        }
    }

    @Test (expected = FieldAlreadyMarkedException.class)
    public void testMarkAlreadyMarkedField() throws FieldAlreadyMarkedException {
        Board board = new Board();
        Player player1 = new Player(Mark.O);
        Pen pen1 = new Pen(player1);
        Player player2 = new Player(Mark.X);
        Pen pen2 = new Pen(player2);

        pen1.mark(board.getField(0,0));

        pen2.mark(board.getField(0,0));

    }
}
