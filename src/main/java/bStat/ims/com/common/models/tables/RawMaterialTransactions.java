package bStat.ims.com.common.models.tables;

import bStat.ims.com.common.enums.RawMaterialTransactionType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Yashi Agarwal on 02-05-2017.
 */

@Entity
@Table(name = "raw_material_transactions")
public class RawMaterialTransactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "raw_material_id")
    private long id;

    @Column(name = "comments")
    private String comments;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "transaction_type")
    @Enumerated(EnumType.STRING)
    private RawMaterialTransactionType rawMaterialTransactionType;

    @Column(name = "worker_id")
    private long workerId;

    @Column(name = "seller_id")
    private long sellerId;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "updated_on")
    private Date updatedOn;

    public RawMaterialTransactions() {
    }

    public RawMaterialTransactions(Long id, String comments, int quantity, RawMaterialTransactionType rawMaterialTransactionType,
                                   Long workerId, Long sellerId, Date createdOn, Date updatedOn) {
        this.id = id;
        this.comments = comments;
        this.quantity = quantity;
        this.rawMaterialTransactionType = rawMaterialTransactionType;
        this.workerId = workerId;
        this.sellerId = sellerId;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public RawMaterialTransactionType getRawMaterialTransactionType() {
        return rawMaterialTransactionType;
    }

    public void setRawMaterialTransactionType(RawMaterialTransactionType rawMaterialTransactionType) {
        this.rawMaterialTransactionType = rawMaterialTransactionType;
    }

    public long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(long workerId) {
        this.workerId = workerId;
    }

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }
}
