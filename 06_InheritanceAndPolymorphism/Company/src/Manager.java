import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

public class Manager implements Employee
{
    public final BigDecimal FIX_SALARY = new BigDecimal(25000);
    private int id;
    private String name;
    private int randomIncome = ThreadLocalRandom.current().nextInt(115000, 140001);
    private BigDecimal salary;
    private Company company;

    public Manager(int id) {
        this.id = id;
        name = "Manager" + id;
        this.salary = new BigDecimal(randomIncome).multiply(new BigDecimal("0.05")).add(FIX_SALARY);
    }

    @Override
    public BigDecimal getMonthSalary() {
        return salary;
    }

    @Override
    public void setCompany(Company company) {
    }

    @Override
    public Company getCompany() {
        return company;
    }

    @Override
    public void setMonthSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String setId(int id) {
        this.id = id;
        return name;
    }

    @Override
    public String toString() {
        return name + " - Зарплата=" + getMonthSalary();
    }

}

