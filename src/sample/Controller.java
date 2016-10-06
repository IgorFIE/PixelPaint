package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import sample.Field.Convert;
import sample.Field.Field;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    private Field field;

    @FXML
    Pane myRoot;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        field = new Field(myRoot);

        myRoot.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                field.draw(Convert.toFieldSize((int)event.getX()),Convert.toFieldSize((int)event.getY()));
            }
        });
    }


}
