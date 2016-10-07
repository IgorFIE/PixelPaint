package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import sample.Field.Convert;
import sample.Field.Field;
import sample.Field.UserPointer;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    private Field field;
    private UserPointer pointer;
    private final Color[] colors = {Color.BLACK,Color.RED,Color.BLUE,Color.GREEN,Color.YELLOW};
    private int color;

    @FXML
    Pane myRoot;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        field = new Field(myRoot);

        pointer = new UserPointer(colors[color]);
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
        mouseMovementHandler();
        mouseClickHandler();
        mouseDragHandler();
        mouseScrollHandler();
    }

    /**
     * handler for Pointer follow mouse
     */
    private void mouseMovementHandler(){
        myRoot.addEventHandler(MouseEvent.ANY, this::mousePointer);
    }

    /**
     * Handler for mouse clicks
     */
    private void mouseClickHandler(){

        myRoot.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            if(event.getButton() == MouseButton.PRIMARY) {
                primaryClick(event);

            } else if(event.getButton() == MouseButton.SECONDARY){
                secondaryClick(event);
            }

        });
    }

    /**
     * Handler for mouse Drag options
     */
    private void mouseDragHandler(){

        myRoot.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {

            if(event.getButton() == MouseButton.PRIMARY) {
                primaryClick(event);

            } else if(event.getButton() == MouseButton.SECONDARY){
                secondaryClick(event);
            }
        });
    }

    /**
     * Scroll Handler
     * Changes the color of the pointer
     */
    private void mouseScrollHandler(){
        myRoot.addEventHandler(ScrollEvent.SCROLL, event -> {
            color++;
            if (!(color < colors.length)) color = 0;
        });
    }

    private void mousePointer(MouseEvent event){
        pointer.draw(Convert.toFieldSize((int) event.getX()), Convert.toFieldSize((int) event.getY()),colors[color]);
    }

    private void primaryClick(MouseEvent event){
        field.draw(Convert.toFieldSize((int) event.getX()), Convert.toFieldSize((int) event.getY()), colors[color]);
    }

    private void secondaryClick(MouseEvent event){
        field.clean(Convert.toFieldSize((int) event.getX()), Convert.toFieldSize((int) event.getY()));
    }

}
