package bStat.com.common.dao;

import bStat.com.common.models.tables.ProductsTransactions;
import bStat.com.common.models.tables.RawMaterialTransactions;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.hibernate.HibernateBundle;

/**
 * Created by Yashi Agarwal on 08-05-2017.
 */
public class RawMaterialsTransactionsDao extends AbstractDAO<RawMaterialTransactions> {

    @Inject
    public RawMaterialsTransactionsDao(HibernateBundle bundle) {
        super(bundle.getSessionFactory());
    }

    public void save(RawMaterialTransactions rawMaterialTransactions) {
        currentSession().save(rawMaterialTransactions);
    }



}
