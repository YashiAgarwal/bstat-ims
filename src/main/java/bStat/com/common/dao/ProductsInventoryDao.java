package bStat.com.common.dao;

import bStat.com.common.models.tables.ProductsInventory;
import bStat.com.common.utils.HSession;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.hibernate.HibernateBundle;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

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

    public void saveOrUpdateInDB(ProductsInventory ProductsInventory) {
        currentSession().saveOrUpdate(ProductsInventory);
    }

    public ProductsInventory saveInDbWithTxn(ProductsInventory call) {
        HSession hSession = new HSession();
        hSession.openSeparateTransaction();
        try {
            persist(call);
            logger.info("Saving the product inventory in its table..");
            hSession.commit();
        } catch (Exception e) {
            logger.error("Error while fetching saveInDbWithTxn in ProductsInventory " + e.getMessage(), e);
        } finally {
            hSession.close();
        }
        return call;
    }

    public void updateInDb(ProductsInventory ProductsInventory) {
        currentSession().update(ProductsInventory);
    }

    public void updateInDbWithTxn(ProductsInventory call) {
        HSession hSession = new HSession();
        hSession.openSeparateTransaction();
        try {
            currentSession().update(call);
            logger.info("Saving the product inventory in its table..");
            hSession.commit();
        } catch (Exception e) {
            logger.error("Error while fetching updateInDbWithTxn in ProductsInventory " + e.getMessage(), e);
        } finally {
            hSession.close();
        }
    }

    public ProductsInventory getByCallId(String callId) {
        return get(callId);
    }

    public ProductsInventory getByCallIdWithTxn(String callId) {
        HSession hSession = new HSession();
        hSession.openWithTransaction();
        ProductsInventory ProductsInventory = null;
        try {
            ProductsInventory = get(callId);
            hSession.commit();
        } catch (Exception e) {
            logger.error("Error while fetching getByCallIdWithTxn in ProductsInventory " + e.getMessage(), e);
        } finally {
            hSession.close();
        }
        return ProductsInventory;
    }

    public List<ProductsInventory> getCallsByFkId(long fkId) {
        Criteria cr = currentSession().createCriteria(ProductsInventory.class);
        cr.add(Restrictions.eq("fkId", fkId));

        List<ProductsInventory> list = cr.list();
        if (list != null && !list.isEmpty()) {
            return list;
        }
        return null;
    }

    public ProductsInventory getRecentCallByFkId(long fkId) {
        Criteria cr = currentSession().createCriteria(ProductsInventory.class);
        cr.add(Restrictions.eq("fkId", fkId));
        cr.addOrder(Order.desc("callId"));

        List<ProductsInventory> list = cr.list();
        if (list != null && !list.isEmpty()) {
            return list.get(0);//TODO :: improve this logic further
        }
        return null;
    }

    public List<ProductsInventory> getCallsByFkIdWithTxn(long fkId) {
        HSession hSession = new HSession();
        hSession.openWithTransaction();
        List<ProductsInventory> list = null;
        try {
            Criteria cr = currentSession().createCriteria(ProductsInventory.class);
            cr.add(Restrictions.eq("fkId", fkId));
            list = cr.list();
            hSession.commit();

        } catch (Exception e) {
            logger.error("Error while fetching getCallsByFkIdWithTxn in ProductsInventory " + e.getMessage(), e);
        } finally {
            hSession.close();
        }

        return list;
    }

    public void deleteProductsInventoryRowWithTxn(String callId) {
        HSession hSession = new HSession();
        hSession.openWithTransaction();
        try {
            ProductsInventory ProductsInventory = get(callId);
            if(ProductsInventory!=null){
                currentSession().delete(ProductsInventory);
            }
            hSession.commit();
        } catch (Exception e) {
            logger.error("Error while fetching getCallsByFkIdWithTxn in ProductsInventory " + e.getMessage(), e);
        } finally {
            hSession.close();
        }
    }


    public void deleteProductsInventoryRow(String callId) {
        try {
            ProductsInventory ProductsInventory = get(callId);
            if(ProductsInventory!=null){
                currentSession().delete(ProductsInventory);
            }
        } catch (Exception e) {
            logger.error("Error while fetching getCallsByFkIdWithTxn in ProductsInventory " + e.getMessage(), e);
        }
    }


    public Map<Long, List<ProductsInventory>> fetchProductsInventory(Collection fkIds) {   //Returns map<fkid, List<ProductsInventory>>
        Map<Long, List<ProductsInventory>> resultMap = new HashMap<>();

        if (fkIds == null || fkIds.size() == 0) {
            return resultMap;
        }

        Criteria cr = currentSession().createCriteria(ProductsInventory.class);
        cr.add(Restrictions.in("fkId", fkIds));
        cr.addOrder(Order.desc("createdOn"));

        List<ProductsInventory> list = cr.list();

        if (list != null && !list.isEmpty()) {
//            logger.info("Response for fetchProductsInventory for fkids - " + new Gson().toJson(list));

            for (ProductsInventory ProductsInventory : list) {

                if (resultMap.containsKey(ProductsInventory.getFkId())) {
                    resultMap.get(ProductsInventory.getFkId()).add(ProductsInventory);
                } else {
                    LinkedList<ProductsInventory> callHistories = new LinkedList<ProductsInventory>();
                    callHistories.add(ProductsInventory);
                    resultMap.put(ProductsInventory.getFkId(), callHistories);
                }
            }

            return resultMap;
        }

//        logger.info("Returning response for fetchProductsInventory for fkids - " + new Gson().toJson(resultMap));

        return resultMap;
    }

    public Map<Long, List<FkIdToAttemptMapping>> fetchAttemptCount(Collection<Long> fkIds) {   //Returns map<fkid, List<ProductsInventory>>
        Map<Long,List<FkIdToAttemptMapping>> map = new HashMap<>();

        if (fkIds == null || fkIds.size() == 0) {
            return map;
        } else {
            for (long fkId : fkIds) {
                map.put(fkId,new LinkedList<>());
            }
        }

        Criteria criteria = currentSession().createCriteria(ProductsInventory.class)
                .add(Restrictions.in("fkId",fkIds))
                .setProjection(Projections.projectionList()
                        .add(Projections.property("fkId").as("fkId"))
                        .add(Projections.property("attemptNumber").as("attempt"))
                        .add(Projections.property("callStatus").as("callStatus"))
                ).setResultTransformer(
                        Transformers.aliasToBean(FkIdToAttemptMapping.class));
        List<FkIdToAttemptMapping> result = criteria.list();

        if (result != null && result.size() > 0) {
            for (FkIdToAttemptMapping fkIdToAttemptMapping : result) {
                logger.info("Stuff - "+new Gson().toJson(fkIdToAttemptMapping));
                map.get(fkIdToAttemptMapping.getFkId()).add(fkIdToAttemptMapping);
            }
            return map;
        }

        return map;
    }

    public Map<Long, List<ProductsInventory>> fetchProductsInventoryList(Collection<Long> fkIds) {   //Returns map<fkid, List<ProductsInventory>>
        Map<Long,List<ProductsInventory>> result = new HashMap<>();

        if (fkIds == null || fkIds.size() == 0) {
            return result;
        } else {
            for (long fkId : fkIds) {
                result.put(fkId,new LinkedList<>());
            }
        }

        Criteria criteria = currentSession().createCriteria(ProductsInventory.class)
                .add(Restrictions.in("fkId",fkIds));
        List<ProductsInventory> resultList = criteria.list();

        if (resultList != null && resultList.size() > 0) {
            for (ProductsInventory ProductsInventory : resultList) {
                result.get(ProductsInventory.getFkId()).add(ProductsInventory);
            }
            return result;
        }

        return result;
    }


}
