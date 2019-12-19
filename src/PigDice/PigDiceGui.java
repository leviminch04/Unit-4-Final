package PigDice;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PigDiceGui extends Application
{
    //declaring all of the variables
    boolean chnageTurnName = true;
    Dice d1 = new Dice(6);
    Dice d2 = new Dice(6);
    private GridPane gridpane = new GridPane();
    private Label diceAmount = new Label("Dice Haven't Been Rolled Yet");
    public Turn turn = new Turn();
    public String roundString = "" + turn.getTurnNumber();
    public String playerString = "";
    Label round = new Label("round: " + turn.getTurnNumber());
    Label player = new Label("Player " + turn.getPlayer() + " turn");
    Player p1 = new Player();
    Player p2 = new Player();
    Label p1Text = new Label("Player 1's score: " + p1.getScore());
    String p1TextString = "Player 1's score: "  + p1.getScore();
    Label p1RoundScore = new Label("Player 1's round score: " + p1.getRoundScore());
    String p1RoundScoreString = "Player 1's round score: " + p1.getRoundScore();
    Label p2Text = new Label("Player 1's score: " + p2.getScore());
    String p2TextString = "Player 2's score: " + p2.getScore();
    Label p2RoundScore = new Label("Player 2's round score: " + p2.getRoundScore());
    String p2RoundScoreString = "Player 2's round score: " + p2.getRoundScore();
    Button newTurn = new Button("Start Game");
    Button rollDice = new Button("Roll");
    Font font = new Font(20);
    Label win = new Label("");

    public static void main(String[] args) {
        launch(args);
    }

    private void log(String str)
    {
        System.out.println(str);
    }

    @Override
    public void start(Stage stage)
    {
        win.setFont(font);
        newTurn.setOnAction(this::newTurnPress);
        rollDice.setOnAction(this::newDiceRoll);

        //adding everything to a gridpane
        gridpane.add(round, 1, 0);
        gridpane.add(newTurn, 0, 0);
        gridpane.add(player, 0, 2);
        gridpane.add(rollDice, 0, 1);
        gridpane.add(diceAmount, 1, 1);
        gridpane.add(p1Text, 0, 3);
        gridpane.add(p1RoundScore, 2,3);
        gridpane.add(p2Text, 0, 4);
        gridpane.add(p2RoundScore, 2,4);
        gridpane.add(win, 2, 0);

        Scene scene = new Scene(gridpane, 500, 105);
        stage.setTitle("Pig Dice");
        stage.setScene(scene);
        stage.show();
    }

    private void newTurnPress(ActionEvent actionEvent)
    {
        //changes the writing on the button "newTurn" to "pass" instead of the original "Start Game"
        if(chnageTurnName)
        {
            newTurn.setText("Pass");
        }
        /*
        setting both of the players round scores to 0 after adding the round score to there total score
         */
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

        //checking to see if one of the players have won, if so displaying win text and disabling the buttons
        if(p1.getScore() >= 100)
        {
            win.setText("Player 1 wins!");
            rollDice.setDisable(true);
            newTurn.setDisable(true);
        }

        else if(p2.getScore() >= 100)
        {
            win.setText("Player 2 wins!");
            rollDice.setDisable(true);
            newTurn.setDisable(true);
        }

    }

    private void newDiceRoll(ActionEvent actionEvent)
    {
        //rolls the dice then updates the diceAmount text
        d1.roll();
        d2.roll();
        diceAmount.setText("Dice 1 is: " + d1 + ", Dice 2 is: " + d2);
        //checking to see if it the first players turn
        if(turn.getPlayer() == 1)
        {
            //checks to see if either of the dice are 1
            if(d1.getValue() == 1 || d2.getValue() == 1)
            {
                /*checks to see if both of the dice are one
                  if both of the dice are one it runs the code for snake eyes
                */

                if(d2.getValue() == 1 && d1.getValue() == 1)
                {
                    //sets player ones round score and player ones total score to 0 and goes to the next turn
                    p1.setRoundScore(0);
                    p1.setScore(0);
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
                }
                //sets player ones round total 0 and goes to the next round
                else
                {
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
                }
            }
            //adds the dice values to the round score
            else
            {
                p1.addRoundScore(d1.value + d2.value);
                p1RoundScoreString = "Player 1's round score: " + p1.getRoundScore();
                p1RoundScore.setText(p1RoundScoreString);
            }
        }
        //checking to see if it the second players turn
        else if(turn.getPlayer() == 2)
        {
            //checks to see if either of the dice are 1
            if(d1.getValue() == 1 || d2.getValue() == 1)
            {
                 /*checks to see if both of the dice are one
                  if both of the dice are one it runs the code for snake eyes
                */
                if(d1.getValue() == 1 && d2.getValue() == 1)
                {
                    p2.setRoundScore(0);
                    p2.setScore(0);
                    turn.newTurn();
                    roundString = "round: " + turn.getTurnNumber();
                    round.setText(roundString);
                    playerString = "player " + turn.getPlayer() + " turn";
                    player.setText(playerString);
                    p2.scoreAdd(p2.getRoundScore());
                    p2TextString = "Player 2's score: "  + p2.getScore();
                    p2Text.setText(p2TextString);
                    p2.setRoundScore(0);
                    p2RoundScoreString = "Player 2's round score: " + p2.getRoundScore();
                    p2RoundScore.setText(p2RoundScoreString);
                }
                //sets player ones round total 0 and goes to the next round
                else
                {
                    turn.newTurn();
                    roundString = "round: " + turn.getTurnNumber();
                    round.setText(roundString);
                    playerString = "player " + turn.getPlayer() + " turn";
                    player.setText(playerString);
                    p2.scoreAdd(p2.getRoundScore());
                    p2TextString = "Player 2's score: "  + p2.getScore();
                    p2Text.setText(p2TextString);
                    p2.setRoundScore(0);
                    p2RoundScoreString = "Player 2's round score: " + p2.getRoundScore();
                    p2RoundScore.setText(p2RoundScoreString);
                }
            }

            //adds the dice values to the round score
            else
            {
                p2.addRoundScore(d1.value + d2.value);
                p2RoundScoreString = "Player 2's round score: " + p2.getRoundScore();
                p2RoundScore.setText(p2RoundScoreString);
            }
        }

        //checking to see if one of the players have won, if so displaying win text and disabling the buttons
        if(p1.getScore() >= 100)
        {
            win.setText("Player 1 wins!");
            rollDice.setDisable(true);
            newTurn.setDisable(true);
        }

        else if(p2.getScore() >= 100)
        {
            win.setText("Player 2 wins!");
            rollDice.setDisable(true);
            newTurn.setDisable(true);
        }
    }
}
