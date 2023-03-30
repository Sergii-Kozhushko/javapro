/**
 * BaseballScore.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 30-Mar-2023 11:45
 */

package loshmanov;

import java.util.Stack;

public class BaseballScore {
//   You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.
//   You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:
//
//
//
//   An integer x - Record a new score of x.
//
//'+' - Record a new score that is the sum of the previous two scores.
//
//           'D' - Record a new score that is the double of the previous score.
//
//'C' - Invalidate the previous score, removing it from the record.
//   Return the sum of all the scores on the record after applying all the operations.
//
//
//           Example 1:
//   Input: ops = ["5","2","C","D","+"]
//   Output: 30
//   Explanation:
//           "5" - Add 5 to the record, record is now [5].
//           "2" - Add 2 to the record, record is now [5, 2].
//           "C" - Invalidate and remove the previous score, record is now [5].
//           "D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
//           "+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
//   The total sum is 5 + 10 + 15 = 30.
//
//
//   Example 2:
//   Input: ops = ["1","C"]
//   Output: 0
//   Explanation:
//           "1" - Add 1 to the record, record is now [1].
//           "C" - Invalidate and remove the previous score, record is now [].
//   Since the record is empty, the total sum is 0.

   public static <result> int processScores(String[] scores){
      Stack<Integer> stack = new Stack<>();
      for (int i = 0; i < scores.length; i++) {
         switch (scores[i]){
            case "C" -> stack.pop();
            case "D" -> stack.push(stack.peek()*2);
            case "+" -> {
               Integer temp1 = stack.pop(), temp2 = stack.peek();
               stack.push(temp1);
               stack.push(temp1 + temp2);
            }
            default -> {stack.push(Integer.valueOf(scores[i]));}
         }
      }
      int  result = 0;
      for (Integer n : stack){
         result += n;
      }
      return result;
   }

   public static void main(String[] args) {
      System.out.println(processScores(new String[]{"5", "2", "C", "D", "+"}));
      System.out.println(processScores(new String[]{"1", "C"}));
   }

}
