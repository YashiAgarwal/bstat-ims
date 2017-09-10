package bStat.ims.com.common.models.tables;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Yashi Agarwal on 02-05-2017.
 */

@Entity
@Data
@NoArgsConstructor
@Table(name = "products_inventory")
public class ProductsInventory {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_variation_id")
    private String productVariationId;

    @Column(name = "units_in_stock")
    private int unitsInStock;

    @Column(name = "units_booked")
    private int unitsBooked;

    @Column(name = "net_stock")
    private int netStock;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "modified_on")
    private Date modifiedOn;
}
