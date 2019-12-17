package PigDice;

public class Score
{
    int score = 0;
    int roundScore = 0;
    public Score()
    {

    }

    public void addRoundScore(int roundScore)
    {
        this.roundScore = roundScore;
    }

    public void snakeEyes()
    {
        this.roundScore = 0;
        this.score = 0;
    }

    public void oneOne()
    {
        this.roundScore = 0;
    }

    public int getRoundScore()
    {
        return roundScore;
    }

    public int getScore() {
        return score;
    }
}