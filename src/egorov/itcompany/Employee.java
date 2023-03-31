/**
 * Employee.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 31-Mar-2023 15:33
 */

package egorov.itcompany;

public abstract class Employee implements Comparable<Employee> {
    private String name;
    private int age;
    private int salary;

    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }



    @Override
    public int compareTo(Employee o) {
        if (this.name.equals(o.name)) {
            return this.age - o.age;
        } else {
            return this.name.compareTo(o.name);
        }
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
        String position = "";
        if (this.getClass() == Manager.class) {
            position = "Manager";
        }
        if (this.getClass() == Junior.class) {
            position = "Junior";
        }
        if (this.getClass() == TeamLead.class) {
            position = "TeamLead";
        }
        if (this.getClass() == Middle.class) {
            position = "Middle";
        }
        if (this.getClass() == Senior.class) {
            position = "Senior";
        }
        if (this.getClass() == CEO.class) {
            position = "CEO";
        }
        return this.name + ", " + this.age + ", " + position;
    }

}
