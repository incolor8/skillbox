import java.math.BigDecimal;

public class Operator implements Employee
{
    private int id;
    private String name;
    private BigDecimal salary;
    private Company company;

    public Operator(int id) {
        this.id = id;
        name = "Operator" + id;
        BigDecimal OP_SALARY = new BigDecimal(15800);
        BigDecimal FIX_SALARY = new BigDecimal(12200);
        this.salary = FIX_SALARY.add(OP_SALARY);
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

