package bankingexample;

import javax.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private Long id;

    private String name;

    @OneToOne(cascade=CascadeType.PERSIST )
    @JoinColumn(name="card_id")
    private CreditCard creditCard;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="address_id")
    private Address address;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setCreditCard(CreditCard card) {
        this.creditCard = card;
    }

    public CreditCard getCreditCard() {
        return this.creditCard;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address){
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{"+
                "name='" + name + '\'' +
                ", creditCard=" + creditCard +
                ", address=" + address +
                '}';
    }
}
