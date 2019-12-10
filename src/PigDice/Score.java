package PigDice;
public class Score
{
    public int score = 0;
    public Score()
    {

    }
    public void scoreAdd(int score)
    {
        this.score += score;
    }

    public void scoreMinus(int score)
    {
        this.score -= score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public int getScore()
    {
        return score;
    }
}
