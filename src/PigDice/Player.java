package PigDice;

public class Player
{
    public int score = 0;
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
}
