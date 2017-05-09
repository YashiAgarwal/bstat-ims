package bStat.ims.com.common.dao;

import bStat.ims.com.common.models.tables.ProductsTransactions;
import io.dropwizard.hibernate.AbstractDAO;
import com.google.inject.Inject;
import io.dropwizard.hibernate.HibernateBundle;

/**
 * Created by Yashi Agarwal on 08-05-2017.
 */
public class ProductsTransactionsDao extends AbstractDAO<ProductsTransactions>{
    @Inject
    public ProductsTransactionsDao(HibernateBundle bundle) {
        super(bundle.getSessionFactory());
    }

    public void save(ProductsTransactions productsTransactions) {
        currentSession().save(productsTransactions);
    }




}
