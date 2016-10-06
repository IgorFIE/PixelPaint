package sample;

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
        rect = new Rectangle(Converter.convertToCellSize(x),Converter.convertToCellSize(y),
                Converter.CELL_SIZE,Converter.CELL_SIZE);
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
