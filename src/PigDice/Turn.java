package PigDice;

public class Turn {
    private int turnNumber = 0;
    public int player;
    public Turn()
    {

    }
    public void newTurn() {
        turnNumber++;
        if (turnNumber % 2 == 0) {
            player = 1;
        }
        else
            player = 2;
    }

    public int getPlayer() {
        return player;
    }

    public int getTurnNumber() {
        return turnNumber;
    }
}
