public class Field {
    private Mark mark;
    private int id;

    public Field() {
        this.mark = Mark.EMPTY;
    }

    public Field(int id) {
        this.mark = Mark.EMPTY;
        this.id = id;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return getMark()==Mark.EMPTY ? String.valueOf(id) : getMark().toString();
    }

    public int getId() {
        return id;
    }
}
