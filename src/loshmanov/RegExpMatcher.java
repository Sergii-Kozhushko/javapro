/**
 * RegExpMatcher.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 04-May-2023 23:06
 */

package loshmanov;

/* Регулярные выражения

Example 1:
        Input: s = "aa", p = "a"
        Output: false
        Explanation: "a" does not match the entire string "aa".


        Example 2:
        Input: s = "aaс", p = "a*"
        Output: true
        Explanation: '*' means zero or more of the preceding element, 'a'.
        Therefore, by repeating 'a' once, it becomes "aa".


        Example 3:
        Input: s = "ab", p = ". "
        Output: true
        Explanation: "*" means "zero or more (*) of any character (.)".*/

public class RegExpMatcher {
    public static boolean matchDynamic(String str, String pattern) {
        int n = pattern.length() + 1;
        int m = str.length() + 1;
        boolean[][] array = new boolean[m][n]; //матрица значений строка-паттерн
        // инициализация 0-го ряда и строки
        array[0][0] = true;
        for (int j = 1; j < n; j++) {
            array[0][j] = false;
        }
        for (int i = 1; i < m; i++) {
            array[i][0] = false;
        }
        // анализ основного куска матрицы
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                char pChar = pattern.charAt(j - 1);
                char sChar = str.charAt(i - 1);
                if (pChar != '*' && pChar != '.') {
                    if (pChar == sChar) {
                        array[i][j] = array[i - 1][j - 1];
                    } else {
                        array[i][j] = false;
                    }
                } else {
                    if (pChar == '*') {
                        array[i][j] = array[i][j - 2] || array[i][j - 1] || array[i - 1][j];
                    }
                    if (pChar == '.') {
                        if (j > i) {
                            array[i][j] = false;
                        } else {
                            array[i][j] = array[i - 1][j - 1];
                        }
                    }
                }
            }
        }
        return array[m - 1][n - 1];
    }


    public static void main(String[] args) {
        System.out.println(matchDynamic("aba", "a*."));

    }

}
