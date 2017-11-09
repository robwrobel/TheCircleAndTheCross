public class Pen {
    Player player;

    public Pen(Player player) {
        this.player=player;
    }

    public void mark(Field field) throws FieldAlreadyMarkedException {

        if (field.getMark() == Mark.EMPTY) {
            field.setMark(player.getMark());
        } else {
            throw new FieldAlreadyMarkedException();
        }
    }
}
