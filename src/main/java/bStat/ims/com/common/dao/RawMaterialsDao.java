package bStat.ims.com.common.dao;

import bStat.ims.com.common.models.tables.Address;
import bStat.ims.com.common.models.tables.RawMaterials;
import bStat.ims.com.common.models.tables.Store;
import bStat.ims.com.common.utils.HSession;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.hibernate.HibernateBundle;
import org.hibernate.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Yashi Agarwal on 08-05-2017.
 */
public class RawMaterialsDao extends AbstractDAO<RawMaterials> {

    private static final Logger logger = LoggerFactory.getLogger(RawMaterialsDao.class);

    @Inject
    public RawMaterialsDao(HibernateBundle bundle) {
        super(bundle.getSessionFactory());
    }

    public void save(RawMaterials rawMaterials) {
        currentSession().save(rawMaterials);
    }

    public List<RawMaterials> getAllRawMaterials(){
        Criteria cr = currentSession().createCriteria(RawMaterials.class);
        return cr.list();
    }

    public void deleteRawMaterialRowWithTxn(long rawMaterialId) {
        HSession hSession = new HSession();
        hSession.openWithTransaction();
        try {
            RawMaterials rawMaterial = get(rawMaterialId);
            if(rawMaterial!=null){
                currentSession().delete(rawMaterial);
            }
            hSession.commit();
        } catch (Exception e) {
            logger.error("Error while fetching deleteRawMaterialRowWithTxn in Store table " + e.getMessage(), e);
        } finally {
            hSession.close();
        }
    }

}
