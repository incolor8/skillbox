package clients;

import java.math.BigDecimal;

public class IndividualEntrepreneur extends Client { // ИП

    public IndividualEntrepreneur(BigDecimal contribution) {
        super(contribution);
    }

    @Override
    protected BigDecimal getWithdrawalCommission(BigDecimal amount) {
        COMMISSION = new BigDecimal(0);
        amount = amount.multiply(COMMISSION);
        return amount;
    }

    @Override
    protected BigDecimal getDepositCommission(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.valueOf(1000)) < 0) {
            COMMISSION = new BigDecimal("0.01");
        } else {
            COMMISSION = new BigDecimal("0.005");
        }
        amount = amount.multiply(COMMISSION);
        return amount;
    }
}
