package sample;

/**
 * Created by pacifist on 06-10-2016.
 */
public class Converter {

    public static final int CELL_SIZE = 10;

    public static int convertToCellSize(int numb){
        return numb * CELL_SIZE;
    }

    public static int convertToFieldSize(int numb){
        return numb/CELL_SIZE;
    }
}
