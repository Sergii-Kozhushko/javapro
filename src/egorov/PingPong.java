/**
 * PingPong.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 14-Mar-2023 16:51
 */

package egorov;

public class PingPong {
    private static final int MAXI = 5;
    private static final int MAXJ = 5;
    private static final int startI = 0;
    private static final int startJ = 0;

    public static Integer[][] array = new Integer[MAXI][MAXJ];

    public static void printArray() {
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                String s = (array[i][j] == null) ? "." : String.valueOf(array[i][j]);
                //String s
                System.out.printf("%4s", s);
            }
            System.out.println();
        }
    }

    public static void start() {
        boolean canWeMove = true;
        int direction = 1; // 1 -вправо-вниз, 2 - влево-вниз
        int counter = 1; // основной счетчик
        int counterUsedCells = 0; // считает сколько элементов переселки подряд
        int i = startI, j = startJ;
        array[i][j] = counter;
        while (canWeMove) {
            printArray();
//            if ((j == MAXJ - 1 && i == 0) || (i == 0 && j == 0) ||
//                    (j == MAXJ - 1 && i == MAXI - 1) || (j == 0 && i == MAXI - 1)) {
//                canWeMove = false;
//            }
            if (counterUsedCells > counter) canWeMove = false;

            switch (direction) {
                // вправо-вниз
                case 1 -> {
                    // можем ли мы двигаться в этом направлении?
                    if (j + 1 < MAXJ && i + 1 < MAXI) {
                        if (array[i + 1][j + 1] == null) {
                            counter++;
                            array[i + 1][j + 1] = counter;
                            counterUsedCells = 0;
                        }
                        else {
                            counterUsedCells++;
                        }
                        i++;
                        j++;
                    } else {
                        if (j == MAXJ - 1 && i == MAXI - 1){
                            canWeMove = false;
                        }
                        if (j == MAXJ - 1) {
                            direction = 2;
                        }
                        if (i == MAXI - 1) {
                            direction = 5;// ударились в нижний край
                        }
                    }
                }

                // влево-вниз
                case 2 -> {
                    if (j - 1 >= 0 && i + 1 < MAXI) {
                        if (array[i + 1][j - 1] == null) {
                            counter++;
                            array[i + 1][j - 1] = counter;
                            counterUsedCells = 0;
                        }
                        else {
                            counterUsedCells++;
                        }
                        i++;
                        j--;
                    } else {
                        if (i == MAXI - 1 && j == 0) canWeMove = false;
                        if (i == MAXI - 1) {
                            direction = 3;// вверх-влево
                        }
                        if (j == 0){
                            direction = 1;
                        }
                    }
                }

                // влево-вверх
                case 3 -> {
                    if (j - 1 >= 0 && i - 1 >= 0) {
                        if (array[i - 1][j - 1] == null) {
                            counter++;
                            array[i - 1][j - 1] = counter;
                            counterUsedCells = 0;
                        }
                        else {
                            counterUsedCells++;
                        }
                        i--;
                        j--;
                    } else {
                        if (i == 0 && j == 0) canWeMove = false;
                        if (i == 0) {
                            direction = 4;// вниз-влево
                        }
                        if (j == 0){
                            direction = 5;
                        }
                    }
                }

                // влево-вниз
                case 4 -> {
                    if (j - 1 >= 0 && i + 1 < MAXI) {
                        if (array[i + 1][j - 1] == null) {
                            counter++;
                            array[i + 1][j - 1] = counter;
                            counterUsedCells = 0;
                        }
                        else {
                            counterUsedCells++;
                        }
                        i++;
                        j--;
                    } else {
                        if (j == 0 && i == MAXI-1) canWeMove = false;
                        if (j == 0) {
                            direction = 1;// вниз-влево
                        }
                        if (i == MAXI-1){
                            direction = 3;
                        }
                    }
                }

                // вправо-вверх
                case 5 -> {
                    if (j + 1 < MAXJ && i - 1 >= 0) {
                        if (array[i - 1][j + 1] == null) {
                            counter++;
                            array[i - 1][j + 1] = counter;
                            counterUsedCells = 0;
                        }
                        else {
                            counterUsedCells++;
                        }

                        i--;
                        j++;
                    } else {
                        if (j == MAXJ - 1 && i == 0) canWeMove = false;
                        if (j == MAXJ - 1) {
                            direction = 3;// вниз-влево
                        }
                        if (i == 0) {
                            direction = 1;
                        }
                    }
                }





            }

        }
    }

    public static void main(String[] args) {
        printArray();
        start();
    }


}
