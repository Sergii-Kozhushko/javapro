/**
 * Employee.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 20-Apr-2023 13:56
 */

package egorov.departmentstream;

public class Employee {
   private String name;
   private int age;
   private int salary;

   private String sex; // 1 - male, 2 female, 3 other

   public Employee(String name, int age, int salary, String sex) {
      this.name = name;
      this.age = age;
      this.salary = salary;
      this.sex = sex;
   }

   public String getSex() {
      return sex;
   }

   public void setSex(String sex) {
      this.sex = sex;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public int getSalary() {
      return salary;
   }

   public void setSalary(int salary) {
      this.salary = salary;
   }

   @Override
   public String toString() {
      return "Employee{" +
              "name='" + name + '\'' +
              ", age=" + age +
              ", salary=" + salary +
              ", sex='" + sex + '\'' +
              '}';
   }
}
