package bStat.com.common.dao;

import bStat.com.common.models.tables.ProductsTransactions;
import bStat.com.common.models.tables.RawMaterials;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.hibernate.HibernateBundle;

/**
 * Created by Yashi Agarwal on 08-05-2017.
 */
public class RawMaterialsDao extends AbstractDAO<RawMaterials> {

    @Inject
    public RawMaterialsDao(HibernateBundle bundle) {
        super(bundle.getSessionFactory());
    }

    public void save(RawMaterials rawMaterials) {
        currentSession().save(rawMaterials);
    }


}
