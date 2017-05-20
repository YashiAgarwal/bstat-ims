package bStat.ims.com.FeedObjects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by prashant.agarwal on 13/05/17.
 */

public class AddressDTO {

    @NotNull
    private String addressLine1;

    private String addressLine2;

    @NotNull
    private String state;

    @NotNull
    private String city;

    @NotNull
    private String country;

    @NotNull
    private String pincode;

    private String landmark;


    public AddressDTO() {
    }

    public AddressDTO(String addressLine1, String addressLine2, String state, String city, String country,
                      String pincode, String landmark) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.state = state;
        this.city = city;
        this.country = country;
        this.pincode = pincode;
        this.landmark = landmark;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }
}
