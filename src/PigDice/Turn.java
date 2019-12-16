package PigDice;

public class Turn {
    private int turnNumber = 0;
    public int player;
    public Turn()
    {

    }
    public void newTurn() {
        turnNumber++;
        //even numbers = player 2
        if (turnNumber % 2 == 0) {
            player = 2;
        }
        //odd numbers = player 1
        else
            player = 1;
    }

    public int getPlayer() {
        return player;
    }

    public int getTurnNumber() {
        return turnNumber;
    }
}
