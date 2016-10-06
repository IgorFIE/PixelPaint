package sample.Field;

import javafx.scene.layout.Pane;

/**
 * Created by pacifist on 06-10-2016.
 */
public class Field {

    private Cube[][] cubeField;

    public Field(Pane pane) {

        int paneXsize = Convert.toFieldSize((int)pane.getPrefWidth());
        int paneYsize = Convert.toFieldSize((int)pane.getPrefHeight());

        this.cubeField = new Cube[paneXsize][paneYsize];
        createField(pane);
    }

    private void createField(Pane pane){
        for(int x = 0; x < cubeField.length;x++){
            for(int y = 0; y < cubeField[x].length;y++){

                this.cubeField[x][y] = new Cube(x,y);
                pane.getChildren().add(cubeField[x][y].getRect());

            }
        }
    }

    public void draw(int x, int y){
        this.cubeField[x][y].draw();
    }

    public void clean(int x, int y){
        this.cubeField[x][y].clean();
    }
}
