/**
 * ApplicationStart.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 20-Apr-2023 14:21
 */

package egorov.departmentstream;

import java.util.List;

public class ApplicationStart {
   public static void main(String[] args) {
      List<Department> depList = StuffService.createDepartments();
      StuffService.printStuff(depList);
   }

}
