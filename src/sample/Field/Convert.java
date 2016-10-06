package sample.Field;

/**
 * Created by pacifist on 06-10-2016.
 */
public class Convert {

    public static final int CELL_SIZE = 10;

    public static int toCellSize(int numb){
        return numb * CELL_SIZE;
    }

    public static int toFieldSize(int numb){
        return (int)Math.floor(numb/CELL_SIZE);
    }
}
