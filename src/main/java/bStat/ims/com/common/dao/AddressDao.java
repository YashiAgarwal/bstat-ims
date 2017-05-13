package bStat.ims.com.common.dao;

import bStat.ims.com.common.models.tables.Address;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.hibernate.HibernateBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Created by Yashi Agarwal on 08-05-2017.
 */
public class AddressDao extends AbstractDAO<Address> {

    private static final Logger logger = LoggerFactory.getLogger(AddressDao.class);

    @Inject
    public AddressDao(HibernateBundle bundle) {
        super(bundle.getSessionFactory());
    }

    public Serializable save(Address address) {
        return currentSession().save(address);
    }
}
