/**
 * Braces.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 08-May-2023 21:32
 */

package loshmanov;

/*
2. Given a string containing just the characters '(' and ')',
return the length of the longest valid (well-formed) parentheses substring.

        Example 1:
        Input: s = "(()"
        Output: 2
        Explanation: The longest valid parentheses substring is "()".


        Example 2:
        Input: s = ")()())"
        Output: 4
        Explanation: The longest valid parentheses substring is "()()".


        Example 3:
        Input: s = ""
        Output: 0
*/


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Braces {
    public static int braces(String str) {
        Pattern pattern = Pattern.compile("\\(\\)");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()){
            return braces(str.replaceFirst("\\(\\)", "")) + 2;
        }
        else{
                return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(braces("((()(()())"));
    }
}
