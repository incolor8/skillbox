import clients.Client;
import clients.IndividualEntrepreneur;
import clients.LegalEntity;
import clients.PhysicalPerson;

import java.math.BigDecimal;

public class BankAccount {
    public static void main(String[] args) {

        System.out.println("\n========clients.IndividualEntrepreneur========");
        Client ip = new IndividualEntrepreneur(BigDecimal.valueOf(0));
        ip.putMoney(BigDecimal.valueOf(5000));
        ip.pullMoney(BigDecimal.valueOf(500));
        ip.getContribution();

        System.out.println("\n========clients.LegalEntity========");
        Client entity = new LegalEntity(BigDecimal.valueOf(10000));
        entity.pullMoney(BigDecimal.valueOf(5000));
        entity.putMoney(BigDecimal.valueOf(1000));
        entity.getContribution();

        System.out.println("\n========clients.PhysicalPerson========");
        Client pPerson = new PhysicalPerson(BigDecimal.valueOf(1000));
        pPerson.pullMoney(BigDecimal.valueOf(5000));
        pPerson.putMoney(BigDecimal.valueOf(5000));
        pPerson.pullMoney(BigDecimal.valueOf(5000));
        pPerson.getContribution();
    }
}
