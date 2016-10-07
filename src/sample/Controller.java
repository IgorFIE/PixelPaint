package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import sample.Field.Convert;
import sample.Field.Field;
import sample.Field.UserPointer;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    private Field field;
    private UserPointer pointer;

    @FXML
    Pane myRoot;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        field = new Field(myRoot);
        pointer = new UserPointer();
        myRoot.getChildren().add(pointer.getRect());

        mouseControl();
    }

    /**
     * Mouse controllers
     *
     * Mouse Pointer follows mouse Position x,y
     *
     * Primary - Draw
     * Secondary - Clean
     *
     */
    private void mouseControl(){

        //Makes the Pointer follow the Mouse
        myRoot.addEventHandler(MouseEvent.MOUSE_MOVED, event -> {

            pointer.draw(Convert.toFieldSize((int) event.getX()), Convert.toFieldSize((int) event.getY()));

        });

        //Mouse Primary and Secondary Buttons
        myRoot.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            if(event.getButton() == MouseButton.PRIMARY) {
                primaryClick(event);

            } else if(event.getButton() == MouseButton.SECONDARY){
                secundaryClick(event);
            }

        });

        //Mouse Continuous Painting
        myRoot.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {

            if(event.getButton() == MouseButton.PRIMARY) {
                primaryClick(event);

            } else if(event.getButton() == MouseButton.SECONDARY){
                secundaryClick(event);
            }

        });
    }
    
    private void primaryClick(MouseEvent event){
        field.draw(Convert.toFieldSize((int) event.getX()), Convert.toFieldSize((int) event.getY()));
    }

    private void secundaryClick(MouseEvent event){
        field.clean(Convert.toFieldSize((int) event.getX()), Convert.toFieldSize((int) event.getY()));
    }

}
