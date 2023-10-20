
public class MyNoHammingException extends RuntimeException{

        public MyNoHammingException(int i, int j, String value){
            super("В ячейке с индексом [" + i + "]["+ j +"] лежит \"" + value + "\", что в свою очередь не является числом Хемминга.");
        }

    }
