package PigDice;

public class Turn {
    private int turnNumber = 0;
    public boolean isPlayerOne;
    public boolean isPlayerTwo;
    public turn()
    {

    }
    public int newTurn()
    {
        turnNumber++;
        if(turnNumber % 2 == 0) {
            isPlayerTwo = false;
            isPlayerOne = true;
        }
        else{
            isPlayerOne = false;
            isPlayerTwo = true;
        }
    }

}
