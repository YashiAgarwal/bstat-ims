package bStat.ims.com.FeedObjects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.validation.constraints.NotNull;

/**
 * Created by prashant.agarwal on 10/05/17.
 */
public class StoreDTO {

    private long addressId;

    @NotNull
    private String storeName;

    private String phone_number;

    private String inchargePerson;

    public StoreDTO() {
    }

    public static void main(String[] args) throws JsonProcessingException {
        StoreDTO storeDTO = new StoreDTO(123l, "Store1Name", "9535434455", "Prashant");
        System.out.println(new ObjectMapper().writeValueAsString(storeDTO));
    }

    public StoreDTO(long addressId, String storeName, String phone_number, String inchargePerson) {
        this.addressId = addressId;
        this.storeName = storeName;
        this.phone_number = phone_number;
        this.inchargePerson = inchargePerson;
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
