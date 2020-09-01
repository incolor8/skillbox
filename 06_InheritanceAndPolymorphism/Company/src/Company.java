import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Company {
    private BigDecimal income;
    public List<Employee> employeeList;

    public Company(BigDecimal income, List<Employee> employeeList) {
        this.income = income;
        this.employeeList = employeeList;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        employeeList.sort((o1, o2) -> o2.getMonthSalary().compareTo(o1.getMonthSalary()));
        System.out.println("Список из 15 самых высоких зарплат в компании");
        if (count <= employeeList.size()) {
            List<Employee> topList = employeeList.subList(0, count);
            topList.forEach(e -> System.out.println("• " + e.getMonthSalary() + " руб."));
            return topList;
        }
        return  employeeList;
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        employeeList.sort(Comparator.comparing(Employee::getMonthSalary));
        System.out.println("Список из 30 самых низких зарплат в компании");
        if (count <= employeeList.size()) {
            List<Employee> lowestList = employeeList.subList(0, count);
            lowestList.forEach(e -> System.out.println("• " + e.getMonthSalary() + " руб."));
            return lowestList;
        }
        return  employeeList;
    }

    public void hire(Employee employee) {
        employee.setCompany(this);
        employeeList.add(employee);
    }

    public void hireAll(List<Employee> list) {
        int count = 270;
        for (int i = 1; i <= count; i++) {
            int randNumber = ThreadLocalRandom.current().nextInt(1000, 9999);
            Employee operator = new Operator(randNumber);
            if (i < 10) {
                int randNumTop = ThreadLocalRandom.current().nextInt(100, 999);
                Employee topManager = new TopManager(randNumTop);
                hire(topManager);
            } else if (i < 80) {
                int randNumMan = ThreadLocalRandom.current().nextInt(1000, 9999);
                Employee manager = new Manager(randNumMan);
                hire(manager);
            } else {
                hire(operator);
            }
        }
    }

    public void fire(Employee employee) {
        employee.setCompany(null);
        employeeList.remove(employee);
    }

    public void fireAll(int percent) {
        int count = employeeList.size() * percent / 100;
        int x;
        for (x = 0; x < count; x++) {
            int index = (int)  (Math.random() * count);
            employeeList.remove(index);
        }
        if (x == count) {
            System.out.println("Уволено " + count + " сотрудников!");
        }
    }
}