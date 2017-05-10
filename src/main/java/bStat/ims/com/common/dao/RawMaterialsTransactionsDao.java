package bStat.ims.com.common.dao;

import bStat.ims.com.common.models.tables.RawMaterialTransactions;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.hibernate.HibernateBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Yashi Agarwal on 08-05-2017.
 */
public class RawMaterialsTransactionsDao extends AbstractDAO<RawMaterialTransactions> {

    private static final Logger logger = LoggerFactory.getLogger(RawMaterialsTransactionsDao.class);

    @Inject
    public RawMaterialsTransactionsDao(HibernateBundle bundle) {
        super(bundle.getSessionFactory());
    }

    public void save(RawMaterialTransactions rawMaterialTransactions) {
        currentSession().save(rawMaterialTransactions);
    }



}
