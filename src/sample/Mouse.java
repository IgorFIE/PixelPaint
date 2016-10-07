package sample;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import sample.Field.Convert;
import sample.Field.UserPointer;

/**
 * Created by pacifist on 07-10-2016.
 */
public class Mouse {

    private UserPointer pointer;
    private Controller controller;

    public Mouse(Controller controller) {
        this.controller = controller;

        pointer = new UserPointer((controller.getColors())[controller.getColor()]);
        controller.getMyRoot().getChildren().add(pointer.getRect());

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
        controller.getMyRoot().addEventHandler(MouseEvent.ANY, this::mousePointer);
    }

    /**
     * Handler for mouse clicks
     */
    private void mouseClickHandler(){

        controller.getMyRoot().addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

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

        controller.getMyRoot().addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {

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
        controller.getMyRoot().addEventHandler(ScrollEvent.SCROLL, event -> {

            controller.setColor(controller.getColor() + 1);
            if (!(controller.getColor() < controller.getColors().length)) controller.setColor(0);

        });
    }

    private void mousePointer(MouseEvent event){
        pointer.draw(Convert.toFieldSize((int) event.getX()),
                Convert.toFieldSize((int) event.getY()),
                ((controller.getColors())[controller.getColor()]));
    }

    private void primaryClick(MouseEvent event){
        controller.getField().draw(Convert.toFieldSize((int) event.getX()),
                Convert.toFieldSize((int) event.getY()),
                ((controller.getColors())[controller.getColor()]));
    }

    private void secondaryClick(MouseEvent event){
        controller.getField().clean(Convert.toFieldSize((int) event.getX()),
                Convert.toFieldSize((int) event.getY()));
    }

}
