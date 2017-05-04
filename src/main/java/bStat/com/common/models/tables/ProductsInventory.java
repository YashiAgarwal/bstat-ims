package bStat.com.common.models.tables;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Yashi Agarwal on 02-05-2017.
 */

@Entity
@Table(name = "products_inventory")
public class ProductsInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "units_in_stock")
    private Integer unitsInStock;

    @Column(name = "units_booked")
    private Integer unitsBooked;

    @Column(name = "net_stock")
    private Integer netStock;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "modified_on")
    private Date modifiedOn;

    public ProductsInventory() {
    }

    public ProductsInventory(Long id, String productId, Integer unitsInStock, Integer unitsBooked,
                             Integer netStock, Date createdOn, Date modifiedOn) {
        this.id = id;
        this.productId = productId;
        this.unitsInStock = unitsInStock;
        this.unitsBooked = unitsBooked;
        this.netStock = netStock;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(Integer unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public Integer getUnitsBooked() {
        return unitsBooked;
    }

    public void setUnitsBooked(Integer unitsBooked) {
        this.unitsBooked = unitsBooked;
    }

    public Integer getNetStock() {
        return netStock;
    }

    public void setNetStock(Integer netStock) {
        this.netStock = netStock;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
}
