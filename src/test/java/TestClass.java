import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

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

    @Test
    public void testHorizontalWinCondition1True() throws FieldAlreadyMarkedException {
        Board board= new Board();
        board.setMaxColumnNo(3);
        board.setMaxRowNo(3);
        board.initialize();
        Arbiter arbiter = new Arbiter(board);
        arbiter.setNoForWin(3);
        Game game = new Game();
        game.pens.get(0).mark(board.getField(0));
        game.pens.get(0).mark(board.getField(1));
        game.pens.get(0).mark(board.getField(2));
        assertTrue(arbiter.isWinner(2));
    }

    @Test
    public void testHorizontalWinCondition1False() throws FieldAlreadyMarkedException {
        Board board= new Board();
        board.setMaxColumnNo(3);
        board.setMaxRowNo(3);
        board.initialize();
        Arbiter arbiter = new Arbiter(board);
        arbiter.setNoForWin(3);
        Game game = new Game();
        game.pens.get(0).mark(board.getField(0));
        game.pens.get(0).mark(board.getField(2));
        assertFalse(arbiter.isWinner(2));
    }

    @Test
    public void testHorizontalWinCondition2True() throws FieldAlreadyMarkedException {
        Board board= new Board();
        board.setMaxColumnNo(5);
        board.setMaxRowNo(4);
        board.initialize();
        Arbiter arbiter = new Arbiter(board);
        arbiter.setNoForWin(4);
        Game game = new Game();
        game.pens.get(0).mark(board.getField(1));
        game.pens.get(0).mark(board.getField(2));
        game.pens.get(0).mark(board.getField(3));
        game.pens.get(0).mark(board.getField(4));
        assertTrue(arbiter.isWinner(4));

    }

    @Test
    public void testHorizontalWinCondition2False() throws FieldAlreadyMarkedException {
        Board board= new Board();
        board.setMaxColumnNo(5);
        board.setMaxRowNo(4);
        board.initialize();
        Arbiter arbiter = new Arbiter(board);
        arbiter.setNoForWin(4);
        Game game = new Game();
        game.pens.get(0).mark(board.getField(1));
        game.pens.get(0).mark(board.getField(2));
        game.pens.get(0).mark(board.getField(4));
        assertFalse(arbiter.isWinner(4));

    }


    @Test
    public void testVerticalWinCondition1True() throws FieldAlreadyMarkedException {
        Board board= new Board();
        board.setMaxColumnNo(3);
        board.setMaxRowNo(3);
        board.initialize();
        Arbiter arbiter = new Arbiter(board);
        arbiter.setNoForWin(3);
        Game game = new Game();
        game.pens.get(0).mark(board.getField(1));
        game.pens.get(0).mark(board.getField(4));
        game.pens.get(0).mark(board.getField(7));
        assertTrue(arbiter.isWinner(4));

    }

    @Test
    public void testVerticalWinCondition1False() throws FieldAlreadyMarkedException {
        Board board= new Board();
        board.setMaxColumnNo(3);
        board.setMaxRowNo(3);
        board.initialize();
        Arbiter arbiter = new Arbiter(board);
        arbiter.setNoForWin(3);
        Game game = new Game();
        game.pens.get(0).mark(board.getField(1));
        game.pens.get(0).mark(board.getField(4));

        assertFalse(arbiter.isWinner(4));

    }

    @Test
    public void testVerticalWinCondition2True() throws FieldAlreadyMarkedException {
        Board board= new Board();
        board.setMaxColumnNo(6);
        board.setMaxRowNo(5);
        board.initialize();
        Arbiter arbiter = new Arbiter(board);
        arbiter.setNoForWin(3);
        Game game = new Game();
        game.pens.get(0).mark(board.getField(1));
        game.pens.get(0).mark(board.getField(7));
        game.pens.get(0).mark(board.getField(13));
        assertTrue(arbiter.isWinner(7));

    }

    @Test
    public void testVerticalWinCondition2False() throws FieldAlreadyMarkedException {
        Board board= new Board();
        board.setMaxColumnNo(6);
        board.setMaxRowNo(5);
        board.initialize();
        Arbiter arbiter = new Arbiter(board);
        arbiter.setNoForWin(3);
        Game game = new Game();
        game.pens.get(0).mark(board.getField(1));
        game.pens.get(0).mark(board.getField(7));

        assertFalse(arbiter.isWinner(7));

    }

    @Test
    public void testWinConditionFalse() throws FieldAlreadyMarkedException {
        Board board= new Board();
        board.setMaxColumnNo(2);
        board.setMaxRowNo(2);
        board.initialize();
        Arbiter arbiter = new Arbiter(board);
        arbiter.setNoForWin(2);
        Game game = new Game();
        game.pens.get(0).mark(board.getField(0));
        game.pens.get(1).mark(board.getField(1));

        assertFalse(arbiter.isWinner(1));

    }

}
