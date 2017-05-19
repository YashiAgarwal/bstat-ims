package bStat.ims.com.common.dao;

import bStat.ims.com.common.models.tables.Store;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.hibernate.HibernateBundle;
import org.hibernate.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yashi Agarwal on 08-05-2017.
 */
public class StoresDao extends AbstractDAO<Store> {

    private static final Logger logger = LoggerFactory.getLogger(StoresDao.class);

    @Inject
    public StoresDao(HibernateBundle bundle) {
        super(bundle.getSessionFactory());
    }

    public void save(Store store) {
        currentSession().save(store);
    }

    public List<Store> getAllStores(){
        Criteria cr = currentSession().createCriteria(Store.class);
        return cr.list();
    }

}
