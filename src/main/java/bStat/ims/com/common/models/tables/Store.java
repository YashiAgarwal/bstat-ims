package bStat.ims.com.common.models.tables;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Yashi Agarwal on 02-05-2017.
 */

@Entity
@Data
@NoArgsConstructor
@Table(name = "stores")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "addressId")
    private String addressId;

    @Column(name = "store_name")
    private String storeName;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "incharge_person")
    private String inchargePerson;

    @Column(name = "active")
    private boolean active;
}
