package bStat.com.controllers;

import bStat.com.common.dao.StoresDao;
import bStat.com.common.models.tables.Store;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by prashant.agarwal on 09/05/17.
 */
public class StoresController {
    private static final Logger logger = LoggerFactory.getLogger(ProductTransactionsController.class);

    @Inject
    private StoresDao storesDao;

    @Inject
    public StoresController() {
    }

    public void addNewStore(Store store){
        storesDao.save(store);
    }
}
