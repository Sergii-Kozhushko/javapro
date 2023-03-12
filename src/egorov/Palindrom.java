package egorov;

/**
 * Polindrom.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 23-Feb-2023 13:51
 */

public class Palindrom {
    public static void main(String[] args) {
        String arrayNum;
        int num = 123320;
        arrayNum = String.valueOf(num);
        boolean isPalindrom = true;
        for (int i = 0; i < arrayNum.length() / 2 ; i++) {
            if (arrayNum.charAt(i) != arrayNum.charAt(arrayNum.length()-(i+1))){
                isPalindrom = false;
                break;
            }
        }
        System.out.println(isPalindrom);
    }
}
