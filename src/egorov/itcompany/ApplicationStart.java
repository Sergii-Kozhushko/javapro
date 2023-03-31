/**
 * ApplicationStart.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 31-Mar-2023 15:53
 */

package egorov.itcompany;

public class ApplicationStart {
   public static void main(String[] args) {
      CompanyList<Employee> companyList = new CompanyList<>();
      Manager manager = new Manager("Bart Johnson", 33, 3000);
      companyList.add(manager);
      companyList.add(new Manager("Bart Simpson", 33, 5000));

      companyList.add(new Junior("Aaron Baker", 23, 1000));
      companyList.add(new TeamLead("Ben Johnson", 45, 10_000));

      // этот не добавится как дубль по имени+возрасту
      companyList.add(new CEO("Ben Johnson", 45, 10_000));

      // этот добавится тк совпадает имя, но не совпадает возраст
      companyList.add(new CEO("Ben Johnson", 46, 10_000));

      companyList.add(new CEO("Donald Trump", 65, 15_000));
      companyList.add(new Middle("Shon Penn", 35, 12_000));
      companyList.add(new Senior("Martha Gregory", 25, 8_000));

      companyList.add(new Junior("Rick Sanches", 50, 2_000));
      companyList.print();
      companyList.delete("Rick Sanches", 50);
      System.out.println();
      System.out.println("Список после удаления сотрудника Rick Sanches, 50 лет");
      companyList.print();
      System.out.println();
      System.out.println("Поиск по имени 'Ben'");
      companyList.searchByName("Ben").print();

   }

}
