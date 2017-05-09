package bStat.ims.com.common.dao;

import bStat.ims.com.common.models.tables.RawMaterialsInventory;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.hibernate.HibernateBundle;

/**
 * Created by Yashi Agarwal on 08-05-2017.
 */
public class RawMaterialsInventoryDao extends AbstractDAO<RawMaterialsInventory> {

    @Inject
    public RawMaterialsInventoryDao(HibernateBundle bundle) {
        super(bundle.getSessionFactory());
    }

    public void save(RawMaterialsInventory rawMaterialsInventory) {
        currentSession().save(rawMaterialsInventory);
    }


}
