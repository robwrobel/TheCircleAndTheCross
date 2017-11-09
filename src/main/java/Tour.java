public class Tour {
    Player currentPlayer;
    Pen currentPen;
    Coordinate currentCoordinate=new Coordinate();

    public Tour(Player player,Pen pen) {
        currentPlayer= player;
        currentPen=pen;
    }
}
