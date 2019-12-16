package PigDice;

import javafx.scene.control.Button;

public class newTurnPress{
    public newTurnPress()
    {

    }


    public void turnPress()
    {
        if(chnageTurnName)
        {
            newTurn.setText("Pass");
        }

        turn.newTurn();
        roundString = "round: " + turn.getTurnNumber();
        round.setText(roundString);
        playerString = "player " + turn.getPlayer() + " turn";
        player.setText(playerString);
        p1.scoreAdd(p1.getRoundScore());
        p1TextString = "Player 1's score: "  + p1.getScore();
        p1Text.setText(p1TextString);
        p1.setRoundScore(0);
        p1RoundScoreString = "Player 1's round score: " + p1.getRoundScore();
        p1RoundScore.setText(p1RoundScoreString);
        p2.scoreAdd(p2.getRoundScore());
        p2TextString = "Player 1's score: "  + p2.getScore();
        p2Text.setText(p2TextString);
        p2.setRoundScore(0);
        p2RoundScoreString = "Player 2's round score: " + p2.getRoundScore();
        p2RoundScore.setText(p2RoundScoreString);


    }





}
