package sample.Field;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by pacifist on 07-10-2016.
 */
public class UserPointer {

    private Rectangle rect;

    /**
     * User Pointer Constructor
     */
    public UserPointer(Color color) {
        rect = new Rectangle(0,0,Convert.CELL_SIZE,Convert.CELL_SIZE);
        rect.setStroke(Color.YELLOW);
        rect.setFill(color);
    }

    /**
     * Move the pointer to the x,y position
     *
     * @param x
     * @param y
     */
    public void draw(int x, int y , Color color){
        rect.setX(x*Convert.CELL_SIZE);
        rect.setY(y*Convert.CELL_SIZE);
        rect.setFill(color);
    }

    public Rectangle getRect() {
        return rect;
    }
}
