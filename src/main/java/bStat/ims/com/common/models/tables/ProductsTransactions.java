package bStat.ims.com.common.models.tables;

import bStat.ims.com.common.enums.ProductTransactionTypes;
import bStat.ims.com.common.enums.TransactionSubType;
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
@Table(name = "product_transactions")
public class ProductsTransactions {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_variation_id")
    private String productVariationId;

    @Column(name = "transaction_type")
    @Enumerated(EnumType.STRING)
    private ProductTransactionTypes productTransactionTypes;

    @Column(name = "transaction_sub_type")
    @Enumerated(EnumType.STRING)
    private TransactionSubType productTransactionSubTypes;

    @Column(name = "worker_id")     //either of worker_id, seller_id, customer_id will be populated here
    private String workerId;

    @Column(name = "seller_id")
    private String sellerId;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unit_price")
    private Double unitPrice;       // null in case of IN_WORKER_PRODUCED

    @Column(name = "score")
    private Double score;

    @Column(name = "comments")
    private String comments;

    @Column(name = "details")       // can have seqnumber/wt/size/other parameter of each item in the lot
    private String details;

    @Column(name = "expiry_date")   // for the products that taken input in current transaction lot
    private Date expiryDate;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "updated_on")
    private Date updatedOn;
}