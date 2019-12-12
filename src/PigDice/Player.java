package PigDice;

public class Player
{
    public int score = 0;
    public int roundScore = 0;
    public Player()
    {

    }


    public void scoreAdd(int score)
    {
        this.score += score;
    }

    public void minusScore(int score)
    {
        this.score -= score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setRoundScore(int roundScore) {
        this.roundScore = roundScore;
    }
}
