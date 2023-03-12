package egorov;

/**
 * HoeWrok14.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 22-Feb-2023 21:08
 */

//    4.Ну и для особо отличившихся. Написать метод который
//    генерирует двумерный массив длиной N и высотой H
//    Далее заполняет получившийся массив числами от 1 до W по спирали.
//    Например массив
//            [ 0][0 ][0 ][0 ]
//            [ ][ ][ ][ ]
//            [ ][ ][ ][ ]
//    имеет N == 4 and H == 3 и вид
//            [ 1 ][ 2 ][ 3 ][ 4 ]
//            [10] [11] [ 12 ][ 5 ]
//            [ 9 ][ 8 ][ 7 ][ 6 ]




enum Directions{
    LEFT, RIGHT, DOWN, UP
}
public class Snake {
    public static final int N = 10; // столбцы
    public static final int H = 10; // строки

    public static void printArray(int[][] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j] + "   ");
            }
            System.out.println();
        }
    }
    public static void start() {

        int[][] array = new int[H][N];
        Directions currentMove = Directions.RIGHT;
        int i = 0, j = 0, index = 1;
        // i - строка, j - столбец
        while (true) {
            array[i][j] = index;
            //if (index => N * H) isItMoving = false;
            // двигаться дальше вправо ?
            if (index == N * H) break;
            switch (currentMove){
                case RIGHT -> {
                    // если не крайний справа или справа пустой элемент, то двигаемся еще вправо
                    if (j != N-1 && array[i][j+1] == 0){
                        j++;
                    }
                    else {
                        currentMove = Directions.DOWN;
                        i++;
                    }
                }
                case DOWN -> {
                    if (i != H-1 && array[i+1][j] == 0){
                        i++;
                    }
                    else{
                        currentMove = Directions.LEFT;
                        j--;
                    }
                }
                case LEFT -> {
                    if (j > 0 && array[i][j-1] == 0){
                        j--;
                    }
                    else{
                        currentMove = Directions.UP;
                        i--;
                    }
                }
                case UP -> {
                    if (i > 0 && array[i-1][j] == 0){
                        i--;
                    }
                    else{
                        currentMove = Directions.RIGHT;
                        j++;
                    }
                }
            }
            index++;
        }
        printArray(array);
    }
}
