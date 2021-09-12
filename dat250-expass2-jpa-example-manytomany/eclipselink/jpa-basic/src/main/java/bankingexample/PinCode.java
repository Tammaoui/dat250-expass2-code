package bankingexample;

import javax.persistence.*;

@Entity
public class PinCode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public int count;

    public int pinCode;

    @Override
    public String toString() {
        return "PinCode{" +
                "id=" + id +
                ", count=" + count +
                ", pinCode='" + pinCode + '\'' +
                '}';
    }
}
