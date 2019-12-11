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
    private GridPane gridpane = new GridPane();
    public Turn turn = new Turn();
    public String roundString = "" + turn.getTurnNumber();
    Label round = new Label("round: " + turn.getTurnNumber());
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        Font font = new Font(12);
        Button newTurn = new Button("new turn");
        newTurn.setOnAction(this::newTurnPress);
        gridpane.add(round, 0, 0);
        gridpane.add(newTurn, 0, 1);
        Scene scene = new Scene(gridpane, 1000, 1000);
        stage.setTitle("Pig Dice");
        stage.setScene(scene);
        stage.show();
    }

    private void newTurnPress(ActionEvent actionEvent)
    {
        turn.newTurn();
        roundString = "round: " + turn.getTurnNumber();
        round.setText(roundString);
    }
}
