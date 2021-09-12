package bankingexample;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Person extends Address {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private Long id;

    private String name;

    @ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
    @JoinColumn(name="card_id")
    private Set<CreditCard> creditCards = new HashSet<>();

    @ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
    @JoinColumn(name="address_id")
    private Set<Address> addresses = new HashSet<>();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void addCreditCard(CreditCard card) {
        this.creditCards.add(card);
    }

    public Set<CreditCard> getCreditCards() {
        return this.creditCards;
    }

    public Set<Address> getAddresses() {
        return this.addresses;
    }

    public void addAddress(Address address){
        this.addresses.add(address);
    }



    @Override
    public String toString() {
        return "Person{"+
                "name='" + name + '\'' +
                ", creditCards=" + creditCards.toString() +
                ", addresses=" + addresses.toString() +
                '}';
    }
}
