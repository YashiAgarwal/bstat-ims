package bStat.ims.com.common.models.tables;

import bStat.ims.com.common.enums.TransactionSubType;
import bStat.ims.com.common.enums.RawMaterialTransactionType;
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
@Table(name = "raw_material_transactions")
public class RawMaterialTransactions {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "raw_material_id")
    private String rawMaterialId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "transaction_type")
    @Enumerated(EnumType.STRING)
    private RawMaterialTransactionType rmTransactionType;

    @Column(name = "transaction_sub_type")
    @Enumerated(EnumType.STRING)
    private TransactionSubType rmTransactionSubType;

    @Column(name = "worker_id")
    private String workerId;

    @Column(name = "seller_id")
    private String sellerId;

    @Column(name = "comments")
    private String comments;

    @Column(name = "score")
    private Double score;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "updated_on")
    private Date updatedOn;
}
