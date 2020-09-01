package clients;

import java.math.BigDecimal;

public class LegalEntity extends Client { // Юр.лицо

    public LegalEntity(BigDecimal contribution) {
        super(contribution);
    }

    @Override
    protected BigDecimal getWithdrawalCommission(BigDecimal amount) {
        COMMISSION = new BigDecimal("0.01");
        amount = amount.multiply(COMMISSION);
        return amount;
    }

    @Override
    protected BigDecimal getDepositCommission(BigDecimal amount) {
        COMMISSION = new BigDecimal(0);
        amount = amount.multiply(COMMISSION);
        return amount;
    }
}
