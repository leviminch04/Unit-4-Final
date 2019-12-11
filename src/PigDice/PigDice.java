package PigDice;

public class PigDice
{
    public static void main(String[] args)
    {

        Turn turn = new Turn();
        Score p1Score = new Score();
        Score p2Score = new Score();
        System.out.println("player " + turn.getPlayer());
        System.out.println("turn number " + turn.getTurnNumber());
        turn.newTurn();
        System.out.println("turn number " + turn.getTurnNumber());
        System.out.println("player " + turn.getPlayer());
        turn.newTurn();
        System.out.println("turn number " + turn.getTurnNumber());
        System.out.println("player " + turn.getPlayer());


    }
}
