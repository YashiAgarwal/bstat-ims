package bStat.ims.com.common.dao;

import bStat.ims.com.common.exceptions.ApiException;
import bStat.ims.com.common.exceptions.ResponseErrorMsg;
import bStat.ims.com.common.models.tables.Store;
import bStat.ims.com.common.utils.HSession;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.hibernate.HibernateBundle;
import org.hibernate.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
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

    public void deleteStoreRowWithTxn(long storeId) {
        HSession hSession = new HSession();
        hSession.openWithTransaction();
        try {
            Store store = get(storeId);
            if(store!=null){
                currentSession().delete(store);
            }else{
                throw new ApiException(Response.Status.BAD_REQUEST, ResponseErrorMsg.NOT_AVAILABLE,
                        "No such raw material Id found in DB: "+storeId);
            }
            hSession.commit();
        } catch (Exception e) {
            logger.error("Error while fetching deleteStoreRowWithTxn in Store table " + e.getMessage(), e);
        } finally {
            hSession.close();
        }
    }

}
