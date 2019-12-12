package PigDice;

public class Turn {
    private int turnNumber = 1;
    public int player = 1;
    public Turn()
    {

    }
    public void newTurn() {
        turnNumber++;
        if (turnNumber % 2 == 0) {
            player = 2;
        }
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
