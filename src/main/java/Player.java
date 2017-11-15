public class Player {
    private String name;
    private Mark mark;

    public Player(Mark mark) {
        this.mark = mark;
    }

    public Mark getMark() {
        return mark;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void mark(Field field) throws FieldAlreadyMarkedException {

        if (field.getMark() == Mark.EMPTY) {
            field.setMark(mark);
        } else {
            throw new FieldAlreadyMarkedException();
        }
    }
}
