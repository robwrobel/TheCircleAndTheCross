public class Field {
    private Mark mark;

    public Field() {
        this.mark = Mark.EMPTY;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return getMark().toString();
    }
}
