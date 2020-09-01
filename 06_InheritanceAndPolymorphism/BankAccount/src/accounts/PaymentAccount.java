package accounts;

public class PaymentAccount {
    protected double contribution;  // сумма на расчетном счете

    public PaymentAccount(double contribution) {
        this.contribution = contribution;
    }

    public void getContribution() {
        System.out.println("На вашем счете " + contribution + " рублей.");
    }

    public double putMoney (double money) {
        this.contribution = contribution + money;
        System.out.println("На счет зачислено " + money + " рублей.");
        return contribution;
    }

    public double pullMoney (double money) {
        if (contribution > money) {
            this.contribution = contribution - money;
            System.out.println("Снятие сведств: " + money + " рублей.");
        } else {
            System.out.println("Недостаточно средств.");
        }
        return contribution;
    }
}
