package accounts;

import java.time.LocalDate;

public class DepositoryAccount extends PaymentAccount {
    private LocalDate datePut; // дата последнего внесения на счет

    public DepositoryAccount(double contribution) {
        super(contribution);
    }

    @Override
    public double putMoney(double money) {
        this.datePut = LocalDate.now();
        return super.putMoney(money);
    }

    @Override
    public double pullMoney(double money) {
        if (datePut.isBefore(LocalDate.now().minusMonths(1))) {
            return super.pullMoney(money);
        } else {
            System.out.println("Нельзя снимать деньги в течение месяца после последнего внесения!");
        }
        return contribution;
    }
}
