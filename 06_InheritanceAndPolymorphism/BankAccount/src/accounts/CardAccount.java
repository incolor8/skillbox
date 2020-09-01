package accounts;

public class CardAccount extends PaymentAccount {
    private final double COMMISSION = 0.01;

    public CardAccount(double contribution) {
        super(contribution);
    }

    @Override
    public double pullMoney(double money) {
        System.out.println("Коммисия: " + COMMISSION * money);
        return super.pullMoney(money - money * COMMISSION);
    }
}
