package PigDice;

public class PigDice
{
    public static void main(String[] args)
    {

        Turn turn = new Turn();
        Score p1Score = new Score();
        Score p2Score = new Score();
        turn.newTurn();
        System.out.println(turn.getPlayer());
        System.out.println(turn.getTurnNumber());




        }

    }
}
