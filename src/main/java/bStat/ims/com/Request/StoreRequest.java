package bStat.ims.com.Request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by prashant.agarwal on 10/05/17.
 */
public class StoreRequest {

    private long address;

    private String name;

    private String phone_number;

    private String inchargePerson;

    public StoreRequest() {
    }

    public static void main(String[] args) throws JsonProcessingException {
        StoreRequest storeRequest = new StoreRequest(123l, "Store1Name", "9535434455", "Prashant");
        System.out.println(new ObjectMapper().writeValueAsString(storeRequest));
    }

    public StoreRequest(long address, String name, String phone_number, String inchargePerson) {
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
