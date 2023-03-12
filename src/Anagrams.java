import java.util.Arrays;
import java.util.Scanner;

/**
 * Anagrams.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 03-Mar-2023 12:50
 */

public class Anagrams {




        static boolean isAnagram(String a, String b) {
            // Complete the function

            char[] aList = a.toLowerCase().toCharArray();
            Arrays.sort(aList);
            System.out.println(Arrays.toString(aList));

//            String bLower = b.toLowerCase();
//            for (int i = 0; i < aLower.length(); i++){
//                if (bLower.indexOf(aLower.charAt(i)) == -1)
//                    return false;
//            }
            return true;
        }

        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            String a = scan.next();
            String b = scan.next();
            scan.close();
            boolean ret = isAnagram(a, b);
            System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
        }
    }


