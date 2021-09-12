package bankingexample;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Main {

    private static final String PERSISTENCE_UNIT_NAME = "bankExample";
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);


    public static void displayPersons(EntityManager em) {
        Query getAllPersons = em.createQuery("select p from Person p");
        List<Person> allPersons = getAllPersons.getResultList();
        for (Person p: allPersons) {
            System.out.println(p);
        }
    }


    public static void main(String[] args) {
        // Create factory
        EntityManager em = factory.createEntityManager();

        displayPersons(em);

        em.getTransaction().begin();
        Person person = new Person();
        person.setName("Ayoub Tammaoui");
        em.persist(person);
        em.getTransaction().commit();

        em.getTransaction().begin();
        Address address = new Address();
        address.addPerson(person);
        address.setStreet("Vågsallmenningen");
        em.persist(address);
        em.getTransaction().commit();


        em.getTransaction().begin();
        PinCode pinCode = new PinCode();
        pinCode.count = 10;
        em.persist(pinCode);
        em.getTransaction().commit();


        em.getTransaction().begin();
        Bank bank = new Bank();
        bank.Name = "DNB";
        em.persist(bank);
        em.getTransaction().commit();

        em.getTransaction().begin();
        CreditCard card = new CreditCard();
        card.setBalance(5000);
        card.setLimit(10000);
        card.setNumber(1231);
        card.bank = bank;
        card.pinCode = pinCode;
        em.persist(card);
        em.getTransaction().commit();

        em.getTransaction().begin();
        person.addAddress(address);
        person.addCreditCard(card);
        em.persist(person);
        em.getTransaction().commit();

    }
}
