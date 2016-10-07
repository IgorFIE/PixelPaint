package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import sample.Field.Field;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    private Field field;
    private Mouse mouse;

    private final Color[] colors = {Color.BLACK,Color.RED,Color.BLUE,Color.GREEN,Color.YELLOW};
    private int color;

    @FXML
    private Pane myRoot;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        field = new Field(myRoot);
        mouse = new Mouse(this);

    }

    public Field getField() {
        return field;
    }

    public Color[] getColors() {
        return colors;
    }

    public int getColor() {
        return color;
    }

    public Pane getMyRoot() {
        return myRoot;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
