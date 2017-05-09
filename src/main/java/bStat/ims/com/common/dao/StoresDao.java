package bStat.ims.com.common.dao;

import bStat.ims.com.common.models.tables.Stores;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.hibernate.HibernateBundle;

/**
 * Created by Yashi Agarwal on 08-05-2017.
 */
public class StoresDao extends AbstractDAO<Stores> {

    @Inject
    public StoresDao(HibernateBundle bundle) {
        super(bundle.getSessionFactory());
    }

    public void save(Stores stores) {
        currentSession().save(stores);
    }



}
