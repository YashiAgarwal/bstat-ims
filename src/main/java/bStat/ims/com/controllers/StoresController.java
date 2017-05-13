package bStat.ims.com.controllers;

import bStat.ims.com.common.dao.StoresDao;
import bStat.ims.com.common.models.tables.Store;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import bStat.ims.com.Request.StoreRequest;

/**
 * Created by prashant.agarwal on 09/05/17.
 */
public class StoresController {
    private static final Logger logger = LoggerFactory.getLogger(StoresController.class);

    @Inject
    private StoresDao storesDao;

    @Inject
    public StoresController(StoresDao storesDao) {
        this.storesDao = storesDao;
    }

    public void addNewStore(StoreRequest storeRequest) {
        Store store = new Store(storeRequest.getAddress(), storeRequest.getName(),
                storeRequest.getPhone_number(), storeRequest.getInchargePerson());
        storesDao.save(store);
        return;
    }
}
