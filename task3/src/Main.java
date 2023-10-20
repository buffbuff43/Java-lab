import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"5", "90,0", "5", "90.1"},
                {"241", "25.7", "256", "256"},
                {"750", "750", "900", "967"},
                {"160", "960", "12,8", "128"}
        };

        try {
            double result = method(array);
            System.out.printf("Сумма всех чисел матрицы: %.3f", result);
        } catch (MyArraySizeException | MyArrayDataException | MyNoHammingException e) {
            e.printStackTrace();
        }
    }

    public static double method(String[][] array) throws MyArraySizeException, MyArrayDataException, MyNoHammingException {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i].length != 4) {
                    throw new MyArraySizeException();
                }
            }
        }

        double sum = 0.0;
        double number;

        for (int k = 1; k <= 4; k++) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    try {
                        if(array[i][j].contains(",")){
                            array[i][j] = array[i][j].replace(',','.');
                        }
                        number = Double.parseDouble(array[i][j]);
                        sum += number;
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(i, j, array[i][j]);
                    }
                    try {
                        if (array[i][j].length() == k && !Hamming(number)) {
                            throw new MyNoHammingException(i, j, array[i][j]);
                        }
                    } catch (MyNoHammingException ham) {
                        ham.printStackTrace();
                    }
                }
            }
        }
        return sum/4.0;

    }

    public static boolean Hamming(double number) {
        double n = 86;
        double[] noHammingNumbers = new double[(int) n];
        noHammingNumbers[0] = 1;

        double index2 = 0, index3 = 0, index5 = 0;

        double nextMultipleOf2 = 2;
        double nextMultipleOf3 = 3;
        double nextMultipleOf5 = 5;

        for (int i = 1; i < n; i++) {
            double min = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
            noHammingNumbers[i] = min;

            if (min == nextMultipleOf2) {
                index2++;
                nextMultipleOf2 = noHammingNumbers[(int)index2] * 2;
            }
            if (min == nextMultipleOf3) {
                index3++;
                nextMultipleOf3 = noHammingNumbers[(int)index3] * 3;
            }
            if (min == nextMultipleOf5) {
                index5++;
                nextMultipleOf5 = noHammingNumbers[(int)index5] * 5;
            }
        }

        for (int i = 1; i < n; i++) {
            if (number == noHammingNumbers[i]) {
                return true;
            }
        }
        return false;
    }
}
