package bStat.com.common.dao;

import io.dropwizard.hibernate.AbstractDAO;
import bStat.com.common.models.tables.ProductsTransactions;
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
