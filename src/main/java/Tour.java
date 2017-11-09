public class Tour {
    Player currentPlayer;
    Pen currentPen;
    public boolean isWinner;
    public boolean isDraw;
    public int currentId;

    public Tour(Player player,Pen pen) {
        currentPlayer= player;
        currentPen=pen;
    }
}
