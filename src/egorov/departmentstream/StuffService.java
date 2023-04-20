/**
 * StuffService.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 20-Apr-2023 14:04
 */

package egorov.departmentstream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StuffService {
   private static final int DEPARTMENTS_NUMBER = 3;
   public static List<Department> createDepartments(){
      List<Department> result = new ArrayList<>();
      for (int i = 1; i < DEPARTMENTS_NUMBER; i++){
         List<Employee> stuff = new ArrayList<>();
         for (int j = 0 ; j < 5; j++){
            int sex = new Random().nextInt(3);
            String sexString = switch (sex){
               case 1-> "Мужской";
               case 2-> "Женский";
               default -> "Не определился";
            };

            stuff.add(new Employee("Name " + j, new Random().nextInt(70),new Random().nextInt(3000), sexString));
         }
         Department department = new Department(stuff, "Отдел №" + i);
         result.add(department);
      }
      return result;

   }
   //Стримами пройтись по ЛИСТУ ДЕПАРТАМЕНТОВ
   // и вывести на эеран всех сотрудников(имена и фамилии) зп которых больше 2500
   public static void printStuff(List<Department> departments){
      departments.stream()
              .map(x->x.getStuffList())
              .flatMap(x->x.stream())
              .filter(x->x.getSalary()>2500)
              .forEach(System.out::println);


   }

}
