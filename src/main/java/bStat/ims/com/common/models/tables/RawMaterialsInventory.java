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
@Table(name = "raw_materials_inventory")
public class RawMaterialsInventory {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "raw_materials_id")
    private String rawMaterialsId;

    @Column(name = "units_in_stock")
    private int unitsInStock;

    @Column(name = "units_in_production")
    private int unitsInProduction;
}
