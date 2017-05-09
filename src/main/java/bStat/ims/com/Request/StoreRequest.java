package bStat.ims.com.Request;

import javax.persistence.Column;

/**
 * Created by prashant.agarwal on 10/05/17.
 */
public class StoreRequest {

    private long address;

    private String name;

    private int phone_number;

    private String inchargePerson;

    public StoreRequest() {
    }

    public StoreRequest(long address, String name, int phone_number, String inchargePerson) {
        this.address = address;
        this.name = name;
        this.phone_number = phone_number;
        this.inchargePerson = inchargePerson;
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
