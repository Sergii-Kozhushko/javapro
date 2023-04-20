/**
 * Department.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 20-Apr-2023 14:01
 */

package egorov.departmentstream;

import java.util.ArrayList;
import java.util.List;

public class Department {
   private List<Employee> stuffList = new ArrayList<>();
   private String name;


   public Department(List<Employee> stuffList, String name) {
      this.stuffList = stuffList;
      this.name = name;
   }

   public List<Employee> getStuffList() {
      return stuffList;
   }

   public void setStuffList(List<Employee> stuffList) {
      this.stuffList = stuffList;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}
