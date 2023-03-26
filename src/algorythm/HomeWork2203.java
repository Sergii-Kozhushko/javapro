/**
 * HomeWork2203.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 26-Mar-2023 14:00
 */

package algorythm;


import java.util.Arrays;

public class HomeWork2203 {
    public static int powRec2(int x, int n) {
        if (n == 0) return 0;
        if (n == 1) return x;
        if (n % 2 == 0) {
            int y = powRec2(x, n >> 1);
            return y * y;
        }
        return x * powRec2(x, n - 1);
    }

    public static int powRec(int x, int n) {
        if (n == 0) return 0;
        if (n == 1) return x;

        return x * powRec(x, n - 1);
    }

    public static int powIter(int x, int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = result * x;
        }
        return result;
    }

    public static int powGorner(int x, int n) {
        int result = 1;
        while (n > 0) {
            if (n % 2 != 0) {
                result *= x;
            }
            x *= x;
            n /= 2;
        }
        // 10^3
        return result;
    }

    public static int powMath(int x, int n) {
        return (int) Math.pow(x, n);
    }

    // лучший алгоритм Бинарное возведение в степень. Сложность O(logn)
    public static int powBin(int a, int n) {
        int res = 1;
        while (n > 0) {
            // (n & 1)>0 - побитовая, а значит быстрая, проверка числа на печетность
            if ((n & 1) > 0)
                res *= a;
            a *= a;
            n >>= 1; // n = n / 2
        }
        return res;
    }

    // 1. Даны два целых числа x и n, напишите функцию для вычисления x^n
    //   решение 1 - рекурсивно O(n)
//   решение 2 - улучшить решение 1 до O(lon n)
    public static void powAll() {
        int M = 120_000_000;
        int X = 2;
        int N = 30;

        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < M; i++) {
            powIter(X, N);
        }
        System.out.printf("1. Итерация %d^%d=%d: %.0f мс%n",X, N, powIter(X, N),
                (double) (System.currentTimeMillis() - timeStart));

        timeStart = System.currentTimeMillis();
        for (int i = 0; i < M; i++) {
            powRec(X, N);
        }
        System.out.printf("2. Рекурсия, обычная %d^%d=%d: %.0f мс%n",X, N, powRec(X, N),
                (double) (System.currentTimeMillis() - timeStart));


        timeStart = System.currentTimeMillis();
        for (int i = 0; i < M; i++) {
            powRec2(X, N);
        }
        System.out.printf("3. Рекурсия, улучшенная %d^%d=%d: %.0f мс%n",X, N, powRec2(X, N),
                (double) (System.currentTimeMillis() - timeStart));

        timeStart = System.currentTimeMillis();
        for (int i = 0; i < M; i++) {
            powGorner(X, N);
        }
        System.out.printf("4. Алгоритм Горнера %d^%d=%d: %.0f мс%n",X, N, powGorner(X, N),
                (double) (System.currentTimeMillis() - timeStart));

        timeStart = System.currentTimeMillis();
        for (int i = 0; i < M; i++) {
            powMath(X, N);
        }
        System.out.printf("5. Math.pow() %d^%d=%d: %.0f мс%n",X, N, powMath(X, N),
                (double) (System.currentTimeMillis() - timeStart));

        timeStart = System.currentTimeMillis();
        for (int i = 0; i < M; i++) {
            powBin(X, N);
        }
        System.out.printf("6. Бинарный алгоритм %d^%d=%d: %.0f мс%n",X, N, powBin(X, N),
                (double) (System.currentTimeMillis() - timeStart));
    }

    //   2. Имея два отсортированных массива размера m и n соответственно, вам нужно найти элемент,
//   который будет находиться на k-й позиции в конечном отсортированном массиве.
//   Массив 1 - 100 112 256 349 770
//   Массив 2 - 72 86 113 119 265 445 892
//   к = 7
//   Вывод : 256
//   Окончательный отсортированный массив -
    public static int findKElement(int[] array1, int[] array2, int k) {
        int result = 0;
        int i1 = 0, i2 = 0;
        while (k >= 0) {
            if (array1[i1] <= array2[i2]) {
                k--;
                result = array1[i1];
                i1++;
            }
            if (array2[i2] < array1[i1]) {
                k--;
                result = array2[i2];
                i2++;
            }
        }
        return result;
    }

    //  3. Имея отсортированный массив arr[] и число x, напишите функцию,
