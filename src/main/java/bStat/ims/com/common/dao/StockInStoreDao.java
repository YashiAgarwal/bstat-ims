package bStat.ims.com.common.dao;

import bStat.ims.com.common.models.tables.StockInStore;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.hibernate.HibernateBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Yashi Agarwal on 08-05-2017.
 */
public class StockInStoreDao extends AbstractDAO<StockInStore> {

    private static final Logger logger = LoggerFactory.getLogger(StockInStoreDao.class);

    @Inject
    public StockInStoreDao(HibernateBundle bundle) {
        super(bundle.getSessionFactory());
    }

    public void save(StockInStore stockInStore) {
        currentSession().save(stockInStore);
    }


}
