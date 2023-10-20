public class MyArrayDataException extends RuntimeException{

    public MyArrayDataException(int i, int j, String value){
        super("В ячейке с индексом [" + i + "]["+ j +"] лежит некое \"" + value + "\", что в свою очередь не является числом.");
    }
}
