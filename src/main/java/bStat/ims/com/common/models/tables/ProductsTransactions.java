package bStat.ims.com.common.models.tables;

import bStat.ims.com.common.enums.ProductTransactionTypes;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Yashi Agarwal on 02-05-2017.
 */

@Entity
@Table(name = "product_transactions")
public class ProductsTransactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "product_id")
    private long productId;

    @Column(name = "transaction_type")
    @Enumerated(EnumType.STRING)
    private ProductTransactionTypes productTransactionTypes;

    @Column(name = "worker_id")
    private long workerId;

    @Column(name = "seller_id")
    private long sellerId;

    @Column(name = "customer_id")
    private long customerId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "lot_score")
    private int lotScore;

    @Column(name = "comments")
    private String comments;

    @Column(name = "details")
    private String details;

    @Column(name = "expiry_date")   // for the products that taken input in current transaction lot
    private Date expiryDate;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "updated_on")
    private Date updatedOn;

    public ProductsTransactions(ProductTransactionTypes productTransactionTypes) {
        this.productTransactionTypes = productTransactionTypes;
    }

    public ProductsTransactions(Long id, Long productId, ProductTransactionTypes productTransactionTypes, Long workerId,
                                Long sellerId, Long customerId, int quantity, int lotScore, String comments, String details,
                                Date createdOn, Date expiryDate, Date updatedOn) {
        this.id = id;
        this.productId = productId;
        this.productTransactionTypes = productTransactionTypes;
        this.workerId = workerId;
        this.sellerId = sellerId;
        this.customerId = customerId;
        this.quantity = quantity;
        this.lotScore = lotScore;
        this.comments = comments;
        this.details = details;
        this.createdOn = createdOn;
        this.expiryDate = expiryDate;
        this.updatedOn = updatedOn;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        productId = productId;
    }

    public ProductTransactionTypes getProductTransactionTypes() {
        return productTransactionTypes;
    }

    public void setProductTransactionTypes(ProductTransactionTypes productTransactionTypes) {
        this.productTransactionTypes = productTransactionTypes;
    }

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        workerId = workerId;
    }

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getLotScore() {
        return lotScore;
    }

    public void setLotScore(int lotScore) {
        this.lotScore = lotScore;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }
}