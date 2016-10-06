package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    private Field field;

    @FXML
    Pane myRoot;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        field = new Field(myRoot);
    }


}
