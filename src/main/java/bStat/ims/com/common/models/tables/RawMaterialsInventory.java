package bStat.ims.com.common.models.tables;

import javax.persistence.*;

/**
 * Created by Yashi Agarwal on 02-05-2017.
 */

@Entity
@Table(name = "raw_materials_inventory")
public class RawMaterialsInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "raw_materials_id")
    private long rawMaterialsId;

    @Column(name = "units_in_stock")
    private String unitsInStock;

    @Column(name = "units_in_production")
    private String unitsInProduction;


    public RawMaterialsInventory() {
    }

    public RawMaterialsInventory(Long id, Long rawMaterialsId, String unitsInStock, String unitsInProduction) {
        this.id = id;
        this.rawMaterialsId = rawMaterialsId;
        this.unitsInStock = unitsInStock;
        this.unitsInProduction = unitsInProduction;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRawMaterialsId() {
        return rawMaterialsId;
    }

    public void setRawMaterialsId(long rawMaterialsId) {
        this.rawMaterialsId = rawMaterialsId;
    }

    public String getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(String unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public String getUnitsInProduction() {
        return unitsInProduction;
    }

    public void setUnitsInProduction(String unitsInProduction) {
        this.unitsInProduction = unitsInProduction;
    }
}
