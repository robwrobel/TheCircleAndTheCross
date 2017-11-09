import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestClass {

    @Test
    public void testEmptyBoard() {
        Board board = new Board();
        board.setMaxColumnNo(3);
        board.setMaxRowNo(3);
        board.initialize();
        int id = 0;
        for (Field f : board.fieldList) {
            assertEquals(f.getId(), id);
            id++;
        }
    }

    @Test
    public void testPen() throws FieldAlreadyMarkedException {
        Board board = new Board();
        board.setMaxColumnNo(3);
        board.setMaxRowNo(3);
        board.initialize();
        Game game = new Game();

        Pen pen1 = new Pen(game.players.get(0));
        for (int i = 0; i < board.noOfElements; i++) {
            pen1.mark(board.getField(i));
        }
        for (int i = 0; i < board.noOfElements; i++) {
            assertEquals(board.getField(i).getMark(), Mark.O);
        }
    }

    @Test(expectedExceptions = FieldAlreadyMarkedException.class)
    public void testMarkAlreadyMarkedField() throws FieldAlreadyMarkedException {
        Board board = new Board();
        board.setMaxColumnNo(3);
        board.setMaxRowNo(3);
        board.initialize();
        Game game = new Game();
        Pen pen1 = new Pen(game.players.get(0));

        pen1.mark(board.getField(0));
        pen1.mark(board.getField(0));
    }
}
