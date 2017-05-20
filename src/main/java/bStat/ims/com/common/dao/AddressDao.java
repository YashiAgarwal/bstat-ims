package bStat.ims.com.common.dao;

import bStat.ims.com.common.models.tables.Address;
import bStat.ims.com.common.models.tables.Store;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.hibernate.HibernateBundle;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yashi Agarwal on 08-05-2017.
 */
public class AddressDao extends AbstractDAO<Address> {

    private static final Logger logger = LoggerFactory.getLogger(AddressDao.class);

    @Inject
    public AddressDao(HibernateBundle bundle) {
        super(bundle.getSessionFactory());
    }

    public void save(Address address) {
        currentSession().save(address);
    }

    public List<Address> getAllAddresses(){
        Criteria cr = currentSession().createCriteria(Store.class);
        return cr.list();
    }

    public Address getAddressWithAddressId(long addressId){
        Criteria cr = currentSession().createCriteria(Store.class);
        cr.add(Restrictions.eq("id", addressId));
        List<Address> list = cr.list();
        if(list != null && !list.isEmpty())
            return list.get(0);
        return null;
    }
}
