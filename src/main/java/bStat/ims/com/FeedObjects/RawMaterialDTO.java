package bStat.ims.com.FeedObjects;

import bStat.ims.com.common.enums.UnitOfMeasurement;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

/**
 * Created by prashant.agarwal on 21/05/17.
 */
public class RawMaterialDTO {

    @NotNull
    private String name;

    @NotNull
    private UnitOfMeasurement unitOfMeasurement;

    private String description;

    public RawMaterialDTO() {
    }

    public RawMaterialDTO(String name, UnitOfMeasurement unitOfMeasurement, String description) {
        this.name = name;
        this.unitOfMeasurement = unitOfMeasurement;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UnitOfMeasurement getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(UnitOfMeasurement unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
