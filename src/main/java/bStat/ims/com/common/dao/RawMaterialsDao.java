package bStat.ims.com.common.dao;

import bStat.ims.com.common.models.tables.RawMaterials;
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
