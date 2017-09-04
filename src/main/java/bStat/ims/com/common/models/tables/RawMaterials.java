package bStat.ims.com.common.models.tables;

import bStat.ims.com.common.enums.UnitOfMeasurement;
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
@Table(name = "raw_materials")
public class RawMaterials {

    @Id
    @Column(name = "raw_material_id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "unit_of_measurement")
    @Enumerated(EnumType.STRING)
    private UnitOfMeasurement unitOfMeasurement;

    @Column(name = "description")
    private String description;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "modified_on")
    private Date modifiedOn;
}
