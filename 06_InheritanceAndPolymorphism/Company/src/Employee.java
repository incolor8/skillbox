import java.math.BigDecimal;

interface Employee {

    BigDecimal getMonthSalary();

    void setCompany(Company company);

    Company getCompany();

    void setMonthSalary(BigDecimal salary);

    int getId();

    String setId(int id);
}
