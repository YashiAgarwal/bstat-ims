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
@Table(name = "stock_in_store")
public class StockInStore {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "store_id")
    private String storeId;

    @Column(name = "product_id")        //can be raw material/product
    private String productId;

    @Column(name = "product_variation_id")
    private String productVariationId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "modified_on")
    private Date modifiedOn;
}
