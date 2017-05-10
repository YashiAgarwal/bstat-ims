package bStat.ims.com.common.dao;

import bStat.ims.com.common.models.tables.RawMaterials;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.hibernate.HibernateBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Yashi Agarwal on 08-05-2017.
 */
public class RawMaterialsDao extends AbstractDAO<RawMaterials> {

    private static final Logger logger = LoggerFactory.getLogger(RawMaterialsDao.class);

    @Inject
    public RawMaterialsDao(HibernateBundle bundle) {
        super(bundle.getSessionFactory());
    }

    public void save(RawMaterials rawMaterials) {
        currentSession().save(rawMaterials);
    }


}
