package bStat.com.common.models.tables;

import javax.persistence.*;

/**
 * Created by Yashi Agarwal on 02-05-2017.
 */

@Entity
@Table(name = "stores")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "address")
    private long address;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private int phone_number;

    @Column(name = "incharge_person")
    private String inchargePerson;

    public Store() {
    }

    public Store(Long id, long address, String name, int phone_number, String inchargePerson) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.phone_number = phone_number;
        this.inchargePerson = inchargePerson;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAddress() {
        return address;
    }

    public void setAddress(long address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public String getInchargePerson() {
        return inchargePerson;
    }

    public void setInchargePerson(String inchargePerson) {
        this.inchargePerson = inchargePerson;
    }
}
