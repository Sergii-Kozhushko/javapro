/**
 * MaillIst.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 27-Apr-2023 21:04
 */

package loshmanov.library;

import java.util.ArrayList;
import java.util.List;

public class MailLIst {
   private List<String> emailList = new ArrayList<>();
   private String message;

   public MailLIst(List<String> emailList, String message) {
      this.emailList = emailList;
      this.message = message;
   }
}
