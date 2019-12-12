package PigDice;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
        d1.roll();
        d2.roll();
    }
}
