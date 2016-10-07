package sample.Field;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * Created by pacifist on 06-10-2016.
 */
public class Field {

    private Cube[][] cubeField;

    /**
     * Field Constructor receives a Pane to receive the Rectangles
     * Creates a Field with the correspondent size
     *
     * @param pane
     */
    public Field(Pane pane) {

        int paneXsize = Convert.toFieldSize((int)pane.getPrefWidth());
        int paneYsize = Convert.toFieldSize((int)pane.getPrefHeight());

        this.cubeField = new Cube[paneXsize][paneYsize];
        createField(pane);
    }

    /**
     * Creates the Field and add the Rectangles to the Pane
     * @param pane
     */
    private void createField(Pane pane){
        for(int x = 0; x < cubeField.length;x++){
            for(int y = 0; y < cubeField[x].length;y++){

                this.cubeField[x][y] = new Cube(x,y);
                pane.getChildren().add(cubeField[x][y].getRect());

            }
        }
    }

    /**
     * Pick the cube in the x,y position and fill it
     * @param x
     * @param y
     */
    public void draw(int x, int y , Color color){
        this.cubeField[x][y].draw(color);
    }

    /**
     * Pick the cube in the x,y position and clean it
     * @param x
     * @param y
     */
    public void clean(int x, int y){
        this.cubeField[x][y].clean();
    }
}
