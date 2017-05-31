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
    private int unitsInStock;

    @Column(name = "units_in_production")
    private int unitsInProduction;


    public RawMaterialsInventory() {
    }

    public RawMaterialsInventory(Long id, Long rawMaterialsId, int unitsInStock, int unitsInProduction) {
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

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public int getUnitsInProduction() {
        return unitsInProduction;
    }

    public void setUnitsInProduction(int unitsInProduction) {
        this.unitsInProduction = unitsInProduction;
    }
}
