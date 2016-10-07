package sample.Field;

/**
 * Created by pacifist on 06-10-2016.
 */
public class Convert {

    public static final int CELL_SIZE = 10;

    /**
     * Multiply a number by the cellSize
     *
     * @param numb
     * @return
     */
    public static int toCellSize(int numb){
        return numb * CELL_SIZE;
    }

    /**
     * Divide a number by the cellSize
     *
     * @param numb
     * @return
     */
    public static int toFieldSize(int numb){
        return (int)Math.floor(numb/CELL_SIZE);
    }
}
