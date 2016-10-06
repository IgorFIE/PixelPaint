package sample.Field;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by pacifist on 06-10-2016.
 */
public class Cube {

    private int x;
    private int y;

    private Rectangle rect;

    public Cube(int x, int y) {
        this.x = x;
        this.y = y;
        rect = new Rectangle(Convert.toCellSize(x), Convert.toCellSize(y),
                Convert.CELL_SIZE, Convert.CELL_SIZE);
        rect.setStroke(Color.BLACK);
        rect.setFill(Color.WHITE);
    }

    public void draw(){
        rect.setFill(Color.BLACK);
    }

    public void clean(){
        rect.setFill(Color.WHITE);
    }

    public Rectangle getRect() {
        return rect;
    }
}
