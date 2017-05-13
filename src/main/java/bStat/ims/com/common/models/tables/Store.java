package bStat.ims.com.common.models.tables;

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

    @Column(name = "addressId")
    private long addressId;

    @Column(name = "store_name")
    private String storeName;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "incharge_person")
    private String inchargePerson;

    public Store() {
    }

    public Store(long addressId, String storeName, String phone_number, String inchargePerson) {
        this.addressId = addressId;
        this.storeName = storeName;
        this.phone_number = phone_number;
        this.inchargePerson = inchargePerson;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getInchargePerson() {
        return inchargePerson;
    }

    public void setInchargePerson(String inchargePerson) {
        this.inchargePerson = inchargePerson;
    }
}
