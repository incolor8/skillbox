import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
        public static void main(String[] args) {
            List<Employee> employeeList = new ArrayList<>();
            Company company = new Company(new BigDecimal(1500000), employeeList);
            System.out.println(company.getIncome());
            company.hireAll(employeeList);
            System.out.println(employeeList);
            Employee top = new TopManager(50);
            company.hire(top);
            company.fire(top);
            company.fireAll(50);
            System.out.println(employeeList);
            company.getLowestSalaryStaff(30);
            company.getTopSalaryStaff(15);
        }
    }
