/**
 * CompanyList.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 31-Mar-2023 15:42
 */

package egorov.itcompany;

import java.util.TreeSet;

public class CompanyList<T extends Employee> {
    private TreeSet<T> stuff = new TreeSet<>();

    public boolean add(T employee) {
        stuff.add(employee);
        return true;
    }

    public boolean delete(String name, int age) {
        T toDelete = null;
        for (T employee : stuff) {
            if (employee.getName().equals(name) && employee.getAge() == age) {
                toDelete = employee;
                break;
            }
        }
        if (toDelete == null) {
            return false;
        }
        stuff.remove(toDelete);
        return true;
    }

    public CompanyList<T> searchByName(String name){
        CompanyList<T> result = new CompanyList<>();
        for (T employee : stuff) {
            if (employee.getName().contains(name)){
                result.add(employee);
            }
        }
        return result;
    }

    public void print() {
        stuff.stream().forEach(System.out::println);
    }

}
