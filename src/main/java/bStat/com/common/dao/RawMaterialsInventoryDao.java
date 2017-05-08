package bStat.com.common.dao;

import bStat.com.common.models.tables.ProductsTransactions;
import bStat.com.common.models.tables.RawMaterialsInventory;
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
