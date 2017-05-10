package bStat.ims.com.common.dao;

import bStat.ims.com.common.models.tables.RawMaterialsInventory;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.hibernate.HibernateBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Yashi Agarwal on 08-05-2017.
 */
public class RawMaterialsInventoryDao extends AbstractDAO<RawMaterialsInventory> {

    private static final Logger logger = LoggerFactory.getLogger(RawMaterialsInventoryDao.class);

    @Inject
    public RawMaterialsInventoryDao(HibernateBundle bundle) {
        super(bundle.getSessionFactory());
    }

    public void save(RawMaterialsInventory rawMaterialsInventory) {
        currentSession().save(rawMaterialsInventory);
    }


}
