package clients;

import java.math.BigDecimal;

public class PhysicalPerson extends Client { // физ. лицо

    public PhysicalPerson(BigDecimal contribution) {
        super(contribution);
    }

    @Override
    protected BigDecimal getWithdrawalCommission(BigDecimal amount) {
        amount = amount.multiply(COMMISSION);
        return amount;
    }

    @Override
    protected BigDecimal getDepositCommission(BigDecimal amount) {
        amount = amount.multiply(COMMISSION);
        return amount;
    }

}
