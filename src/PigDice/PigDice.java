package PigDice;

public class PigDice
{
    public static void main(String[] args)
    {
        Dice dice = new Dice(6);
        dice.roll();
        System.out.println(dice);
        dice.roll();
        System.out.println(dice);
        Score score = new Score();
        score.scoreAdd(100);
        System.out.println(score.getScore());
        score.scoreMinus(1);
        System.out.println(score.getScore());

    }
}
