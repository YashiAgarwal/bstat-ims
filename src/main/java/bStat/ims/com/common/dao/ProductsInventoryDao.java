package bStat.ims.com.common.dao;

import bStat.ims.com.common.models.tables.ProductsInventory;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.hibernate.HibernateBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by prashant.agarwal on 30/04/16.
 */
public class ProductsInventoryDao extends AbstractDAO<ProductsInventory> {

    private static final Logger logger = LoggerFactory.getLogger(ProductsInventoryDao.class);

    @Inject
    public ProductsInventoryDao(HibernateBundle bundle) {
        super(bundle.getSessionFactory());
    }

    public ProductsInventory saveInDB(ProductsInventory ProductsInventory) {
        return persist(ProductsInventory);
    }

}
