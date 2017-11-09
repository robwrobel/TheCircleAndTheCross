public class Player {
    private Mark mark;
    private String name;
    private int score = 0;

    public Player(Mark mark) {
        this.mark=mark;
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

    public void updateScoreForWinner() {
        score += Scores.WIN.getScore();
    }

    public void updateScoreForDraw() {
        score += Scores.DRAW.getScore();
    }

    public int getScore() {
        return score;
    }
}
