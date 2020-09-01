import java.math.BigDecimal;

public class TopManager implements Employee {
    public final BigDecimal FIX_SALARY = new BigDecimal(80000);
    private final BigDecimal bonus = new BigDecimal("0.5");
    private int id;
    private String name;
    private final BigDecimal overIncome = new BigDecimal(10000000);
    private BigDecimal salary;
    private Company company;

    public TopManager(int id) {
        this.id = id;
        this.name = "TopManager" + id;
        this.salary = FIX_SALARY;
    }

    @Override
    public BigDecimal getMonthSalary() {
        if (getCompany() != null && getCompany().getIncome().compareTo(overIncome) > 0) {
            salary = FIX_SALARY.add(FIX_SALARY.multiply(bonus));
        } else if(getCompany() == null) {
            salary = new BigDecimal("0");
        }
        return salary;
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
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
