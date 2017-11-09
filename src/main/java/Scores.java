public enum Scores {
    WIN(3),DRAW(1);
    private int score;
    Scores(int score) {
        this.score=score;
    }

    public int getScore() {
        return score;
    }
}
