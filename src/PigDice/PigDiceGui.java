package PigDice;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PigDiceGui extends Application
{
    Dice d1 = new Dice(6);
    Dice d2 = new Dice(6);
    private GridPane gridpane = new GridPane();
    private TextField diceAmount = new TextField();
    public Turn turn = new Turn();
    public String roundString = "" + turn.getTurnNumber();
    public String playerString = "";
    Label round = new Label("round: " + turn.getTurnNumber());
    Label player = new Label("Player " + turn.getPlayer() + " turn");
    Player p1 = new Player();
    Player p2 = new Player();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        Font font = new Font(12);
        Button newTurn = new Button("new turn");
        newTurn.setOnAction(this::newTurnPress);
        Button rollDice = new Button("Roll");
        rollDice.setOnAction(this::newDiceRoll);
        gridpane.add(round, 0, 0);
        gridpane.add(newTurn, 0, 1);
        gridpane.add(player, 0, 2);
        gridpane.add(rollDice, 100, 0);
        gridpane.add(diceAmount, 10, 10);
        diceAmount.setEditable(false);
        Scene scene = new Scene(gridpane, 1920, 900);
        stage.setTitle("Pig Dice");
        stage.setScene(scene);
        stage.show();
    }

    private void newTurnPress(ActionEvent actionEvent)
    {
        turn.newTurn();
        roundString = "round: " + turn.getTurnNumber();
        round.setText(roundString);
        playerString = "player " + turn.getPlayer() + " turn";
        player.setText(playerString);

    }
    private void newDiceRoll(ActionEvent actionEvent)
    {
        diceAmount.setText("Dice 1 is " + d1 + "Dice 2 is " + d2);
        if(turn.getPlayer() == 1)
        {
            d1.roll();
            d2.roll();
            diceAmount.setText("Dice 1 is " + d1 + "Dice 2 is " + d2);
            if(d1.getValue() == 1)
            {
                if(d2.getValue() == 1)
                {
                    p1.setRoundScore(0);
                    p1.setScore(0);
                    turn.newTurn();
                }
                else
                {
                    p1.setRoundScore(0);
                    turn.newTurn();
                }
            }
            else if(d2.getValue() == 1)
            {
                p1.setRoundScore(0);
                turn.newTurn();
            }
            else
            {
                p1.addRoundScore(d1.value + d2.value);
            }
        }

        if(turn.getPlayer() == 2)
        {
            d1.roll();
            d2.roll();
            diceAmount.setText("Dice 1 is " + d1 + "Dice 2 is " + d2);
            if(d1.getValue() == 1)
            {
                if(d2.getValue() == 1)
                {
                    p2.setRoundScore(0);
                    p2.setScore(0);
                    turn.newTurn();
                }
                else
                {
                    p2.setRoundScore(0);
                    turn.newTurn();
                }
            }
            else if(d2.getValue() == 1)
            {
                p2.setRoundScore(0);
                turn.newTurn();
            }
            else
            {
                p2.addRoundScore(d1.value + d2.value);
            }
        }




    }
}
