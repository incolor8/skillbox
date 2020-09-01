package clients;

import java.math.BigDecimal;

public abstract class Client {

    protected BigDecimal contribution;
    protected BigDecimal COMMISSION = new BigDecimal(0);

    public Client(BigDecimal contribution) {
        this.contribution = contribution;
    }

    public void getContribution() {
        System.out.println("На вашем счете " + contribution + " рублей.");
    }

    public void putMoney(BigDecimal money) {
        // пополнение
        BigDecimal moneyWithoutCommission = money.subtract(getDepositCommission(money));
        this.contribution = contribution.add(moneyWithoutCommission);
        if (COMMISSION.equals(new BigDecimal(0))) {
            System.out.println("Комиссии нет.");
        } else {
            System.out.println("Комиссия составляет: " + getDepositCommission(money) + " рублей." +
                    " Процентная ставка: " + COMMISSION);
        }
        System.out.println("На счет зачислено " + moneyWithoutCommission + " рублей.");
    }

    public void pullMoney(BigDecimal money) {
        // снятие
        BigDecimal moneyWithoutCommission = money.subtract(getWithdrawalCommission(money));
        if (contribution.compareTo(moneyWithoutCommission) >= 0) {
            this.contribution = contribution.subtract(moneyWithoutCommission);
            if (COMMISSION.equals(new BigDecimal(0))) {
                System.out.println("Комиссии нет.");
            } else {
                System.out.println("Комиссия составляет: " + money.subtract(moneyWithoutCommission) + " рублей." +
                        " Процентная ставка: " + COMMISSION);
            }
            System.out.println("Снятие сведств: " + moneyWithoutCommission + " рублей.");
        } else {
            System.out.println("Недостаточно средств.");
        }
    }

    protected abstract BigDecimal getWithdrawalCommission(BigDecimal amount);
    // снятие

    protected abstract BigDecimal getDepositCommission(BigDecimal amount);
    // пополнение
}