//   которая подсчитывает вхождения x в arr[]. Ожидаемая временная сложность O(Log n)
//   arr[] = {1, 1, 2, 2, 2, 2, 3,}
//   x = 1
//   Вывод: 2 раза
    // Алгоритм: сначала находим первый элемент, который = x.
    // Делаем это делением массива пополам и сравнением с х, по аналогии с бинарным поиском.
    // Далее считаем все элементы слева и справа от найденного.
    // Делаем это одним циклом для оптимизации
    public static int findCountInArray(int[] array, int x) {

        // находим сначала любой элемент, который равен x. Методом поиска льва в пустыне
        int index = array.length / 2;
        while (array[index] != x) {
            if (array[index] > x) {
                index = index / 2;
            } else {
                index = index + index / 2;
            }
            if (index > array.length - 1) {
                index = array.length - 1;
            }
        }
        // считаем одним циклом сколько таких элементов справа и слева
        int i = index, j = index, counter = 0;
        boolean iterateLeft = true, iterateRight = true;
        while (iterateLeft || iterateRight) {

            if (array[i] == x) {
                if (iterateLeft) {
                    counter++;
                    if (i > 0) {
                        i--;
                    } else {
                        iterateLeft = false;
                    }
                }
            } else {
                iterateLeft = false;
            }

            if (array[j] == x) {
                if (iterateRight) {
                    counter++;
                    if (j < array.length - 1) {
                        j++;
                    } else {
                        iterateRight = false;
                    }
                }
            } else {
                iterateRight = false;
            }
        }
        return counter - 1;
    }

    //4. Найдите пиковый элемент в двумерном массиве
//   Элемент является пиковым, если он больше или равен своим четырем соседям
//   слева, справа, сверху и снизу.
//   Например, соседями для A[i][j] являются A[i-1][j], A[i+1][j], A[i][j-1] и A[i][j+1 ].
//   Для угловых элементов отсутствующие соседи считаются отрицательными бесконечными значениями.
//10 20 15
//        21 30 14
//        7 16 32
//   Выход: 30
//           30 — пиковый элемент, потому что все его
//   соседи меньше или равны ему.
//32 также можно выбрать в качестве пика.
    public static void printPeakElements(int[][] array) {
        for (int[] ints : array){
            System.out.println(Arrays.toString(ints));
        }
        System.out.print("Peak elements: ");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                boolean isPeak = true;
                if (i > 0 && array[i - 1][j] > array[i][j]) {
                    isPeak = false;
                    continue;
                }
                if (j > 0 && array[i][j - 1] > array[i][j]) {
                    isPeak = false;
                    continue;
                }
                if (i < array.length - 1 && array[i + 1][j] > array[i][j]) {
                    isPeak = false;
                    continue;
                }
                if (j < array[i].length - 1 && array[i][j + 1] > array[i][j]) {
                    isPeak = false;
                    continue;
                }
                System.out.printf("%d {%d %d}, ", array[i][j], i, j);
            }

        }

    }


    public static void main(String[] args) {
        // 1. Нахождение степени числа 6-тью алгоритмами с замером времени
        powAll();

        // 2. Найти K-тый элемент при соединении двух остортированных массивов
        System.out.println(findKElement(new int[]{100, 112, 256, 349, 770}, new int[]{72, 86, 113, 119, 265, 445, 892}, 7));

        // 3. Вхождения
        System.out.println(findCountInArray(new int[]{1, 1, 2, 2, 2, 10, 10, 11, 11, 11, 20}, 10));
        // 4. Пиковый элемент
        int[][] array = {{10, 20, 30}, {9, 8, 7}, {30, 20, 40}};
        printPeakElements(array);
    }

}
