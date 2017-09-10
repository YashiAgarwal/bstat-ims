package bStat.ims.com.common.models.tables;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by prashant.agarwal on 10/05/17.
 */

@Entity
@Data
@NoArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    @Column(name = "id")
    private String id;

    @JsonProperty("address_line1")
    private String addressLine1;

    @JsonProperty("address_line2")
    private String addressLine2;

    @JsonProperty("state")
    private String state;

    @JsonProperty("city")
    private String city;

    @JsonProperty("country")
    private String country;

    @JsonProperty("pincode")
    private String pincode;

    @JsonProperty("landmark")
    private String landmark;

    @JsonProperty("creation_date")
    private Date creationDate;

    @JsonProperty("last_modified")
    private Date lastModified;
}
