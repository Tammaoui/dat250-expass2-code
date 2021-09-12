package bankingexample;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String street;

    @ManyToMany
    public Set<Person> persons = new HashSet<Person>();

    public Address() {

    }
    public void setStreet(String street) {
        this.street = street;
    }

    public void addPerson(Person p) {
        persons.add(p);
    }


    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                '}';
    }
}
